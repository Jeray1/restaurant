package Ventanas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import BD.BDRestaurante;
import Clases.Camarero;
import Enumeraciones.Contratos;

public class Principal {

	public static void main(String[] args) {
		
		int anno, mes, dia, hora, minutos;
		
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
		
		// hora de 24h - De 0 a 23
		
		anno = Integer.parseInt(JOptionPane.showInputDialog(null, "Año"));
		mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mes"));
		dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia"));
		hora = Integer.parseInt(JOptionPane.showInputDialog(null, "Hora"));
		minutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Minutos"));
		
		reservarFecha(anno, mes, dia, hora, minutos);
	}

	private static Calendar reservarFecha(int anno, int mes, int dia, int hora, int minutos) {
		Calendar fecha = Calendar.getInstance();

		fecha.set(Calendar.YEAR, anno);
		// Month. 0 is January, 11 is November
		fecha.set(Calendar.MONTH, (mes-1));
		fecha.set(Calendar.DAY_OF_MONTH, dia);
		fecha.set(Calendar.HOUR_OF_DAY, hora);

		fecha.set(Calendar.MINUTE, minutos);


		System.out.println("Fecha reserva: " + fecha.getTime());
		return fecha;
		
	}

}
