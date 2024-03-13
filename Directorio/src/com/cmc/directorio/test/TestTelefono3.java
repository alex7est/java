package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono3 {
    public static void main(String[] args) {
        Telefono tel1 = new Telefono("movi", "098123456", 1);
        Telefono tel2 = new Telefono("claro", "099987654", 2);
        Telefono tel3 = new Telefono("movi", "097876543", 3);

        AdminTelefono adminTel = new AdminTelefono();
        int cantidadMovi = adminTel.contarMovi(tel1, tel2, tel3);
        
        System.out.println("Cantidad de teléfonos de movi: " + cantidadMovi);
    }
}
