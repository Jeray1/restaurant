package BD;

import java.util.ArrayList;

import Clases.Camarero;
import Clases.Clientes;
import Clases.Cocinero;
import Clases.Limpiador;
import Clases.Recetas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BDRestaurante implements BaseDatos{

	private  static Connection con;
	@Override
	public void conectar() {
		
		File directorio = new File("C:\\Datos");

		if(!directorio.exists())
		    directorio.mkdir();
		
		String ruta = "C:/Datos/restaurante.db";
		try{
			  //Cargamos el driver de SQLITE
			  Class.forName("org.sqlite.JDBC");
			}
			catch (ClassNotFoundException e){
			  //Si se produce error con el drive de la BD
			  e.printStackTrace();
			}
		//Declaramos la conexión:
		  Connection conn = null;
		  try{
		    //Obtenemos la conexión
		    conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
		    //Escribimos mensaje en la consola para saber si
		    //la conexión se realizó y donde está el archivo
		    System.out.println("Conexión Ok - Ruta:  "+ ruta);
		  }
		  catch (SQLException e) {
		    //Se ha producido un error en la BD
		    e.printStackTrace();
		  }
		    //Devolvemos la conexión
		    con= conn;		
	}
	
	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		try{
		      Statement enunciado = con.createStatement();
		    enunciado.execute("DROP TABLE IF EXISTS Persona;");
			enunciado.execute("CREATE TABLE Persona(Usuario String PRIMARY KEY, contraseña String,email String,Aviso Nombre,Apellido String,Telefono String);");
			enunciado.execute("DROP TABLE IF EXISTS Empleados;");
			enunciado.execute("CREATE TABLE Empleados(dni String,Contrato String,Salario float,Aviso String,Talla String,Horario String,Usuario String,FOREIGN KEY(Usuario) REFERENCES Persona(usuario));");
			enunciado.execute("DROP TABLE IF EXISTS Cocineros;");
			enunciado.execute("CREATE TABLE Cocineros(idcocinero int PRYMARY KEY,especialidad String,Usuario String,FOREIGN KEY(Usuario) REFERENCES Persona(usuario));");
			enunciado.execute("DROP TABLE IF EXISTS Empleados;");
			enunciado.execute("CREATE TABLE Empleados(DNI String, Contrato String,Salario float,Aviso String,Talla String,Horario String);");
			enunciado.execute("INSERT INTO Empleados values ('66666666s','Temporal',750.25,'Joputa','XXXXXXL','9:00-21:00');");
		    }
		    catch(SQLException e){
		      //Se produce algun problema al crear la tabla
			e.printStackTrace();
		    }

		
	}
	
	@Override
	public ArrayList<Clientes> verClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cocinero> verCocineros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Camarero> verCamarero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Limpiador> verLimpiadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes devolverCliente(String nombre, String Apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void añadirClientes(Clientes cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirReceta(Recetas receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirCocineros(Cocinero c1) {
		// TODO Auto-generated method stub
		
	}



}
