package Clases;

public class Ingredientes {

	private int IDI;
	private String nombre;
	private float precio;
	private int stock;
	
	//Constructor
	public Ingredientes(int iDI, String nombre, float precio, int stock) {
		super();
		IDI = iDI;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	//Getters and Setters
	public int getIDI() {
		return IDI;
	}

	public void setIDI(int iDI) {
		IDI = iDI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
