package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedoresBDD {
	public ArrayList<Proveedor> buscar(String subcadena) throws KrakedevExcepcion {
		ArrayList<Proveedor> proveedores = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps=con.prepareStatement ("select identificador,tipo_documento, nombre, telefono, correo, direccion from proveedores where upper (nombre) like ?"); 
				ps.setString(1, "%"+subcadena.toUpperCase()+"%"); 
				rs = ps.executeQuery();

				while (rs.next()) {
					String identificador = rs.getString("identificador");
					String tipoDocumento = rs.getString("tipo_documento");
					String nombre = rs.getString("nombre");
					String telefono = rs.getString("telefono");
					String correo = rs.getString("correo");
					String direccion = rs.getString("direccion");

					Proveedor proveedor = new Proveedor(identificador, tipoDocumento, nombre, telefono, correo, direccion);
					proveedores.add(proveedor);
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
		return proveedores;
	}
}
