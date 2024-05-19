package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriasBDD;
import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("categorias")
public class ServiciosCategorias {
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Categoria categoria) {
		CategoriasBDD cat = new CategoriasBDD();
		
	    try {
	    	cat.insertar(categoria);
	        return Response.ok().build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categoria categoria) {
	    CategoriasBDD cat = new CategoriasBDD();
	    
	    try {
	        cat.actualizar(categoria);
	        return Response.ok().build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}
	
	@Path("todas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarTodas() {
	    CategoriasBDD cat = new CategoriasBDD();
	    
	    try {
	        ArrayList<Categoria> categorias = cat.recuperarTodas();
	        return Response.ok(categorias).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}

}
