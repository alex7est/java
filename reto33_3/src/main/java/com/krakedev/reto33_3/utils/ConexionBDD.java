package com.krakedev.reto33_3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USUARIO = "postgres";
	private static final String CLAVE = "junimo77";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);

	public static Connection conectar() throws Exception {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("Error en la infraestructura", e);
			throw new Exception("Error en la infraestructura");
		}
		return connection;
	}
}
