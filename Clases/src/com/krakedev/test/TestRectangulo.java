package com.krakedev.test;

import com.krakedev.Rectangulo;

public class TestRectangulo {

    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(10,5);
        Rectangulo r2 = new Rectangulo(8,3);

        int areaR1 = r1.calcularArea();
        int areaR2 = r2.calcularArea();

        System.out.println("Area de r1: " + areaR1);
        System.out.println("Area de r2: " + areaR2);
        
        double perimetroR1 = r1.calcularPerimetro();
        double perimetroR2 = r2.calcularPerimetro();
        
        System.out.println("Perimetro de r1: " + perimetroR1);
        System.out.println("Perimetro de r2: " + perimetroR2);
    }
}
