package Clases;

public class Jefe extends Persona{

	private int IDJ;

	
	//Constructores
	
	public Jefe(String usuario, String contraseņa, String email, String nombre, String apellido, String telefono,
			int iDJ) {
		super(usuario, contraseņa, email, nombre, apellido, telefono);
		IDJ = iDJ;
	}


	public int getIDJ() {
		return IDJ;
	}


	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}
	
	
}
