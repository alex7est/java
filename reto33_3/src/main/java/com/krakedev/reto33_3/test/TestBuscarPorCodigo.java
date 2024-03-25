package com.krakedev.reto33_3.test;

import com.krakedev.reto33_3.entidades.Transaccion;
import com.krakedev.reto33_3.servicios.AdminTransaccion;

public class TestBuscarPorCodigo {

	public static void main(String[] args) {
		try {
			Transaccion transaccion = AdminTransaccion.buscarPorCodigo(1);
			System.out.println(transaccion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
