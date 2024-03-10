package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		Persona p; //1. Declarar una variable p de tipo persona
		Persona p2 = new Persona();
		p = new Persona(); //2. Instanciar un objeto Persona, referenciarlo con p
		
		// 3. Accedo a los atributos
		System.out.println("nombre:" + p.nombre);
		System.out.println("edad:" + p.edad);
		System.out.println("estatura:" + p.estatura);
		
		// 4.Modificar los atributos
		p.nombre = "Mario";
		p.edad = 45;
		p.estatura = 1.56;
		System. out. println("----------------------");
		
		// 5. Accedo a los atributos
		System.out.println("nombre: " + p.nombre);
		System.out.println("edad: " + p.edad);
		System.out.println("estatura: " + p.estatura);
		
		p2.nombre="Angelina";
		System.out.println("******************");
		System.out.println("p.nombre: "+p.nombre);
		System.out.println("p2.nombre: "+p2.nombre);
	}

}
