package Clases;

import java.util.ArrayList;

public class Menu {
	private int IDM;
	private int IDR;
	private float precio;
	private ArrayList<Recetas> primeros;
	private ArrayList<Recetas> segundos;
	private ArrayList<Recetas> postres;
	
	//Constructor
	public Menu(int iDM, int iDR, float precio, ArrayList<Recetas> primeros, ArrayList<Recetas> segundos,
			ArrayList<Recetas> postres) {
		super();
		IDM = iDM;
		IDR = iDR;
		this.precio = precio;
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
	}

	//Getters and Setters
	public int getIDM() {
		return IDM;
	}

	public void setIDM(int iDM) {
		IDM = iDM;
	}

	public int getIDR() {
		return IDR;
	}

	public void setIDR(int iDR) {
		IDR = iDR;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Recetas> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<Recetas> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<Recetas> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<Recetas> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Recetas> getPostres() {
		return postres;
	}

	public void setPostres(ArrayList<Recetas> postres) {
		this.postres = postres;
	}
	
	
	

}
