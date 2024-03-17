package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.prestamos = new ArrayList<Prestamo>();
        this.clientes = new ArrayList<Cliente>();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void registrarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCedula()) == null) {
            clientes.add(cliente);
            System.out.println("\nCliene Registrado: ");
        } else {
        	System.out.println("\nCliene ya existe: "+cliente.getCedula());
        }
    }
    
    public void asignarPrestamo(String cedulaCliente, Prestamo prestamo) {
        Cliente cliente = buscarCliente(cedulaCliente);
        if (cliente == null) {
            System.out.println("El cliente no es cliente del banco.");
        } else {
        	prestamo.setCliente(cliente);
            CalculadoraAmortizacion.generarTabla(prestamo);
            prestamos.add(prestamo);
        }
    }

    public ArrayList<Prestamo> buscarPrestamos(String cedulaCliente) {
        ArrayList<Prestamo> prestamosCliente = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente().getCedula().equals(cedulaCliente)) {
                prestamosCliente.add(prestamo);
            }
        }
        return prestamosCliente.isEmpty() ? null : prestamosCliente;
    }
}
