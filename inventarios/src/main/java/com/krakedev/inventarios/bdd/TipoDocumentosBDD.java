package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.TipoDocumentos;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoDocumentosBDD {
	public ArrayList<TipoDocumentos> recuperarTodos() throws KrakedevExcepcion{
		ArrayList<TipoDocumentos> tipoDocs = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps=con.prepareStatement ("select codigo, descripcion from tipo_documentos"); 
				rs = ps.executeQuery();

				while (rs.next()) {
					char codigo = rs.getString("codigo").charAt(0);
					String descripcion = rs.getString("descripcion");

					TipoDocumentos tipoDoc = new TipoDocumentos(codigo, descripcion);
					tipoDocs.add(tipoDoc);
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
		return tipoDocs;
	}
}
