package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.EstadoPedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {

	public void insertar(Pedido pedido) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;

		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("insert into cabecera_pedido (proveedor, fecha, estado) values (?,?,?);",
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, pedido.getProveedor().getIdentificador());
				ps.setDate(2, fechaSQL);
				ps.setString(3, "S");

				ps.executeUpdate();
				rsClave = ps.getGeneratedKeys();

				if (rsClave.next()) {
					codigoCabecera = rsClave.getInt(1);
				}

				ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
				DetallePedido det;

				for (int i = 0; i < detallesPedido.size(); i++) {
					det = detallesPedido.get(i);
					psDet = con.prepareStatement(
							"insert into detalle_pedido (cabecera_pedido, producto, cantidad_solicitada, cantidad_recibida, subtotal) values(?,?,?,?,?);");
					psDet.setInt(1, codigoCabecera);
					psDet.setInt(2, det.getProducto().getCodigo());
					psDet.setInt(3, det.getCantidadSolicitada());
					psDet.setInt(4, 0);
					BigDecimal pv = det.getProducto().getPrecioVenta();
					BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
					BigDecimal subtotal = pv.multiply(cantidad);
					psDet.setBigDecimal(5, subtotal);
					psDet.executeUpdate();

				}
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

	public void actualizar(Pedido pedido) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psHis = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");

				ps = con.prepareStatement("update cabecera_pedido set estado='R' where numero=?");
				ps.setInt(1, pedido.getCodigo());
				ps.executeUpdate();
				
				ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
				DetallePedido det;
				Date fechaActual = new Date();
				java.sql.Timestamp timestamp = new java.sql.Timestamp(fechaActual.getTime());

				for (int i = 0; i < detallesPedido.size(); i++) {
					det = detallesPedido.get(i);
					psDet = con.prepareStatement(
							"update detalle_pedido set cantidad_recibida=?, subtotal=? where codigo=?");
					psDet.setInt(1, det.getCantidadRecibida());
					BigDecimal pv = det.getProducto().getPrecioVenta();
					BigDecimal cantidad = new BigDecimal(det.getCantidadRecibida());
					BigDecimal subtotal = pv.multiply(cantidad);
					psDet.setBigDecimal(2, subtotal);
					psDet.setInt(3, det.getCodigo());

					psDet.executeUpdate();
					
					psHis = con.prepareStatement("insert into historial_stock(fecha, referencia, producto, cantidad) values(?,?,?,?);");
					psHis.setTimestamp(1, timestamp);
					psHis.setString(2, "PEDIDO "+pedido.getCodigo());
					psHis.setInt(3, det.getProducto().getCodigo());
					psHis.setInt(4, det.getCantidadRecibida());
					
					psHis.executeUpdate();
					
				}
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
	
	public ArrayList<Pedido> recuperarPedidosPorProveedor(String identificador) throws KrakedevExcepcion {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Pedido> pedidos = new ArrayList<>();

	    try {
	        con = ConexionBDD.obtenerConexion();
	        if (con != null) {
	            System.out.println("CONECTADO");
	            String sql = "SELECT p.numero AS pedido_codigo, p.fecha, p.estado, d.codigo AS detalle_codigo, d.producto, d.cantidad_solicitada, cast(d.subtotal as decimal(5,2)), d.cantidad_recibida "
	            		   + "FROM cabecera_pedido AS p JOIN detalle_pedido d ON p.numero = d.cabecera_pedido WHERE p.proveedor = ?;";	            
	            ps = con.prepareStatement(sql);
	            ps.setString(1, identificador);
	            rs = ps.executeQuery();

	            Map<Integer, Pedido> pedidoMap = new HashMap<>();
	            while (rs.next()) {
	                int pedidoCodigo = rs.getInt("pedido_codigo");

	                Pedido pedido = pedidoMap.get(pedidoCodigo);
	                if (pedido == null) {
	                    pedido = new Pedido();
	                    pedido.setCodigo(pedidoCodigo);
	                    Proveedor proveedor = new Proveedor();
	                    proveedor.setIdentificador(identificador);
	                    pedido.setProveedor(proveedor);
	                    pedido.setFecha(rs.getDate("fecha"));
	                    EstadoPedido estado = new EstadoPedido(); 
	                    estado.setCodigo(rs.getString("estado"));
	                    pedido.setEstado(estado);
	                    pedido.setDetalles(new ArrayList<DetallePedido>());
	                    pedidoMap.put(pedidoCodigo, pedido);
	                }

	                DetallePedido detalle = new DetallePedido();
	                detalle.setCodigo(rs.getInt("detalle_codigo"));
	                Pedido pedidoDet = new Pedido();
	                pedidoDet.setCodigo(pedidoCodigo);
	                detalle.setCabecera(pedidoDet);
	                Producto producto = new Producto();
	                producto.setCodigo(rs.getInt("producto"));
	                detalle.setProducto(producto);
	                detalle.setCantidadSolicitada(rs.getInt("cantidad_solicitada"));	                
	                detalle.setSubtotal(rs.getBigDecimal("subtotal"));
	                detalle.setCantidadRecibida(rs.getInt("cantidad_recibida"));

	                pedido.getDetalles().add(detalle);
	            }

	            pedidos.addAll(pedidoMap.values());
	        } else {
	            System.out.println("ERROR AL OBTENER CONEXION");
	        }
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        throw e;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakedevExcepcion("Error al recuperar pedidos. Detalle: " + e.getMessage());
	    } finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return pedidos;
	}

}
