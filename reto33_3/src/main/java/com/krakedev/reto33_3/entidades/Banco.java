package com.krakedev.reto33_3.entidades;

public class Banco {
	private int codigo_banco;
	private Transaccion transaccion;
	private String detalle;
	
	public Banco() {}

	public Banco(int codigo_banco, Transaccion transaccion, String detalle) {
		super();
		this.codigo_banco = codigo_banco;
		this.transaccion = transaccion;
		this.detalle = detalle;
	}

	public int getCodigo_banco() {
		return codigo_banco;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Banco [codigo_banco=" + codigo_banco + ", transaccion=" + transaccion + ", detalle=" + detalle + "]";
	}
	
	
}
