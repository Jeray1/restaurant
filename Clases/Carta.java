package Clases;

import java.util.ArrayList;

public class Carta {

	private int IDC;
	private int IDR;
	private boolean disponibilidad;
	private ArrayList<Recetas> carta;
	
	//Constructor
	public Carta(int iDC, int iDR, boolean disponibilidad, ArrayList<Recetas> carta) {
		super();
		IDC = iDC;
		IDR = iDR;
		this.disponibilidad = disponibilidad;
		this.carta = carta;
	}

	//Getters and Setters
	public int getIDC() {
		return IDC;
	}

	public void setIDC(int iDC) {
		IDC = iDC;
	}

	public int getIDR() {
		return IDR;
	}

	public void setIDR(int iDR) {
		IDR = iDR;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public ArrayList<Recetas> getCarta() {
		return carta;
	}

	public void setCarta(ArrayList<Recetas> carta) {
		this.carta = carta;
	}
	
	
	
}
