package Clases;

public class Recetas {
	
	private int IDR;
	private float precio;
	private String alergenos;
	
	//Constructor
	public Recetas(int iDR, float precio, String alergenos) {
		super();
		IDR = iDR;
		this.precio = precio;
		this.alergenos = alergenos;
	}
	
	
	//Getters and Setters
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

	public String getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}
	
	
	
	

}
