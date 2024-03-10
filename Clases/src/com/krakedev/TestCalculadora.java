package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu = new Calculadora();
		int resultadoSuma;
		int resultadoResta;
		
		resultadoSuma = calcu.sumar(5, 3);
		resultadoResta = calcu.restar(10, 3);
		
		System.out.println("RESULTADO SUMA: "+resultadoSuma);
		System.out.println("RESULTADO RESTA: "+resultadoResta);
	}

}
