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

import com.krakedev.inventarios.bdd.ProductoBDD;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("productos")
public class ServiciosProductos {
	
	@Path("buscar/{subcadena}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subcadena") String subcadena) {
		ProductoBDD prod = new ProductoBDD();
	    ArrayList<Producto> productos = null;  

	    try {
	    	productos = prod.buscar(subcadena);
	        return Response.ok(productos).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Producto producto) {
		ProductoBDD prod = new ProductoBDD();
		
	    try {
	    	prod.insertar(producto);
	        return Response.ok().build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Producto producto) {
		ProductoBDD prod = new ProductoBDD();
		
	    try {
	    	prod.actualizar(producto);
	        return Response.ok().build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}
	
	@Path("buscarC/{codigo}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCodigo(@PathParam("codigo") int codigo) {
		ProductoBDD prod = new ProductoBDD();
	    Producto producto = null;  

	    try {
	    	producto = prod.buscarPorCodigo(codigo);
	        return Response.ok(producto).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
}
