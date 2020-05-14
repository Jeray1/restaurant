package Clases;

public class Jefe extends Persona{

	private int IDJ;

	
	//Constructores
	
	public Jefe(String usuario, String contraseña, String email, String nombre, String apellido, String telefono,
			int iDJ) {
		super(usuario, contraseña, email, nombre, apellido, telefono);
		IDJ = iDJ;
	}


	public int getIDJ() {
		return IDJ;
	}


	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}
	
	
}
