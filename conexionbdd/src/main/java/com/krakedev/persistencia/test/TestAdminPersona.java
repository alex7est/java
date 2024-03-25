package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPersona {
	private static final Logger LOGGER = LogManager.getLogger(TestAdminPersona.class);
	
	public static void main(String[] args) {
		Date fechaNac = null;
		Date horaNac = null;
		try {
			fechaNac = Convertidor.convertirFecha("1970/03/01");
			horaNac = Convertidor.convertirHora("23:53:12");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		Persona p = new Persona("0231738279", "Marcelo", "Torres", 1.72, fechaNac, horaNac, new BigDecimal(1000), 3, new EstadoCivil("C",null));
		try {
			AdminPersonas.insertar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
