package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.VentasBDD;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("ventas")
public class ServiciosVentas {
	
	@Path("guardar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(Venta venta) {
		VentasBDD ven = new VentasBDD();

		try {
			ven.insertar(venta);
			return Response.ok().build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
