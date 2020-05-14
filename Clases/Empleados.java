package Clases;

import Enumeraciones.Contratos;

public class Empleados extends Persona {
	
	private String DNI;
	private Contratos contrato;
	private float salario;
	private String aviso;
	private String talla;
	private String horario;
	
	//Constructores
	public Empleados() {
		super();
		this.DNI="";
		this.contrato=null;
		this.salario=(float)700.56;
		this.aviso="";
		this.talla="";
		this.horario="";
	}

	public Empleados(String usuario, String contraseña, String email, String nombre, String apellido, String telefono,
			String dNI, Contratos contrato, float salario, String aviso, String talla, String horario) {
		super(usuario, contraseña, email, nombre, apellido, telefono);
		DNI = dNI;
		this.contrato = contrato;
		this.salario = salario;
		this.aviso = aviso;
		this.talla = talla;
		this.horario = horario;
	}

	
	//Getters and Setters
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Contratos getContrato() {
		return contrato;
	}

	public void setContrato(Contratos contrato) {
		this.contrato = contrato;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	

	
	

}
