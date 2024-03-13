package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto = new Producto("Camisa", 25.0);
        
		producto.setPrecio(-30.0);
        System.out.println("Precio de " + producto.getNombre() + ": $" + producto.getPrecio());
        
        double precioPromo = producto.calcularPrecioPromo(10.0);
        System.out.println("Precio con descuento del 10%: $" + precioPromo);
	}

}
