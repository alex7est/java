package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto1 = new Producto("Tijera",3);
		
		producto1.setDescripcion("Sirve para cortar");
		producto1.setPeso(0.3);
		
		System.out.println("Nombre: "+producto1.getNombre());
		System.out.println("Codigo: "+producto1.getCodigo());
		System.out.println("Descripciob: "+producto1.getDescripcion());
		System.out.println("Peso: "+producto1.getPeso());
	}

}
