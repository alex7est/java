package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda("A1");
        maquina.agregarCelda("A2");
        maquina.agregarCelda("B1");
        maquina.agregarCelda("B2");
        maquina.agregarCelda("C1");
        maquina.agregarCelda("C2");
		
		Producto producto=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto, "B1", 4);
		
		Producto producto2=new Producto("D456","Doritos",0.70);
		maquina.cargarProducto(producto2, "A1", 6);
		
		Producto producto3 = new Producto("ABC123", "Chocolate", 1.20);
		maquina.cargarProducto(producto3, "A2", 8);

		Producto producto4 = new Producto("XYZ789", "Galletas", 0.60);
		maquina.cargarProducto(producto4, "B2", 5);

		Producto producto5 = new Producto("EFG456", "Chicles", 0.25);
		maquina.cargarProducto(producto5, "C1", 10);

		Producto producto6 = new Producto("HIJ789", "Caramelos", 0.50);
		maquina.cargarProducto(producto6, "C2", 7);
		
		ArrayList<Producto> productos = maquina.buscarMenores(0.80);
		System.out.println("Productos menores: "+productos.size());
		for (int i=0;i<productos.size();i++) {
			System.out.println("Nombre: "+productos.get(i).getNombre()+" Precio: "+productos.get(i).getPrecio());
		}
	}

}
