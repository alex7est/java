package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	
	public static void insertar(Persona persona) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("INSERT INTO persona (cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos, estado_civil_codigo) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setDouble(4, persona.getEstatura());
			ps.setDate(5, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			try {
				ps.setTime(6, new java.sql.Time(persona.getHoraNacimiento().getTime()));
				ps.setString(9, persona.getEstadoCivil().getCodigo());
			}catch(Exception e) {
				ps.setTime(6, null);
				ps.setTime(9, null);
			}
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setInt(8, persona.getNumeroHijos());
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
			
		}

	}

	public static void actualizar(Persona persona) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("UPDATE persona SET nombre = ?, apellido = ?, estatura = ?, fecha_nacimiento = ?, hora_nacimiento = ?, cantidad_ahorrada = ?, numero_hijos = ?, estado_civil_codigo = ? WHERE cedula = ?;");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setDouble(3, persona.getEstatura());
			ps.setDate(4, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			try {
			    ps.setTime(5, new java.sql.Time(persona.getHoraNacimiento().getTime()));
			    ps.setString(8, persona.getEstadoCivil().getCodigo());
			} catch (Exception e) {
			    ps.setTime(5, null);
			    ps.setString(8, null);
			}
			ps.setBigDecimal(6, persona.getCantidadAhorrada());
			ps.setInt(7, persona.getNumeroHijos());
			ps.setString(9, persona.getCedula());
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
			
		}

	}
	
	public static void eliminar(String cedula) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("DELETE FROM persona WHERE cedula = ?");
			ps.setString(1, cedula);
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
			
		}
	}
}
