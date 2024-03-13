package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		Validacion validacion = new Validacion();
		
		boolean validez = validacion.validarMonto(0);
		System.out.println(validez);
	}

}
