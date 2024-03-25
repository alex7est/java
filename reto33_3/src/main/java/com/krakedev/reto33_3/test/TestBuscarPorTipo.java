package com.krakedev.reto33_3.test;

import java.util.ArrayList;

import com.krakedev.reto33_3.entidades.Transaccion;
import com.krakedev.reto33_3.servicios.AdminTransaccion;

public class TestBuscarPorTipo {
	
	public static void main(String[] args) {
		try {
			ArrayList<Transaccion> transacciones = AdminTransaccion.buscarPorTipo('C');
			System.out.println(transacciones);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
}
