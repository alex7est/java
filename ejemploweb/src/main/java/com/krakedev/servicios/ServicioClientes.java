package com.krakedev.servicios;

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

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakedevExcepcion;
import com.krakedev.persistencia.ClientesBDD;

@Path("customers")
public class ServicioClientes {

	@Path("m1")
	@GET
	public String saludar() {
		return "Hola mundo RWS";
	}

	@Path("buscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscar() {
		Cliente cliente = new Cliente("0129847321", "Jorge", 2);
		return cliente;
	}

	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente cliente) {
		System.out.println(">>>>>" + cliente);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		System.out.println(">>>>>" + cliente);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.actualizar(cliente);
			return Response.ok().build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("all")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes() {
	    ClientesBDD cli = new ClientesBDD();
	    ArrayList<Cliente> clientes = null;

	    try {
	        clientes = cli.recuperarTodos();
	        return Response.ok(clientes).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula) {
	    ClientesBDD cli = new ClientesBDD();
	    Cliente cliente = null;

	    try {
	        cliente = cli.buscarPorPK(cedula);
	        return Response.ok(cliente).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}
	
	@GET
    @Path("hijos/{numeroHijos}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorNumeroHijos(@PathParam("numeroHijos") int numeroHijos) throws KrakedevExcepcion {
        ClientesBDD cli = new ClientesBDD();
        ArrayList<Cliente> clientes = null;
        try {
			clientes = cli.buscarPorNumeroHijos(numeroHijos);
			return Response.ok(clientes).build();
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
        
    }
	
}
