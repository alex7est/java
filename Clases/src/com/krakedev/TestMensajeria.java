package com.krakedev;

public class TestMensajeria {
	int x = 5;
	public static void main(String[] args) {
		Mensajeria m = new Mensajeria();
		m.saludar();
		m.saludarAmigo("Jose", "Perez");
		TestMensajeria obj = new TestMensajeria();
		System.out.println(obj.x);
	}

}
