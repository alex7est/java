package com.krakedev.reto33_3.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.reto33_3.entidades.Transaccion;
import com.krakedev.reto33_3.utils.ConexionBDD;

public class AdminTransaccion {
	private static final Logger LOGGER = LogManager.getLogger(AdminTransaccion.class);

	public static void insertar(Transaccion transaccion) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"INSERT INTO transacciones (codigo, numero_cuenta, monto, tipo, fecha, hora) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, transaccion.getCodigo());
			ps.setString(2, transaccion.getNumeroCuenta());
			ps.setBigDecimal(3, transaccion.getMonto());
			ps.setString(4, String.valueOf(transaccion.getTipo()));
			ps.setDate(5, new Date(transaccion.getFecha().getTime()));
			ps.setTime(6, new Time(transaccion.getHora().getTime()));
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

	public static void actualizar(Transaccion transaccion) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"UPDATE transacciones SET numero_cuenta = ?, monto = ?, tipo = ?, fecha = ?, hora = ? WHERE codigo = ?");
			ps.setString(1, transaccion.getNumeroCuenta());
			ps.setBigDecimal(2, transaccion.getMonto());
			ps.setString(3, String.valueOf(transaccion.getTipo()));
			ps.setDate(4, new Date(transaccion.getFecha().getTime()));
			ps.setTime(5, new Time(transaccion.getHora().getTime()));
			ps.setInt(6, transaccion.getCodigo());
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

	public static void eliminar(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("DELETE FROM transacciones WHERE codigo = ?");
			ps.setInt(1, codigo);
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