package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos1 {
    public static void main(String[] args) {
        Telefono telef1 = new Telefono("movi", "098123456", 1);
        Telefono telef2 = new Telefono("claro", "099987654", 2);

        Contacto c1 = new Contacto("John", "Doe", telef1, 75.5);
        Contacto c2 = new Contacto("Jane", "Doe", telef2, 65.8);

        AdminContactos admin = new AdminContactos();

        Contacto masPesado = admin.buscarMasPesado(c1, c2);
        System.out.println("Contacto con mayor peso:");
        masPesado.imprimirInfo();

        boolean mismaOperadora = admin.compararOperadoras(c1, c2);
        System.out.println("Ambos contactos pertenecen a la misma operadora?: " + mismaOperadora);
    }
}
