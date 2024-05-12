package com.krakedev.inventarios.entidades;

public class UnidadMedida {
    private String codigo;
    private String descripcion;
    private CategoriaUDM categoriaUdm;
    
    public UnidadMedida() {
    }
    
    public UnidadMedida(String codigo, String descripcion, CategoriaUDM categoriaUdm) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoriaUdm = categoriaUdm;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaUDM getCategoriaUdm() {
        return categoriaUdm;
    }

    public void setCategoriaUdm(CategoriaUDM categoriaUdm) {
        this.categoriaUdm = categoriaUdm;
    }

    @Override
	public String toString() {
		return "UnidadMedida [codigo=" + codigo + ", descripcion=" + descripcion + ", categoriaUdm=" + categoriaUdm	+ "]";
	}
}

