package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetalleVenta;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {
	public void insertar(Venta venta) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psCab = null;
		PreparedStatement psHis = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		BigDecimal subtotal_con_iva = new BigDecimal(0);
		BigDecimal total_sin_iva = new BigDecimal(0);
		BigDecimal iva = new BigDecimal(0);;
		BigDecimal total = new BigDecimal(0);;

		Date fechaActual = new Date();
		java.sql.Timestamp fechaSQL = new java.sql.Timestamp(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("insert into cabecera_ventas(fecha, total_sin_iva, iva, total) values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
				ps.setTimestamp(1, fechaSQL);
				ps.setBigDecimal(2, new BigDecimal(0));
				ps.setBigDecimal(3, new BigDecimal(0));
				ps.setBigDecimal(4, new BigDecimal(0));				

				ps.executeUpdate();
				rsClave = ps.getGeneratedKeys();

				if (rsClave.next()) {
					codigoCabecera = rsClave.getInt(1);
				}

				ArrayList<DetalleVenta> detallesVenta = venta.getDetalles();
				DetalleVenta det;

				for (int i = 0; i < detallesVenta.size(); i++) {
					det = detallesVenta.get(i);
					psDet = con.prepareStatement("insert into detalle_ventas(cabecera_ventas, producto, cantidad, precio_venta, subtotal, subtotal_con_iva) values(?,?,?,?,?,?);");
					psDet.setInt(1, codigoCabecera);
					psDet.setInt(2, det.getProducto().getCodigo());
					psDet.setInt(3, det.getCantidad());
					psDet.setBigDecimal(4, det.getProducto().getPrecioVenta());
					BigDecimal pv = det.getProducto().getPrecioVenta();
					BigDecimal cantidad = new BigDecimal(det.getCantidad());
					BigDecimal subtotal = pv.multiply(cantidad);
					psDet.setBigDecimal(5, subtotal);
					if(det.getProducto().isTieneIVA()) {
						subtotal_con_iva = subtotal.multiply(new BigDecimal(1.12));
						psDet.setBigDecimal(6, subtotal_con_iva);
					}else {
						subtotal_con_iva = subtotal;
						psDet.setBigDecimal(6, subtotal_con_iva);
					}
					psDet.executeUpdate();
					
					psHis = con.prepareStatement("insert into historial_stock(fecha, referencia, producto, cantidad) values(?,?,?,?);");
					psHis.setTimestamp(1, fechaSQL);
					psHis.setString(2, "VENTA "+codigoCabecera);
					psHis.setInt(3, det.getProducto().getCodigo());
					psHis.setInt(4, det.getCantidad()*(-1));
					
					psHis.executeUpdate();
					
					total_sin_iva = total_sin_iva.add(subtotal);
					iva = iva.add(subtotal_con_iva.subtract(subtotal));
					total = total.add(subtotal_con_iva);
				}
				psCab = con.prepareStatement("update cabecera_ventas set total_sin_iva=?, iva=?, total=? where codigo=?;");
				psCab.setBigDecimal(1, total_sin_iva);
				psCab.setBigDecimal(2, iva);
				psCab.setBigDecimal(3, total);
				psCab.setInt(4, codigoCabecera);				
				
				psCab.executeUpdate();
				
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al consultar. Detalle: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
