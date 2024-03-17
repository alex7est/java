package com.cmc.evaluacion.entidades;

public class Cuota {
	private int numero;
	private double cuota, inicio, interes, abonoCapital, saldo;
	
	public Cuota(int numero) {
		this.numero = numero;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getAbonoCapital() {
		return abonoCapital;
	}

	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void mostrarPrestamo() {
	    System.out.printf("  %3d   | %7.2f | %7.2f | %7.2f | %7.2f | %7.2f%n", 
	        this.numero, 
	        Utilitario.redondear(this.cuota), 
	        Utilitario.redondear(this.inicio), 
	        Utilitario.redondear(this.interes), 
	        Utilitario.redondear(this.abonoCapital), 
	        Utilitario.redondear(this.saldo));
	}

	public double getInicio() {
		return inicio;
	}

	public void setInicio(double inicio) {
		this.inicio = inicio;
	}
}
