package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Persona {
	private String cedula;
	private String nombre;
	private String apellido;
	private double estatura;
	private Date fechaNacimiento;
	private Date horaNacimiento;
	private BigDecimal cantidadAhorrada;
	private int numeroHijos;
	private EstadoCivil estadoCivil;
	
	public Persona() {}

	public Persona(String cedula, String nombre, String apellido, Date fechaNacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(String cedula, String nombre, String apellido, double estatura, Date fechaNacimiento,
			Date horaNacimiento, BigDecimal cantidadAhorrada, int numeroHijos, EstadoCivil estadoCivil) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estatura = estatura;
		this.fechaNacimiento = fechaNacimiento;
		this.horaNacimiento = horaNacimiento;
		this.cantidadAhorrada = cantidadAhorrada;
		this.numeroHijos = numeroHijos;
		this.estadoCivil = estadoCivil;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public double getEstatura() {
		return estatura;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Date getHoraNacimiento() {
		return horaNacimiento;
	}

	public BigDecimal getCantidadAhorrada() {
		return cantidadAhorrada;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setHoraNacimiento(Date horaNacimiento) {
		this.horaNacimiento = horaNacimiento;
	}

	public void setCantidadAhorrada(BigDecimal cantidadAhorrada) {
		this.cantidadAhorrada = cantidadAhorrada;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", estatura=" + estatura
				+ ", fechaNacimiento=" + fechaNacimiento + ", horaNacimiento=" + horaNacimiento + ", cantidadAhorrada="
				+ cantidadAhorrada + ", numeroHijos=" + numeroHijos + ", estadoCivil=" + estadoCivil + "]";
	}
	
	
}
