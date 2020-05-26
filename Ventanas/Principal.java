package Ventanas;

import BD.BDRestaurante;
import Clases.Camarero;
import Enumeraciones.Contratos;

public class Principal {

	public static void main(String[] args) {
		
		BDRestaurante bd1 = new BDRestaurante();
		bd1.conectar();
		bd1.iniciar();
		VentanaMain m1 = new VentanaMain();
		m1.setVisible(true);
		Camarero unCamarero;
		unCamarero = new Camarero("Cam3", "1DAW3", "cam3@gmail.com", "Fernando", "Surero", "987654321", "9876598765P", Contratos.Temporal, (float)900.99, "Mesa 3 Sucia", "M", "9:00-19:00", 1, 1, (float)11.3);
		bd1.añadirCamarero(unCamarero);

		for (int i = 0; i < 40; i++) {
			bd1.añadirMesa();
			
		}
		
		bd1.ocuparMesa(7);
		bd1.ocuparMesa(25);
		
		bd1.librarMesa(7);
	}

}
