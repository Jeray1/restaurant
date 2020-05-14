package Clases;

import java.util.Calendar;

public class Reservas {
	private int NR;
	private int IDCliente;
	private Calendar fechaReserva;
	private int cantidadPersonas;
	
	//Constructores
	public Reservas(int nR, int iDCliente, Calendar fechaReserva, int cantidadPersonas) {
		super();
		NR = nR;
		IDCliente = iDCliente;
		this.fechaReserva = fechaReserva;
		this.cantidadPersonas = cantidadPersonas;
	}

	public int getNR() {
		return NR;
	}

	public void setNR(int nR) {
		NR = nR;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public Calendar getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Calendar fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	
	//getters and Setters
	
	

}
