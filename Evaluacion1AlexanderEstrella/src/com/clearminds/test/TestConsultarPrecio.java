package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestConsultarPrecio {
	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda("A1");
        maquina.agregarCelda("A2");
        maquina.agregarCelda("B1");
        maquina.agregarCelda("B2");
		
		Producto producto=new Producto("KE34","Papitas",2.54);
		maquina.cargarProducto(producto, "B1", 4);
		
		System.out.println("Precio en B1:"+maquina.consultarPrecio("B1"));
		
		
		
		
	}
}
