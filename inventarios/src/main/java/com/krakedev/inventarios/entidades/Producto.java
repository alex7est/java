package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class Producto {
    private int codigo;
    private String nombre;
    private UnidadMedida unidadMedida;
    private BigDecimal precioVenta;
    private boolean tieneIVA;
    private BigDecimal coste;
    private Categoria categoria;
    private int stock;
    
    public Producto() {
    }
    
    public Producto(int codigo, String nombre, UnidadMedida unidadMedida, BigDecimal precioVenta, boolean tieneLVA, BigDecimal coste, Categoria categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precioVenta = precioVenta;
        this.tieneIVA = tieneLVA;
        this.coste = coste;
        this.categoria = categoria;
        this.stock = stock;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isTieneIVA() {
        return tieneIVA;
    }

    public void setTieneLVA(boolean tieneIVA) {
        this.tieneIVA = tieneIVA;
    }

    public BigDecimal getCoste() {
        return coste;
    }

    public void setCoste(BigDecimal coste) {
        this.coste = coste;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", precioVenta="
				+ precioVenta + ", tieneLVA=" + tieneIVA + ", coste=" + coste + ", categoria=" + categoria + ", stock="	+ stock + "]";
	}
}
