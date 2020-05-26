package Clases;

public class Mesas {
	
	private int IDMesa;
	private int NR;
	private boolean ocupada;
	
	//Constructores
	public Mesas() {
		NR = 0;
		this.ocupada = false;
	}
	
	public Mesas(int iDMesa, int nR, boolean ocupada) {
		IDMesa = iDMesa;
		NR = nR;
		this.ocupada = ocupada;
	}

	//Getters and Setters
	public int getIDMesa() {
		return IDMesa;
	}

	public void setIDMesa(int iDMesa) {
		IDMesa = iDMesa;
	}

	public int getNR() {
		return NR;
	}

	public void setNR(int nR) {
		NR = nR;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	

}
