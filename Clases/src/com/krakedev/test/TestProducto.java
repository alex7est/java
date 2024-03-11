package com.krakedev.test;

import com.krakedev.Producto;

public class TestProducto {
    public static void main(String[] args) {
        Producto producto1, producto2, producto3;

        producto1 = new Producto();
        producto1.setNombre("Paracetamol");
        producto1.setDescripcion("Medicamento para aliviar el dolor y la fiebre");
        producto1.setPrecio(5.0);
        producto1.setStockActual(100);

        producto2 = new Producto();
        producto2.setNombre("Ibuprofeno");
        producto2.setDescripcion("Medicamento antiinflamatorio y analgésico");
        producto2.setPrecio(7.5);
        producto2.setStockActual(80);

        producto3 = new Producto();
        producto3.setNombre("Vitaminas");
        producto3.setDescripcion("Suplemento vitamínico para mejorar la salud");
        producto3.setPrecio(10.0);
        producto3.setStockActual(50);

        System.out.println("Producto 1");
        System.out.println("Nombre: " + producto1.getNombre());
        System.out.println("Descripción: " + producto1.getDescripcion());
        System.out.println("Precio: " + producto1.getPrecio());
        System.out.println("Stock Actual: " + producto1.getStockActual());

        System.out.println("\nProducto 2");
        System.out.println("Nombre: " + producto2.getNombre());
        System.out.println("Descripción: " + producto2.getDescripcion());
        System.out.println("Precio: " + producto2.getPrecio());
        System.out.println("Stock Actual: " + producto2.getStockActual());

        System.out.println("\nProducto 3");
        System.out.println("Nombre: " + producto3.getNombre());
        System.out.println("Descripción: " + producto3.getDescripcion());
        System.out.println("Precio: " + producto3.getPrecio());
        System.out.println("Stock Actual: " + producto3.getStockActual());
    }
}
