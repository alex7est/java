package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriasBDD {

	public void insertar(Categoria categoria) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("insert into categorias(nombre, categoria_padre) values(?,?)");

				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
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

	public void actualizar(Categoria categoria) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("UPDATE categorias SET nombre = ?, categoria_padre = ? WHERE codigo_cat = ?");

				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
				ps.setInt(3, categoria.getCodigo());

				ps.executeUpdate();
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al actualizar. Detalle: " + e.getMessage());
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

	public ArrayList<Categoria> recuperarTodas() throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("SELECT codigo_cat, nombre, categoria_padre FROM categorias");
				rs = ps.executeQuery();

				while (rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setCodigo(rs.getInt("codigo_cat"));
					categoria.setNombre(rs.getString("nombre"));

					int categoriaPadreCodigo = rs.getInt("categoria_padre");
					Categoria categoriaPadre = new Categoria();
					categoriaPadre.setCodigo(categoriaPadreCodigo);
					categoria.setCategoriaPadre(categoriaPadre);

					categorias.add(categoria);
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al recuperar categorías. Detalle: " + e.getMessage());
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

		return categorias;
	}
	
	

}
