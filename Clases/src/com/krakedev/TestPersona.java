package com.krakedev;

public class TestPersona {

    public static void main(String[] args) {
        Persona p; // 1. Declarar una variable p de tipo Persona
        Persona p2 = new Persona();
        p = new Persona(); // 2. Instanciar un objeto Persona y referenciarlo con p

        // 3. Acceder a los atributos
        System.out.println("nombre:" + p.getNombre());
        System.out.println("edad:" + p.getEdad());
        System.out.println("estatura:" + p.getEstatura());

        // 4. Modificar los atributos
        p.setNombre("Mario");
        p.setEdad(45);
        p.setEstatura(1.56);
        System.out.println("----------------------");

        // 5. Acceder a los atributos
        System.out.println("nombre: " + p.getNombre());
        System.out.println("edad: " + p.getEdad());
        System.out.println("estatura: " + p.getEstatura());

        p2.setNombre("Angelina");
        System.out.println("******************");
        System.out.println("p.nombre: " + p.getNombre());
        System.out.println("p2.nombre: " + p2.getNombre());
    }
}
