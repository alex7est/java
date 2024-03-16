package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;

	public MaquinaDulces() {
		this.celdas = new ArrayList<Celda>();
	}

	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void agregarCelda(String codigo) {
		Celda celdaNueva = new Celda(codigo);
		this.celdas.add(celdaNueva);
	}

//	public void configurarMaquina(String cod1, String cod2, String cod3, String cod4) {
//		this.setCelda1(new Celda(cod1));
//		this.setCelda2(new Celda(cod2));
//		this.setCelda3(new Celda(cod3));
//		this.setCelda4(new Celda(cod4));
//	}

	public void mostrarConfiguracion() {
		for (int i = 0; i < this.celdas.size(); i++) {
			System.out.println("Celda " + (i + 1) + ": " + this.celdas.get(i).getCodigo());
		}
	}

	public Celda buscarCelda(String codigo) {
		Celda celdaEncontrada = null;

		for (int i = 0; i < this.celdas.size(); i++) {
			if (codigo.equals(this.celdas.get(i).getCodigo())) {
				celdaEncontrada = this.celdas.get(i);
			}
		}
		return celdaEncontrada;
	}

	public void cargarProducto(Producto producto, String codigo, int stock) {
		Celda celdaRecuperada = this.buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(producto, stock);
	}

	public void mostrarProductos() {
		for (int i = 0; i < this.celdas.size(); i++) {
			System.out.print("Celda: " + this.celdas.get(i).getCodigo() + " ");
			System.out.print("Stock: " + this.celdas.get(i).getStock() + " ");
			if (this.celdas.get(i).getProducto() != null) {
				System.out.print("Producto: " + this.celdas.get(i).getProducto().getCodigo() + " ");
				System.out.print("Precio: " + this.celdas.get(i).getProducto().getPrecio() + " ");
			} else {
				System.out.print("Sin Producto asignado");
			}
			System.out.println();
		}
		System.out.println("Saldo: "+this.saldo);
	}

	public Producto buscarProductoEnCelda(String codigo) {
		Celda celdaRecuperada = this.buscarCelda(codigo);
		Producto productoCelda = null;
		if (celdaRecuperada != null) {
			productoCelda = celdaRecuperada.getProducto();
		}
		return productoCelda;
	}

	public double consultarPrecio(String codigo) {
		Celda celdaRecuperada = this.buscarCelda(codigo);
		Producto productoCelda = celdaRecuperada.getProducto();
		double precio = productoCelda.getPrecio();
		return precio;
	}

	public Celda buscarCeldaProducto(String codigoProducto) {
		for (int i = 0; i < this.celdas.size(); i++) {
			Celda celda = this.celdas.get(i);
			if (celda.getProducto() != null && codigoProducto.equals(celda.getProducto().getCodigo())) {
				return celda;
			}
		}
		return null;
	}

	public void incrementarProductos(String codigoProducto, int incremento) {
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
		if (celdaEncontrada != null) {
			celdaEncontrada.setStock(celdaEncontrada.getStock() + incremento);
		}
	}

	public void vender(String codigo) {
		Celda celdaEncontrada = this.buscarCelda(codigo);
		Producto producto;
		double precio;
		if (celdaEncontrada != null) {
			celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
			producto = celdaEncontrada.getProducto();
			precio = producto.getPrecio();
			this.saldo += precio;
		}
	}

	public double venderConCambio(String codigo, double valorIngresado) {
		Celda celdaEncontrada = this.buscarCelda(codigo);
		Producto producto;
		double precio;
		double cambio;
		if (celdaEncontrada != null) {
			celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
			producto = celdaEncontrada.getProducto();
			precio = producto.getPrecio();
			this.saldo += precio;
			cambio = valorIngresado - precio;
			return cambio;
		} else {
			return 0.0;
		}
	}
	
	public ArrayList<Producto> buscarMenores(double limite){//jaja sisoy
		ArrayList<Producto> productos = new ArrayList<Producto>(); 
		for (int i = 0; i < this.celdas.size(); i++) {
			Producto producto = this.celdas.get(i).getProducto();
			if (producto.getPrecio() <= limite) {
				productos.add(producto);
			}
		}
		return productos;
	}
}
