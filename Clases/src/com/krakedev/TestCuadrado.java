package com.krakedev;

public class TestCuadrado {

	public static void main(String[] args) {
		Cuadrado c1 = new Cuadrado();
		c1.lado = 4;
		
		Cuadrado c2 = new Cuadrado();
		c2.lado = 2.3;
		
		Cuadrado c3 = new Cuadrado();
		c3.lado = 6.8;
		
		double areaC1 = c1.calcularArea();
		double perimetroC1 = c1.calcularPerimetro();
		
		double areaC2 = c2.calcularArea();
		double perimetroC2 = c2.calcularPerimetro();
		
		double areaC3 = c3.calcularArea();
		double perimetroC3 = c3.calcularPerimetro();
	}

}
