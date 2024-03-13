package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {
    public static void main(String[] args) {
        Telefono tel1 = new Telefono("claro", "099123456", 1);
        Telefono tel2 = new Telefono("movi", "098987654", 2);
        Telefono tel3 = new Telefono("claro", "097876543", 3);
        Telefono tel4 = new Telefono("claro", "099999999", 4);

        AdminTelefono adminTel = new AdminTelefono();
        int cantidadClaro = adminTel.contarClaro(tel1, tel2, tel3, tel4);
        System.out.println("Cantidad de teléfonos de claro: " + cantidadClaro);
    }
}
