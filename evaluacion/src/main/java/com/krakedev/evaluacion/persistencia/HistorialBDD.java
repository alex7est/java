package com.krakedev.evaluacion.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;


public class HistorialBDD {
	
	public void insertar(Categoria categoria) throws KrakeException{
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				try {
					PreparedStatement ps = con
							.prepareStatement("insert into categorias (id, nombre) values(?,?)");
					ps.setString(1, categoria.getId());
					ps.setString(2, categoria.getNombre());
					ps.executeUpdate();
					
				} catch (SQLException e) {
					throw new KrakeException("Error al insertar categoria");
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakeException e) {
			throw e;
		}
	}
	
	public void actualizar(Categoria categoria) throws KrakeException{
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				try {
					PreparedStatement ps = con
							.prepareStatement("update categorias set nombre=? where id=?");
					ps.setString(1, categoria.getNombre());
					ps.setString(2, categoria.getId());
					ps.executeUpdate();
					
				} catch (SQLException e) {
					throw new KrakeException("Error al actualizar categoria");
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakeException e) {
			throw e;
		}
	}
	
	public Categoria buscarPorId(String id) throws KrakeException{
		Connection con = null;
		ResultSet rs = null;
		Categoria categoria = null;
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				try {
					PreparedStatement ps = con
							.prepareStatement("select id, nombre from categorias where id=?");
					ps.setString(1, id);
					rs = ps.executeQuery();
					
					if (rs.next()) {
						String idCategoria = rs.getString("id");
						String nombre = rs.getString("nombre");
						
						categoria = new Categoria(idCategoria,nombre);
					}				
					
				} catch (SQLException e) {
					throw new KrakeException("Error al buscar categoria");
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakeException e) {
			throw e;
		}
		return categoria;
	}
	
	public ArrayList<Categoria> recuperarTodos() throws KrakeException{
		Connection con = null;
		ResultSet rs = null;
		Categoria categoria = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				try {
					PreparedStatement ps = con
							.prepareStatement("select id, nombre from categorias");
					rs = ps.executeQuery();
					
					while (rs.next()) {
						String idCategoria = rs.getString("id");
						String nombre = rs.getString("nombre");
						
						categoria = new Categoria(idCategoria,nombre);
						categorias.add(categoria);
					}				
					
				} catch (SQLException e) {
					throw new KrakeException("Error al buscar todas las categorias");
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakeException e) {
			throw e;
		}
		return categorias;
	}
}
