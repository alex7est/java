package com.krakedev.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int hora) {
		String horaFormateada;
		if (hora < 10) {
			horaFormateada = "0" + hora;
		}else {
			horaFormateada = String.valueOf(hora);
		}
        return horaFormateada;
    }

	public static String formatearDia(int dia) {
        switch (dia) {
            case DiasSemana.LUNES:
                return "Lunes";
            case DiasSemana.MARTES:
                return "Martes";
            case DiasSemana.MIERCOLES:
                return "Miércoles";
            case DiasSemana.JUEVES:
                return "Jueves";
            case DiasSemana.VIERNES:
                return "Viernes";
            case DiasSemana.SABADO:
                return "Sábado";
            case DiasSemana.DOMINGO:
                return "Domingo";
            default:
                return "Día inválido";
        }
    }
}
