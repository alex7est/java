package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas;

	public Naipe() {
		numerosPosibles = new ArrayList<Numero>();
		cartas = new ArrayList<Carta>();

		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));
		
		ArrayList<String> palos = new ArrayList<String>(); 
		palos.add("CR");
        palos.add("CN");
        palos.add("DI");
        palos.add("TR");
        
		for (Numero numero : numerosPosibles) {
			for (String palo : palos) {
				cartas.add(new Carta(numero, palo));
			}
		}
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar = new ArrayList<Carta>();
		Carta carta;
		for (int i=1;i<100;i++) {
			int posicion = Random.obtenerPosicion();
			carta = cartas.get(posicion);
			if (carta.getEstado().equals("N")){
				auxiliar.add(carta);
				carta.setEstado("C");
			}
		}
		for (Carta restante: cartas) {
			if (restante.getEstado().equals("N")) {
				auxiliar.add(restante);
			}
		}
		return auxiliar;
	}
}
