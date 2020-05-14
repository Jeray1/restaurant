package Clases;

import Enumeraciones.Contratos;

public class Camarero extends Empleados {
	
	private int IDCamarero;
	private int IDJ;
	private int zona;
	private float propina;
	
	//Constructores
	public Camarero() {
		super();
		IDCamarero = 0;
		IDJ = 0;
		this.zona = 0;
		this.propina = (float) 0.0;
	}
	public Camarero(String usuario, String contraseña, String email, String nombre, String apellido, String telefono,
			String dNI, Contratos contrato, float salario, String aviso, String talla, String horario,
			int iDCamarero,int iDJ,int zona,float propina) {
		super(usuario, contraseña, email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario);
		IDCamarero = iDCamarero;
		IDJ = iDJ;
		this.zona = zona;
		this.propina = propina;
	}
	
	public int getIDCamarero() {
		return IDCamarero;
	}
	public void setIDCamarero(int iDCamarero) {
		IDCamarero = iDCamarero;
	}
	public int getIDJ() {
		return IDJ;
	}
	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public float getPropina() {
		return propina;
	}
	public void setPropina(float propina) {
		this.propina = propina;
	}

	//Getters and Setters
	
	
	

}
