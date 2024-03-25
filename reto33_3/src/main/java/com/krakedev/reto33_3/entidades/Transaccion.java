package com.krakedev.reto33_3.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Transaccion {
    private int codigo;
    private String numeroCuenta;
    private BigDecimal monto;
    private char tipo;
    private Date fecha;
    private Date hora;
    
    public Transaccion(int codigo) {
    	this.codigo = codigo;
    }
    
    public Transaccion(int codigo, String numeroCuenta, BigDecimal monto, char tipo, Date fecha, Date hora) {
        this.codigo = codigo;
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
