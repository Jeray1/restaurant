package Clases;

public class Persona {
	
	private String usuario;
	private String contraseña;
	private String email;
	private String nombre;
	private String apellido;
	private String telefono;
	
	
	
	//constructores
	
		public Persona(String usuario, String contraseña, String email, String nombre, String apellido, String telefono) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	
	
	public Persona() {
		
		this.usuario="";
		this.contraseña="";
		this.email="";
		this.nombre="";
		this.apellido="";
		this.telefono="";
	}





	//Getters and Setters
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
