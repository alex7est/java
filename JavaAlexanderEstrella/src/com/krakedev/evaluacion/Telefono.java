package com.krakedev.evaluacion;

public class Telefono {
	private String número;
	private String tipo;
	private String estado;

	public Telefono(String número, String tipo) {
		this.número = número;
		this.tipo = tipo;
		if (número == null || tipo == null) {
			this.estado = "E";
		} else if (!tipo.equals("Movil") && !tipo.equals("Convencional")) {
			this.estado = "E";
		} else {
			if (tipo.equals("Movil") && número.length() == 10) {
				this.estado = "C";
			} else if (tipo.equals("Convencional") && número.length() == 7) {
				this.estado = "C";
			} else {
				this.estado = "E";
			}
		}
	}

	public String getNumero() {
		return número;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}
}
