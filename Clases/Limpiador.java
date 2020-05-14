package Clases;

import Enumeraciones.Contratos;

public class Limpiador extends Empleados {

	private int IDLimpiadores;
	private int IDJ;
	
	//Constructores
	
		public Limpiador() {
		super();
		IDLimpiadores=0;
		IDJ=0;
		// TODO Auto-generated constructor stub
	}
	public Limpiador(String usuario, String contraseña, String email, String nombre, String apellido, String telefono,
			String dNI, Contratos contrato, float salario, String aviso, String talla, String horario,
			int iDLimpiadores, int iDJ) {
		super(usuario, contraseña, email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario);
		IDLimpiadores = iDLimpiadores;
		IDJ = iDJ;
	}
	
	
	public int getIDLimpiadores() {
		return IDLimpiadores;
	}
	public void setIDLimpiadores(int iDLimpiadores) {
		IDLimpiadores = iDLimpiadores;
	}
	public int getIDJ() {
		return IDJ;
	}
	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}


	
	
}
