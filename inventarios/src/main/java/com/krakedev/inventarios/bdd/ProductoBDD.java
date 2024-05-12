package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.UnidadMedida;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductoBDD {
	
	public ArrayList<Producto> buscar(String subcadena) throws KrakedevExcepcion {
		ArrayList<Producto> productos = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps=con.prepareStatement ("select prod.codigo_producto, prod.nombre as nombre_producto,udm.codigo_udm as nombre_udm, udm.descripcion as descripcion_udm, "
						+ "cast(prod.precio_venta as decimal(5,2)), prod.tiene_iva, cast(prod.coste as decimal(5,2)),prod.categoria, cat.nombre as nombre_categoria, stock "
						+ "from productos prod, unidades_medida udm,categorias cat where prod.udm = udm.codigo_udm and prod.categoria = cat.codigo_cat and upper (prod.nombre) like ?"); 
				ps.setString(1, "%"+subcadena.toUpperCase()+"%"); 
				rs = ps.executeQuery();

				while (rs.next()) {
					int codigoProducto = rs.getInt("codigo_producto");
					String nombreProducto = rs.getString("nombre_producto");
					String nombreUdm = rs.getString("nombre_udm");
					String descripcionUdm = rs.getString("descripcion_udm");
					BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
					boolean tieneIVA = rs.getBoolean("tiene_iva");
					BigDecimal coste = rs.getBigDecimal("coste");
					int categoria = rs.getInt("categoria");
					String nombreCategoria = rs.getString("nombre_categoria");
					int stock = rs.getInt("stock");
					UnidadMedida udm = new UnidadMedida(nombreUdm,descripcionUdm,null);
					Categoria cat = new Categoria(categoria, nombreCategoria, null);					
					Producto producto = new Producto(codigoProducto, nombreProducto, udm, precioVenta, tieneIVA, coste, cat, stock);
					productos.add(producto);
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
		return productos;
	}
	
	public void insertar(Producto producto) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps=con.prepareStatement ("insert into productos(nombre, udm, precio_venta, tiene_iva, coste, categoria, stock) values(?,?,?,?,?,?,?)"); 				
			
				ps.setString(1, producto.getNombre());
				ps.setString(2, producto.getUnidadMedida().getCodigo());
				ps.setBigDecimal(3, producto.getPrecioVenta());
				ps.setBoolean(4, producto.isTieneIVA());
				ps.setBigDecimal(5, producto.getCoste());
				ps.setInt(6, producto.getCategoria().getCodigo());
				ps.setInt(7, producto.getStock());
				ps.executeUpdate();
			
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al insertar. Detalle: " + e.getMessage());
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
