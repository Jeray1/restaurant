package Clases;

public class Jefe extends Persona{

	private int IDJ;

	
	//Constructores
	
	public Jefe(String usuario, String contrase�a, String email, String nombre, String apellido, String telefono,
			int iDJ) {
		super(usuario, contrase�a, email, nombre, apellido, telefono);
		IDJ = iDJ;
	}


	public int getIDJ() {
		return IDJ;
	}


	public void setIDJ(int iDJ) {
		IDJ = iDJ;
	}
	
	
}
