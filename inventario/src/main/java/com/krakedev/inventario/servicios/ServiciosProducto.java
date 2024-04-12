package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
    private ArrayList<Producto> productos;
    
    public ServiciosProducto() {
        this.productos = new ArrayList<>();
    }
    
    @Path("insertar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar(Producto producto) {
        System.out.println("Producto insertado:");
        System.out.println(producto);
    }
    
    @Path("actualizar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void actualizar(Producto producto) {
        System.out.println("Producto actualizado:");
        System.out.println(producto);
    }
    
    @Path("consultar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> recuperarTodos() {
        System.out.println("Recuperando todos los productos:");
        productos.add(new Producto("P001", "Producto 1", new Categoria(1, "Categoría 1"), 10.5, 100));
        productos.add(new Producto("P002", "Producto 2", new Categoria(2, "Categoría 2"), 20.3, 50));
        productos.add(new Producto("P003", "Producto 3", new Categoria(3, "Categoría 3"), 15.75, 75));
        return productos;
    }
    
}
