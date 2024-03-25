package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestActualizar {

	public static void main(String[] args) {
		Persona p = new Persona("0231738279", "Mario", "Torres", 1.72, new Date(), new Date(), new BigDecimal(1000), 3, new EstadoCivil("C",null));
		try {
			AdminPersonas.actualizar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
