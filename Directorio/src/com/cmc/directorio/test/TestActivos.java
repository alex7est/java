package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {
    public static void main(String[] args) {
        Telefono telef = new Telefono("claro", "096543210", 5);
        Contacto c = new Contacto("Eva", "Brown", telef, 60.7);
        System.out.println("Contacto antes de activar:");
        boolean whatsapp = c.getTelefono().tieneWhatsapp();
        System.out.println("Tiene whatsapp?: "+whatsapp);
        c.imprimirInfo();

        AdminContactos admin = new AdminContactos();
        admin.activarUsuario(c);
        
        System.out.println("\nContacto después de activar:");
        System.out.println("Tiene whatsapp?: "+whatsapp);
        c.imprimirInfo();
    }
}
