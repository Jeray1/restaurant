package Clases;

import Enumeraciones.Contratos;

public class Cocinero extends Empleados {
	
	private int IDCocinero;
	private int IDJ;
	private String especialidad;
	
	//Constructores

	public Cocinero() {
		super();
		IDCocinero=0;
		IDJ=0;
		especialidad="";
		
		
	}
	//Sin IDcocinero para meter en la base de datos
	public Cocinero(String usuario, String contraseña, String email, String nombre, String apellido, String telefono, String dNI, Contratos contrato, float salario, String aviso, String talla, String horario, int IDJ, String especialidad) {
		super(usuario, contraseña, email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario);
		
		this.IDJ = IDJ;
		this.especialidad = especialidad;
	}
	//Con IDcocinero para sacar de la base de datos
	public Cocinero(String usuario, String contraseña, String email, String nombre, String apellido, String telefono, String dNI, Contratos contrato, float salario, String aviso, String talla, String horario, int IDCocinero, int IDJ, String especialidad) {
		super(usuario, contraseña, email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario);
		this.IDCocinero = IDCocinero;
		this.IDJ = IDJ;
		this.especialidad = especialidad;
	}

	//Getters and Setters
	
	public int getIDCocinero() {
		return IDCocinero;
	}

	public void setIDCocinero(int iDCocinero) {
		IDCocinero = iDCocinero;
	}

	public int getIDJ() {
		return IDJ;
	}

	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
