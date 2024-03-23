package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiasSemana;

public class TestAlarmas {
    public static void main(String[] args) {
        AdminAlarmas admin = new AdminAlarmas();

        admin.agregarAlarma(new Alarma(DiasSemana.LUNES, 5, 45));
        admin.agregarAlarma(new Alarma(DiasSemana.MARTES, 7, 30));
        admin.agregarAlarma(new Alarma(DiasSemana.VIERNES, 8, 15));

        ArrayList<Alarma> alarmasActuales = admin.getAlarmas();

        for (Alarma alarma : alarmasActuales) {
            System.out.println(alarma);
        }
    }
}
