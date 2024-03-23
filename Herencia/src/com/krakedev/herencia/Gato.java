package com.krakedev.herencia;

public class Gato extends Animal{
	@Override
	public void dormir() {
		System.out.println("Gato zzzzz");
	}
	
	public void maullar() {
		System.out.println("miau");
	}
	
	public void maullar(String adjetivo) {
		System.out.println("Gato maullando "+adjetivo);
	}
}
