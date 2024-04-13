package com.krakedev.evaluacion.servicios;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

@Path("bases")
public class ServiciosConexion {
	
	@Path("probarConexion")
	@POST
	public void probarConn() {
		try {
			Connection con = ConexionBDD.obtenerConexion();
			System.out.println("Se conecto!");
		} catch (KrakeException e) {
			e.printStackTrace();
		}
	}
}
