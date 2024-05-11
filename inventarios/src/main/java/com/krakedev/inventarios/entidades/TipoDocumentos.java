package com.krakedev.inventarios.entidades;

public class TipoDocumentos {
	private char codigo;
	private String descripcion;
	
	public TipoDocumentos() {}

	public TipoDocumentos(char codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public char getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoDocumentos [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
}
