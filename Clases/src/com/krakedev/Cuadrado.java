package com.krakedev;

public class Cuadrado {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        double area = lado * lado;
        return area;
    }

    public double calcularPerimetro() {
        double perimetro = lado * 4;
        return perimetro;
    }
}
