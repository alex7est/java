package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarProductoEnCelda {
	public static void main(String[] args) {
		MaquinaDulces maquina = new MaquinaDulces();
		maquina.agregarCelda("A");
		maquina.agregarCelda("B");
		maquina.agregarCelda("C");
		maquina.agregarCelda("D");

		Producto productoA = new Producto("KE34", "Papitas", 0.85);
		Producto productoB = new Producto("BDCR", "Galletas", 2.54);

		maquina.cargarProducto(productoB, "D", 5);
		maquina.cargarProducto(productoA, "B", 4);
		Producto p1 = maquina.buscarProductoEnCelda("B");
		Producto p2 = maquina.buscarProductoEnCelda("F");
		
		System.out.println("Producto encontrado: " + p1.getNombre());
		
		if (p2 != null) {
			System.out.println("Producto encontrado: " + p2.getNombre());
		}else {
			System.out.println("Producto encontrado: null");
		}
	}
}
