package Ventanas;

import BD.BDRestaurante;

public class Principal {

	public static void main(String[] args) {
		BDRestaurante bd1 = new BDRestaurante();
		bd1.conectar();
		bd1.iniciar();
		VentanaMain m1 = new VentanaMain();
		m1.setVisible(true);
	}

}
