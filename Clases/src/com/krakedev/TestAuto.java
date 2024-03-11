package com.krakedev;

public class TestAuto {

    public static void main(String[] args) {
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        auto1.setMarca("Toyota");
        auto1.setAnio(2022);
        auto1.setPrecio(25000.0);

        auto2.setMarca("Ford");
        auto2.setAnio(2023);
        auto2.setPrecio(35000.0);

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
