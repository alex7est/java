package com.krakedev.test;

import com.krakedev.Cuadrado;

public class TestCuadrado {

    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado(4);
        Cuadrado c2 = new Cuadrado(2.3);
        Cuadrado c3 = new Cuadrado(6.8);

        double areaC1 = c1.calcularArea();
        double perimetroC1 = c1.calcularPerimetro();

        double areaC2 = c2.calcularArea();
        double perimetroC2 = c2.calcularPerimetro();

        double areaC3 = c3.calcularArea();
        double perimetroC3 = c3.calcularPerimetro();
    }
}
