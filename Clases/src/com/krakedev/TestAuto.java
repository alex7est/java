package com.krakedev;

public class TestAuto {

    public static void main(String[] args) {
    	Auto auto1 = new Auto("Toyota", 2022, 25000.0);
        Auto auto2 = new Auto("Ford", 2023, 35000.0);

        System.out.println("Auto 1");
        System.out.println("Marca: " + auto1.getMarca());
        System.out.println("Año: " + auto1.getAnio());
        System.out.println("Precio: " + auto1.getPrecio());

        System.out.println("\nAuto 2");
        System.out.println("Marca: " + auto2.getMarca());
        System.out.println("Año: " + auto2.getAnio());
        System.out.println("Precio: " + auto2.getPrecio());
    }
}
