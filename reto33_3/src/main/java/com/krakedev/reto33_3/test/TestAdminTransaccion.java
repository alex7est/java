package com.krakedev.reto33_3.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.reto33_3.entidades.Transaccion;
import com.krakedev.reto33_3.servicios.AdminTransaccion;
import com.krakedev.reto33_3.utils.Convertidor;

public class TestAdminTransaccion {
    public static void main(String[] args) {
    	Date fecha = null;
		Date hora = null;
		try {
			fecha = Convertidor.convertirFecha("2024/11/03");
			hora = Convertidor.convertirHora("22:48:35");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        Transaccion transaccion = new Transaccion(5, "54321", new BigDecimal(20), 'D', fecha, hora);

        try {
            AdminTransaccion.insertar(transaccion);

            AdminTransaccion.actualizar(transaccion);

            AdminTransaccion.eliminar(transaccion.getCodigo());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
