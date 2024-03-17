package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;

	public Directorio() {
		this.contactos = new ArrayList<Contacto>();
        this.correctos = new ArrayList<>();
        this.incorrectos = new ArrayList<>();
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public boolean agregarContacto(Contacto contacto) {
		if (buscarPorCedula(contacto.getCedula()) == null) {
			contactos.add(contacto);
			fechaModificacion = new Date();
			return true;
		}
		return false;
	}

	public Contacto buscarPorCedula(String cedula) {
		for (Contacto contacto : contactos) {
			if (contacto.getCedula().equals(cedula)) {
				return contacto;
			}
		}
		return null;
	}

	public String consultarUltimaModificacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(fechaModificacion);
	}

	public int contarPerdidos() {
		int contador = 0;
		for (Contacto contacto : contactos) {
			if (contacto.getDireccion() == null) {
				contador++;
			}
		}
		return contador;
	}

	public int contarFijos() {
		int contador = 0;
		for (Contacto contacto : contactos) {
			for (Telefono telefono : contacto.getTelefonos()) {
				if (telefono.getTipo().equals("Convencional") && telefono.getEstado().equals("C")) {
					contador++;
				}
			}
		}
		return contador;
	}

	public void depurar() {
		for (Contacto contacto : contactos) {
			if (contacto.getDireccion() == null) {
				incorrectos.add(contacto);
			} else {
				correctos.add(contacto);
			}
		}
		contactos.clear();
	}
}
