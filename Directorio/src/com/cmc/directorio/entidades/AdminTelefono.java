package com.cmc.directorio.entidades;

public class AdminTelefono {
    public void activarMensajeria(Telefono telefono) {
        if (telefono.getOperadora().equals("movi")) {
            telefono.setTieneWhatsapp(true);
        }
    }
    
    public int contarMovi(Telefono tel1, Telefono tel2, Telefono tel3) {
        int count = 0;
        if (tel1.getOperadora().equals("movi")) {
            count++;
        }
        if (tel2.getOperadora().equals("movi")) {
            count++;
        }
        if (tel3.getOperadora().equals("movi")) {
            count++;
        }
        return count;
    }

    public int contarClaro(Telefono tel1, Telefono tel2, Telefono tel3, Telefono tel4) {
        int count = 0;
        if (tel1.getOperadora().equals("claro")) {
            count++;
        }
        if (tel2.getOperadora().equals("claro")) {
            count++;
        }
        if (tel3.getOperadora().equals("claro")) {
            count++;
        }
        if (tel4.getOperadora().equals("claro")) {
            count++;
        }
        return count;
    }
}
