package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestConexion {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"junimo77");
			System.out.println("Conexion exitosa");
			ps = connection.prepareStatement("INSERT INTO transacciones (codigo, numero_cuenta, monto, tipo, fecha, hora) "
					+"VALUES (?, ?, ?, ?, ?, ?);");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			java.util.Date fecha = sdf.parse("24/03/2024 12:32:54");
			long milis = fecha.getTime();
			Date fechasql = new Date(milis);
			Time horasql = new Time(milis);
			
			ps.setInt(1, 3);
			ps.setString(2, "12345");
			ps.setBigDecimal(3, new BigDecimal(200));
			ps.setString(4, "C");
			ps.setDate(5, fechasql);
			ps.setTime(6, horasql);
			ps.executeUpdate();
			System.out.println("Insert transacciones ejecutado");
			
			ps = connection.prepareStatement("INSERT INTO banco (codigo_banco, codigo_transaccion, detalle) "
					+"VALUES (?, ?, ?);");
			ps.setInt(1, 2);
			ps.setInt(2, 3);
			ps.setString(3, null);
			ps.executeUpdate();
			System.out.println("Insert banco ejecutado");
			
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}

	}

}
