package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentosBDD;
import com.krakedev.inventarios.entidades.TipoDocumentos;
import com.krakedev.inventarios.excepciones.KrakedevExcepcion;

@Path("tiposdocumento")
public class ServiciosTipoDocumentos {
	
	@Path("recuperar")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperar() {
		TipoDocumentosBDD docs = new TipoDocumentosBDD();
	    ArrayList<TipoDocumentos> tipoDocs = null;  

	    try {
	    	tipoDocs = docs.recuperarTodos();
	        return Response.ok(tipoDocs).build();
	    } catch (KrakedevExcepcion e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }	   
	}
}
