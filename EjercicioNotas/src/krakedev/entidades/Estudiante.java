package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas;

	public Estudiante(String cedula, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.notas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota nuevaNota) {
		for (Nota nota : notas) {
			if (nota.getMateria().getCodigo().equals(nuevaNota.getMateria().getCodigo())) {
				return;
			}
		}
		double calificacion = nuevaNota.getCalificacion();
		if (calificacion >= 0 && calificacion <= 10) {
			notas.add(nuevaNota);
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		boolean encontrado = false;
		for (Nota nota : notas) {
			if (nota.getMateria().getCodigo().equals(codigo)) {
				encontrado = true;
				if (nuevaNota >= 0 && nuevaNota <= 10) {
					nota.setCalificacion(nuevaNota);
				}
				break;
			}
		}
		if (!encontrado) {
			System.out.println("No se encontró una nota con el código proporcionado");
		}
	}

	public double calcularPromedioNotasEstudiante() {
		double sumaNotas = 0.0;
		for (Nota nota : notas) {
			sumaNotas += nota.getCalificacion();
		}
		return sumaNotas / notas.size();
	}

	public void mostrar() {
		System.out.print("Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", ");
        
        if (notas.size()!=0) {
            System.out.print("notas=[");
            for (int i = 0; i < notas.size(); i++) {
                Nota nota = notas.get(i);
                System.out.print(nota.getMateria().getNombre() + "=" + nota.getCalificacion());
                if (i < notas.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        } else {
            System.out.print("notas=[]");
        }
        
        System.out.println("]");
    }
	
}
