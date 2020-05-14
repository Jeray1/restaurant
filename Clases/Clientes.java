package Clases;

import Enumeraciones.MetodoPago;

public class Clientes {
	
	private int IDClientes;
	private MetodoPago metodoDePago;
	private String contrase�a;
	private String email;
	
	//Constructores
	public Clientes(int iDClientes, MetodoPago metodoDePago, String contrase�a, String email) {
		IDClientes = iDClientes;
		this.metodoDePago = metodoDePago;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
