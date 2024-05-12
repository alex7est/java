package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidosBDD;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("pedidos")
public class ServiciosPedidos {
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrar(Pedido pedido) {
		PedidosBDD ped = new PedidosBDD();

		try {
			ped.insertar(pedido);
			return Response.ok().build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
