package com.krakedev;

public class TestProducto {
	public static void main(String[] args) {
		Producto producto1, producto2, producto3;

		producto1 = new Producto();
		producto1.nombre = "Paracetamol";
		producto1.descripcion = "Medicamento para aliviar el dolor y la fiebre";
		producto1.precio = 5.0;
		producto1.stockActual = 100;

		producto2 = new Producto();
		producto2.nombre = "Ibuprofeno";
		producto2.descripcion = "Medicamento antiinflamatorio y analgésico";
		producto2.precio = 7.5;
		producto2.stockActual = 80;

		producto3 = new Producto();
		producto3.nombre = "Vitaminas";
		producto3.descripcion = "Suplemento vitamínico para mejorar la salud";
		producto3.precio = 10.0;
		producto3.stockActual = 50;

		System.out.println("Producto 1");
		System.out.println("Nombre: " + producto1.nombre);
		System.out.println("Descripción: " + producto1.descripcion);
		System.out.println("Precio: " + producto1.precio);
		System.out.println("Stock Actual: " + producto1.stockActual);

		System.out.println("\nProducto 2");
		System.out.println("Nombre: " + producto2.nombre);
		System.out.println("Descripción: " + producto2.descripcion);
		System.out.println("Precio: " + producto2.precio);
		System.out.println("Stock Actual: " + producto2.stockActual);

		System.out.println("\nProducto 3");
		System.out.println("Nombre: " + producto3.nombre);
		System.out.println("Descripción: " + producto3.descripcion);
		System.out.println("Precio: " + producto3.precio);
		System.out.println("Stock Actual: " + producto3.stockActual);
	}
}
