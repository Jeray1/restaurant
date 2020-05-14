package Clases;

import java.util.Calendar;

public class Comanda {

	private int IDComanda;
	private int IDCamarero;
	private int NR;
	private Calendar fechaComanda;
	private float Factura;
	
	//Constructor
	public Comanda(int iDComanda, int iDCamarero, int nR, Calendar fechaComanda, float factura) {
		super();
		IDComanda = iDComanda;
		IDCamarero = iDCamarero;
		NR = nR;
		this.fechaComanda = fechaComanda;
		Factura = factura;
	}

	public int getIDComanda() {
		return IDComanda;
	}

	public void setIDComanda(int iDComanda) {
		IDComanda = iDComanda;
	}

	public int getIDCamarero() {
		return IDCamarero;
	}

	public void setIDCamarero(int iDCamarero) {
		IDCamarero = iDCamarero;
	}

	public int getNR() {
		return NR;
	}

	public void setNR(int nR) {
		NR = nR;
	}

	public Calendar getFechaComanda() {
		return fechaComanda;
	}

	public void setFechaComanda(Calendar fechaComanda) {
		this.fechaComanda = fechaComanda;
	}

	public float getFactura() {
		return Factura;
	}

	public void setFactura(float factura) {
		Factura = factura;
	}
	
	//Getters and Setters
	
	
	
}
