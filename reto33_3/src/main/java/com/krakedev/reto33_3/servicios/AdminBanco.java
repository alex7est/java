package com.krakedev.reto33_3.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.reto33_3.entidades.Banco;
import com.krakedev.reto33_3.utils.ConexionBDD;

public class AdminBanco {
	private static final Logger LOGGER = LogManager.getLogger(AdminBanco.class);

	public static void insertar(Banco banco) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("INSERT INTO banco (codigo_banco, codigo_transaccion, detalle) VALUES (?, ?, ?)");
			ps.setInt(1, banco.getCodigo_banco());
			ps.setInt(2, banco.getTransaccion().getCodigo());
			ps.setString(3, banco.getDetalle());
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error al cerrar la conexión", e);
				throw new Exception("Error al cerrar la conexión");
			}
		}
	}

	public static void actualizar(Banco banco) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("UPDATE banco SET codigo_transaccion = ?, detalle = ? WHERE codigo_banco = ?");
			ps.setInt(1, banco.getTransaccion().getCodigo());
			ps.setString(2, banco.getDetalle());
			ps.setInt(3, banco.getCodigo_banco());
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error al cerrar la conexión", e);
				throw new Exception("Error al cerrar la conexión");
			}
		}
	}

	public static void eliminar(int codigo_banco) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("DELETE FROM banco WHERE codigo_banco = ?");
			ps.setInt(1, codigo_banco);
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error al cerrar la conexión", e);
				throw new Exception("Error al cerrar la conexión");
			}
		}
	}
}
