package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {
    public static void main(String[] args) {
        Telefono telef = new Telefono("movi", "098123456", 1);
        Contacto c = new Contacto("John", "Doe", telef, 75.5);
        c.imprimirInfo();
    }
}
