package com.krakedev.reto33_3.test;

import com.krakedev.reto33_3.entidades.Banco;
import com.krakedev.reto33_3.entidades.Transaccion;
import com.krakedev.reto33_3.servicios.AdminBanco;

public class TestAdminBanco {
	public static void main(String[] args) {
		Banco banco = new Banco(3, new Transaccion(1), null);

		try {
			AdminBanco.insertar(banco);

			AdminBanco.actualizar(banco);

			AdminBanco.eliminar(banco.getCodigo_banco());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
