package Clases;

import Enumeraciones.MetodoPago;

public class Clientes {
	
	private int IDClientes;
	private MetodoPago metodoDePago;
	private String contraseña;
	private String email;
	
	//Constructores
	public Clientes(int iDClientes, MetodoPago metodoDePago, String contraseña, String email) {
		IDClientes = iDClientes;
		this.metodoDePago = metodoDePago;
		this.contraseña = contraseña;
		this.email = email;
	}

	
	//Getters and Setters
	
	public int getIDClientes() {
		return IDClientes;
	}

	public void setIDClientes(int iDClientes) {
		IDClientes = iDClientes;
	}

	public MetodoPago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoPago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
