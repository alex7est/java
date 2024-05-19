package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recibir(Pedido pedido) {
		PedidosBDD ped = new PedidosBDD();

		try {
			ped.actualizar(pedido);
			return Response.ok().build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscar/proveedor/{identificador}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarPedidosPorProveedor(@PathParam("identificador") String identificador) {
	    PedidosBDD pedidoBDD = new PedidosBDD();
	    ArrayList<Pedido> pedidos = null;
	    
	    try {
	        pedidos = pedidoBDD.recuperarPedidosPorProveedor(identificador);
	        return Response.ok(pedidos).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}

}
