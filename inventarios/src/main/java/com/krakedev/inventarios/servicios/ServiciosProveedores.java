package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("proveedores")
public class ServiciosProveedores {

	@Path("buscar/{subcadena}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subcadena") String subcadena) {
		ProveedoresBDD prov = new ProveedoresBDD();
	    ArrayList<Proveedor> proveedores = null;  

	    try {
	    	proveedores = prov.buscar(subcadena);
	        return Response.ok(proveedores).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Proveedor proveedor) {
		ProveedoresBDD prov = new ProveedoresBDD();
		
	    try {
	    	prov.insertar(proveedor);
	        return Response.ok().build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("buscarI/{identificador}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorIdentificador(@PathParam("identificador") String identificador) {
		ProveedoresBDD prov = new ProveedoresBDD();
	    Proveedor proveedor = null;  

	    try {
	    	proveedor = prov.buscarPorIdentificador(identificador);
	        return Response.ok(proveedor).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
}
