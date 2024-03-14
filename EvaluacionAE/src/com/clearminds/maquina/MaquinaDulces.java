package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void configurarMaquina(String cod1, String cod2, String cod3, String cod4) {
		this.setCelda1(new Celda(cod1));
		this.setCelda2(new Celda(cod2));
		this.setCelda3(new Celda(cod3));
		this.setCelda4(new Celda(cod4));
	}

	public void mostrarConfiguracion() {
		System.out.println("Celda 1: " + this.celda1.getCodigo());
		System.out.println("Celda 2: " + this.celda2.getCodigo());
		System.out.println("Celda 3: " + this.celda3.getCodigo());
		System.out.println("Celda 4: " + this.celda4.getCodigo());
	}

	public Celda buscarCelda(String codigo) {
		Celda celdaResultante;

		if (codigo.equals(this.celda1.getCodigo())) {
			celdaResultante = celda1;
		} else if (codigo.equals(this.celda2.getCodigo())) {
			celdaResultante = celda2;
		} else if (codigo.equals(this.celda3.getCodigo())) {
			celdaResultante = celda3;
		} else if (codigo.equals(this.celda4.getCodigo())) {
			celdaResultante = celda4;
		} else {
			celdaResultante = null;
		}

		return celdaResultante;
	}

	public void cargarProducto(Producto producto, String codigo, int stock) {
		Celda celdaRecuperada = this.buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(producto, stock);
	}

	public void mostrarProductos() {
		System.out.println("CELDA " + this.celda1.getCodigo());
		System.out.println("Stock: " + this.celda1.getStock());
		if (this.celda1.getProducto() != null) {
			System.out.println("Producto: " + this.celda1.getProducto().getNombre());
			System.out.println("Precio: " + this.celda1.getProducto().getPrecio());
			System.out.println("Código: " + this.celda1.getProducto().getCodigo()+"\n");
		} else {
			System.out.println("La celda no tiene producto!\n");
		}
		

		System.out.println("CELDA " + this.celda2.getCodigo());
		System.out.println("Stock: " + this.celda2.getStock());
		if (this.celda2.getProducto() != null) {
			System.out.println("Producto: " + this.celda2.getProducto().getNombre());
			System.out.println("Precio: " + this.celda2.getProducto().getPrecio());
			System.out.println("Código: " + this.celda2.getProducto().getCodigo()+"\n");
		} else {
			System.out.println("La celda no tiene producto!\n");
		}
		
		System.out.println("CELDA " + this.celda3.getCodigo());
		System.out.println("Stock: " + this.celda3.getStock());
		if (this.celda3.getProducto() != null) {
			System.out.println("Producto: " + this.celda3.getProducto().getNombre());
			System.out.println("Precio: " + this.celda3.getProducto().getPrecio());
			System.out.println("Código: " + this.celda3.getProducto().getCodigo()+"\n");
		} else {
			System.out.println("La celda no tiene producto!\n");
		}
		
		System.out.println("CELDA " + this.celda4.getCodigo());
		System.out.println("Stock: " + this.celda4.getStock());
		if (this.celda4.getProducto() != null) {
			System.out.println("Producto: " + this.celda4.getProducto().getNombre());
			System.out.println("Precio: " + this.celda4.getProducto().getPrecio());
			System.out.println("Código: " + this.celda4.getProducto().getCodigo()+"\n");
		} else {
			System.out.println("La celda no tiene producto!\n");
		}
		System.out.println("Saldo: "+this.saldo);
	}

	public Producto buscarProductoEnCelda(String codigo) {
		Celda celdaRecuperada = this.buscarCelda(codigo);
		Producto productoCelda;
		if (celdaRecuperada != null) {
			productoCelda = celdaRecuperada.getProducto();
		} else {
			productoCelda = null;
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
		Celda celdaResultante;

		if (this.celda1.getProducto() != null && codigoProducto.equals(this.celda1.getProducto().getCodigo())) {
			celdaResultante = celda1;
		} else if (this.celda2.getProducto() != null && codigoProducto.equals(this.celda2.getProducto().getCodigo())) {
			celdaResultante = celda2;
		} else if (this.celda3.getProducto() != null && codigoProducto.equals(this.celda3.getProducto().getCodigo())) {
			celdaResultante = celda3;
		} else if (this.celda4.getProducto() != null && codigoProducto.equals(this.celda4.getProducto().getCodigo())) {
			celdaResultante = celda4;
		} else {
			celdaResultante = null;
		}

		return celdaResultante;
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
}
