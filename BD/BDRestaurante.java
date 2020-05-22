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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDRestaurante implements BaseDatos {

	private static Connection con;

	@Override
	public void conectar() {

		File directorio = new File("C:\\Datos");

		if (!directorio.exists())
			directorio.mkdir();

		String ruta = "C:/Datos/restaurante.db";
		try {
			// Cargamos el driver de SQLITE
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// Si se produce error con el drive de la BD
			e.printStackTrace();
		}
		// Declaramos la conexión:
		Connection conn = null;
		try {
			// Obtenemos la conexión
			conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
			// Escribimos mensaje en la consola para saber si
			// la conexión se realizó y donde está el archivo
			System.out.println("Conexión Ok - Ruta:  " + ruta);
		} catch (SQLException e) {
			// Se ha producido un error en la BD
			e.printStackTrace();
		}
		// Devolvemos la conexión
		con = conn;
	}

	@Override
	public void iniciar() {

		try {
			Statement enunciado = con.createStatement();

		// Presonas---------------------------------------------------------------------------------
			
			// tabla Persona
			enunciado.execute("DROP TABLE IF EXISTS Persona;");
			enunciado.execute(
					"CREATE TABLE Persona(Usuario String PRIMARY KEY, contraseña String,email String,Nombre String,Apellido String,Telefono String);");

			// tabla jefe
			enunciado.execute("DROP TABLE IF EXISTS Jefe;");
			enunciado.execute("CREATE TABLE Jefe(idjefe int PRIMARY KEY);");

			// tabla Empleados
			enunciado.execute("DROP TABLE IF EXISTS Empleados;");
			enunciado.execute(
					"CREATE TABLE Empleados(dni String PRIMARY KEY,Contrato String,Salario float,Aviso String,Talla String,Horario String,Usuario String,FOREIGN KEY(Usuario) REFERENCES Persona(usuario));");

			// tabla Cocinero
			enunciado.execute("DROP TABLE IF EXISTS Cocineros;");
			enunciado.execute(
					"CREATE TABLE Cocineros(idcocinero int PRIMARY KEY,especialidad String,Usuario String, idjefe int, FOREIGN KEY(Usuario) REFERENCES Persona(usuario), FOREIGN KEY(idjefe) REFERENCES Jefe(idjefe));");

			// tabla Camarero
			enunciado.execute("DROP TABLE IF EXISTS Camarero;");
			enunciado.execute(
					"CREATE TABLE Camarero(idcamarero int PRIMARY KEY,Zona int,Propina float, Usuario String, idjefe int, FOREIGN KEY(Usuario) REFERENCES Persona(usuario), FOREIGN KEY(idjefe) REFERENCES Jefe(idjefe));");

			// tabla Limpiador
			enunciado.execute("DROP TABLE IF EXISTS Limpiador;");
			enunciado.execute(
					"CREATE TABLE Limpiador(idlimpiador int PRIMARY KEY, Usuario String, idjefe int, FOREIGN KEY(Usuario) REFERENCES Persona(usuario), FOREIGN KEY(idjefe) REFERENCES Jefe(idjefe));");

			// tabla Cliente
			enunciado.execute("DROP TABLE IF EXISTS Cliente;");
			enunciado.execute(
					"CREATE TABLE Cliente(idcliente int PRIMARY KEY,metododepago String,Usuario String,FOREIGN KEY(Usuario) REFERENCES Persona(usuario));");

		// servicio---------------------------------------------------------------------------------
			
			// tabla Reservas
			enunciado.execute("DROP TABLE IF EXISTS Reservas;");
			enunciado.execute(
					"CREATE TABLE Reservas(nr int PRIMARY KEY,FechaReserva String,cantidaddepersonas int,idcliente int,FOREIGN KEY(idcliente) REFERENCES Cleinte(idcliente));");

			// tabla Mesas
			enunciado.execute("DROP TABLE IF EXISTS Mesas;");
			enunciado.execute(
					"CREATE TABLE Mesas(idmesa int PRIMARY KEY,ocupada boolean,nr int,FOREIGN KEY(nr) REFERENCES Reserva(nr));");

			// tabla Comanda
			enunciado.execute("DROP TABLE IF EXISTS Comanda;");
			enunciado.execute(
					"CREATE TABLE Comanda(idcomanda int PRIMARY KEY,idcamarero int, nr int, ocupada boolean, fechacomanda String, factura, FOREIGN KEY(nr) REFERENCES Reservas(nr),FOREIGN KEY(idcamarero) REFERENCES Camarero(idcamarero));");

			// tabla Cocinar
			enunciado.execute("DROP TABLE IF EXISTS Cocinar;");
			enunciado.execute(
					"CREATE TABLE Cocinar(idcomanda int, idcocinero int, FOREIGN KEY(idcomanda) REFERENCES Comanda(idcomanda), FOREIGN KEY(idcocinero) REFERENCES Cocinero(idcocinero), PRIMARY KEY(idcomanda, idcocinero));");

		// Receta---------------------------------------------------------------------------------
			
			// tabla Ingredientes
			enunciado.execute("DROP TABLE IF EXISTS Ingredientes;");
			enunciado.execute(
					"CREATE TABLE Ingredientes(idngrediente int PRIMARY KEY, nombre String, precio int, stock int, alergenos Sting);")
			;
			
			// tabla Recetas
			enunciado.execute("DROP TABLE IF EXISTS Recetas;");
			enunciado.execute(
					"CREATE TABLE Recetas(idreceta int PRIMARY KEY, nombre String, precio int, alergenos Sting);"
					);

			// tabla Ingredientes X Recetas
			enunciado.execute("DROP TABLE IF EXISTS ingredientesXrecetas;");
			enunciado.execute(
					"CREATE TABLE ingredientesXrecetas(idingrediente int, idreceta int, precio int, alergenos String, FOREIGN KEY(idingrediente) REFERENCES Ingredientes(idingrediente), FOREIGN KEY(idreceta) REFERENCES Recetas(idreceta), PRIMARY KEY(idingrediente, idreceta));");

			// tabla Recetas X Comanda
			enunciado.execute("DROP TABLE IF EXISTS recetasXcomanda;");
			enunciado.execute(
					"CREATE TABLE recetasXcomanda(idreceta int, idcomanda int, FOREIGN KEY(idcomanda) REFERENCES Comanda(idcomanda), FOREIGN KEY(idreceta) REFERENCES Recetas(idrecceta), PRIMARY KEY(idreceta, idcomanda));");

			// tabla Menu
			enunciado.execute("DROP TABLE IF EXISTS Menu;");
			enunciado.execute(
					"CREATE TABLE Menu(idmenu int PRIMARY KEY, idreceta int, precio int, FOREIGN KEY(idreceta) REFERENCES RecetasXComanda(idrecceta));");

			// tabla Carta
			enunciado.execute("DROP TABLE IF EXISTS Carta;");
			enunciado.execute(
					"CREATE TABLE Carta(idcarta int PRIMARY KEY, idreceta int, FOREIGN KEY(idreceta) REFERENCES RecetasXComanda(idrecceta));");
			
			
			
			
			// Insert
			enunciado.execute(
					"INSERT INTO Empleados values ('66666666s','Temporal',750.25,'Joputa','XXXXXXL','9:00-21:00','jo12'),"
							+ "('77777777K','Indefinido',1000.25,'Rabino','BAJITO Y GORDITO','6:00-23:00','jojo´s bizarre');"
							);

			// select empleados
			ResultSet resultados;
			resultados = enunciado.executeQuery("SELECT * FROM Empleados");

			while (resultados.next()) {
				System.out.println("DNI: " + resultados.getString(1) 
				+ "\nContrato: " + resultados.getString(2)
						+ "\nSalario:" + resultados.getString(3) 
						+ "€ \nAviso: " + resultados.getString(4) 
						+ "\nTalla: " + resultados.getString(5) 
						+ "\nHorario: " + resultados.getString(6) 
						+ "\nUsuario: "	+ resultados.getString(7));
				System.out.println("_________________________________________________________________________________________________________________________________________________________________\n");
			}

		} catch (SQLException e) {
			// Se produce algun problema al crear las tablas
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
