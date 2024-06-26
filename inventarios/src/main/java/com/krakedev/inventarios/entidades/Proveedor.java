package com.krakedev.inventarios.entidades;

public class Proveedor {
	private String identificador;
	private TipoDocumentos tipoDocumento;
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	
	public Proveedor() {}
	
	public Proveedor(String identificador, TipoDocumentos tipoDocumento, String nombre, String telefono, String correo, String direccion) {
		super();
		this.identificador = identificador;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public TipoDocumentos getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setTipoDocumento(TipoDocumentos tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String toString() {
		return "Proveedor [identificador=" + identificador + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre
				+ ", correo=" + correo + ", direccion=" + direccion + "]";
	}
	
}
