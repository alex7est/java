package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {
    public static void main(String[] args) {
        Telefono telef1 = new Telefono("movi", "098765432", 3);
        Telefono telef2 = new Telefono("claro", "097654321", 4);

        Contacto c1 = new Contacto("Alice", "Smith", telef1, 80.2);
        Contacto c2 = new Contacto("Bob", "Johnson", telef2, 70.3);

        AdminContactos admin = new AdminContactos();
        
        Contacto masPesado = admin.buscarMasPesado(c1, c2);
        System.out.println("Contacto con mayor peso:");
        masPesado.imprimirInfo();

        boolean mismaOperadora = admin.compararOperadoras(c1, c2);
        System.out.println("Ambos contactos pertenecen a la misma operadora?: " + mismaOperadora);
    }
}
