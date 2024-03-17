package com.entidades;

import java.util.ArrayList;

import com.servicios.Juego;

public class Jugadores {
    private ArrayList<String> jugadores;

    public void jugar() {
        jugadores = new ArrayList<String>();
        jugadores.add("Jugador 1");
        jugadores.add("Jugador 2");
        jugadores.add("Jugador 3");

        Juego juego = new Juego(jugadores);
        juego.entregarCartas(5);

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ": " + juego.devolverTotal(i));
        }

        String ganador = juego.determinarGanador();
        System.out.println("El ganador es: " + ganador);
    }
    
    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }
}

