package com.cmc.evaluacion.servicios;

import java.util.ArrayList;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
		return (prestamo.getMonto() * (prestamo.getInteres() / 12 / 100))
				/ (1 - Math.pow((1 + (prestamo.getInteres() / 12 / 100)), prestamo.getPlazo() * -1));
	}

	public static void generarTabla(Prestamo prestamo) {
		final double valorCuota = calcularCuota(prestamo);
		ArrayList<Cuota> cuotas = prestamo.getCuotas();

		for (int i = 1; i <= prestamo.getPlazo(); i++) {
			Cuota objCuota = new Cuota(i);
			objCuota.setCuota(valorCuota);
			cuotas.add(objCuota);
		}

		Cuota cuota1 = cuotas.get(0);
		cuota1.setInicio(prestamo.getMonto());
		cuotas.set(0, cuota1);
		
		for (Cuota cuota: cuotas) {
			int cuotaSiguiente = cuotas.indexOf(cuota)+1;
			if (cuotaSiguiente<cuotas.size()) {
				calcularValoresCuotas(prestamo.getInteres(), cuota, cuotas.get(cuotaSiguiente));
			} else {
				calcularValoresCuotas(prestamo.getInteres(), cuota, null);
			}
			
		}

	}

	private static void calcularValoresCuotas(double interes, Cuota cuota, Cuota cuotaSiguiente) {
		double valorInteres = cuota.getInicio() * (interes / 12 / 100);
		double abonoCapital = cuota.getCuota() - valorInteres;
		double saldo = cuota.getInicio() - abonoCapital;

		cuota.setInteres(valorInteres);
		cuota.setAbonoCapital(abonoCapital);
		cuota.setSaldo(saldo);

		if (cuotaSiguiente != null) {
			cuotaSiguiente.setInicio(saldo);
		} else {
			cuota.setCuota(cuota.getCuota() + saldo);
			cuota.setAbonoCapital(cuota.getCuota() - valorInteres);
			cuota.setSaldo(0);
		}
	}
	
	public static void mostrarTabla(Prestamo prestamo) {
	    System.out.println(" Número |   Cuota |  Inicio | Interes |   Abono |   Saldo ");
	    for (Cuota cuota: prestamo.getCuotas()) {
	        cuota.mostrarPrestamo();
	    }
	}
}
