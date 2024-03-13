package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("Juan");
        estudiante.calificar(8);
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Nota: " + estudiante.getNota());
        System.out.println("Resultado: " + estudiante.getResultado());
	}

}
