package BD;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clases.Camarero;
import Clases.Clientes;
import Clases.Cocinero;
import Clases.Limpiador;
import Clases.Recetas;
import Enumeraciones.Contratos;
import Enumeraciones.MetodoPago;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		// Declaramos la conexiÃ³n:
		Connection conn = null;
		try {
			// Obtenemos la conexiÃ³n
			conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
			// Escribimos mensaje en la consola para saber si
			// la conexiÃ³n se realizÃ³ y donde estÃ¡ el archivo
			System.out.println("ConexiÃ³n Ok - Ruta:  " + ruta);
		} catch (SQLException e) {
			// Se ha producido un error en la BD
			e.printStackTrace();
		}
		// Devolvemos la conexiÃ³n
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
					"CREATE TABLE Persona(usuario String PRIMARY KEY, contraseña String,email String,Nombre String,Apellido String,Telefono String);");

			// tabla jefe
			enunciado.execute("DROP TABLE IF EXISTS Jefe;");
			enunciado.execute("CREATE TABLE Jefe(idjefe int PRIMARY KEY);");

			// tabla Empleados
			enunciado.execute("DROP TABLE IF EXISTS Empleados;");
			enunciado.execute(
					"CREATE TABLE Empleados(dni String PRIMARY KEY,Contrato String,Salario float,Aviso String,Talla String,Horario String,usuario String,FOREIGN KEY(usuario) REFERENCES Persona(usuario));");

			// tabla Cocinero
			enunciado.execute("DROP TABLE IF EXISTS Cocineros;");
			enunciado.execute(
					"CREATE TABLE Cocineros(idcocinero int PRIMARY KEY,especialidad String,usuario String, idjefe int, FOREIGN KEY(usuario) REFERENCES Persona(usuario), FOREIGN KEY(idjefe) REFERENCES Jefe(idjefe));");

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
					"CREATE TABLE Cliente(idcliente int PRIMARY KEY, metododepago String, email String, contraseña String);");

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
			
			
			
			
			
			
			// Insertamos Personas
			enunciado.execute(
					"INSERT INTO Persona VALUES "
					+ "('Boniato','1DAW3','boniato@gmail.com','Beñat','Madariaga','656565656'),"
					+ "('J3','1DAW3','J3@gmail.com','Jeray','Garcia','656565656'),"
					+ "('Aior','1DAW3','aior@gmail.com','Aimar','Odriozola','656565656'),"
					+ "('Cheff1','1DAW3','cheff1@gmail.com','Joaquin','Perez','656565656'),"
					+ "('Cheff2','1DAW3','cheff2@gmail.com','Roberta','Mendoza','656565656'),"
					+ "('Cam1','1DAW3','cam1@gmail.com','Asier','Mendez','656565656'),"
					+ "('Cam2','1DAW3','cam2@gmail.com','Selena','Rodriguez','656565656'),"
					+ "('Lmp1','1DAW3','lmp1@gmail.com','Eneko','Santa Cruz','656565656'),"
					+ "('Lmp2','1DAW3','lmp2@gmail.com','David','Arroyo','656565656'),"
					+ "('Lmp3','1DAW3','lmp3@gmail.com','IÃ±igo','Juarros','656565656');"
					);
			
			// Insertamos Empleados
			enunciado.execute(
					"INSERT INTO Empleados VALUES "
					+ "('66666666S','Temporal',750.25,'','XXXXXXL','9:00-21:00','Cheff2'),"
					+ "('77777777K','Indefinido',1000.25,'','BAJITO Y GORDITO','6:00-23:00','Cheff1'),"
					+ "('12356732S','MediaJornada',1020.25,'Limpieza en el pasillo 3','Solo bajito','9:00-20:00','Cam1'),"
					+ "('23772347F','Sustitucion',800.25,'','Solo gordita','8:00-22:00','Cam2'),"
					+ "('19432423G','Indefinido',800.25,'','XS','8:00-12:00','Lmp1'),"
					+ "('54379845M','Indefinido',900.25,'','M','15:00-22:00','Lmp2'),"
					+ "('56789237P','Temporal',800.25,'','S','18:00-22:00','Lmp3');"
					);
			
			// Insertamos Jefes
			enunciado.execute(
					"INSERT INTO Jefe VALUES "
					+ "(1)"
					);
			
			// Insertamos Cocineros
			enunciado.execute(
					"INSERT INTO Cocineros VALUES "
					+ "(1,'Paella','Cheff1',1), "
					+ "(2,'Pollo','Cheff2',1);" 
					);
		
			// Insertamos Clientes
			enunciado.execute(
					"INSERT INTO Cliente VALUES "
					+ "(1,'Paypal','contraseña1','cliente1@gmail.com'),"
					+ "(2,'Metalico','contraseña2','cliente2@gmail.com'),"
					+ "(3,'Tarjeta','contraseña3','cliente3@gmail.com');"
					);
			
			// Insertamos Camarero
			enunciado.execute(
					"INSERT INTO Camarero VALUES "
					+ "(1,1,20.5,'Cam1',1),"
					+ "(2,2,23.45,'Cam2',1);"
					);

			// Insertamos Limpiadores
			enunciado.execute(
					"INSERT INTO Limpiador VALUES "
					+ "(1,'Lmp1',1),"
					+ "(2,'Lmp2',1)," 
					+ "(3,'Lmp3',1);"
					);
			
			
		
			
			/*
			 * Clientes nuevoCliente; int id = 4; String metodo = "Paypal",
			 * email = "cliente4@gmail.com", contraseÃ±a = "contraseÃ±a4";
			 * 
			 * nuevoCliente = new Clientes(id, MetodoPago.valueOf(metodo),
			 * email, contraseÃ±a);
			 * 
			 * aÃ±adirClientes(nuevoCliente);
			 * 
			 * 
			 * System.out.println(verClientes());
			 * System.out.println(verCocineros());
			 * System.out.println(verCamarero());
			 * System.out.println(verLimpiadores());
			 * 
			 * // select empleados ResultSet resultados; resultados =
			 * enunciado.executeQuery("SELECT Empleados.* FROM Empleados");
			 * 
			 * while (resultados.next()) { System.out.println("DNI: " +
			 * resultados.getString(1) + "\nContrato: " +
			 * resultados.getString(2) + "\nSalario:" + resultados.getString(3)
			 * + "â‚¬ \nAviso: " + resultados.getString(4) + "\nTalla: " +
			 * resultados.getString(5) + "\nHorario: " + resultados.getString(6)
			 * + "\nUsuario: " + resultados.getString(7));
			 * System.out.println("_______________________________\n"); }
			 */
			
			
		} catch (SQLException e) {
			// Se produce algun problema al crear las tablas
			e.printStackTrace();
		}

	}
	
	
	@Override
	public ArrayList<Clientes> verClientes() {
		
		ArrayList<Clientes> clientes = new ArrayList<>();
		Clientes unCliente;
		String contraseña, email, lista = "";
		MetodoPago metodopago;
		int id;
		String sql = "SELECT * FROM Cliente";
		try {
			Statement enunciado = con.createStatement();
			ResultSet rs = enunciado.executeQuery(sql);
			
			while(rs.next()){
				
				id = rs.getInt(1);
				metodopago = MetodoPago.valueOf(rs.getString(2));
				contraseña = rs.getString(3);
				email = rs.getString(4);
				
			
				
				lista = lista.concat(id + " / " + metodopago + " / " + contraseña + " / " + email + "\n");
				
				unCliente = new Clientes(id, metodopago, contraseña, email);
				
				clientes.add(unCliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, lista);
		
		return clientes;
	}

	@Override
	public ArrayList<Cocinero> verCocineros() {
		
		ArrayList<Cocinero> cocineros = new ArrayList<>();
		Cocinero unCocinero;
		String usuario, contraseña, email, nombre, apellido, telefono, dNI, aviso, talla, horario, especialidad, lista = "";
		Contratos contrato;
		float salario;
		int id, IDJ;

		String sql = "SELECT Persona.usuario, Persona.contraseña, Persona.email, Persona.Nombre, Persona.Apellido, Persona.Telefono, Empleados.dni, Empleados.Contrato, Empleados.Salario, Empleados.Aviso, Empleados.Talla, Empleados.Horario, Cocineros.idcocinero, Cocineros.especialidad, Cocineros.idjefe FROM Cocineros, Persona, Empleados WHERE Cocineros.usuario = Empleados.usuario AND Cocineros.usuario = Persona.usuario";
		try {

			Statement enunciado = con.createStatement();
			ResultSet rs = enunciado.executeQuery(sql);
			
			while(rs.next()){

				usuario = rs.getString(1);
				contraseña = rs.getString(2);
				email = rs.getString(3);
				nombre = rs.getString(4);
				apellido = rs.getString(5);
				telefono = rs.getString(6);
				dNI = rs.getString(7);
				contrato = Contratos.valueOf(rs.getString(8));
				salario = rs.getFloat(9);
				aviso = rs.getString(10);
				talla = rs.getString(11);
				horario = rs.getString(12);
				id = rs.getInt(13);
				especialidad = rs.getString(14);
				IDJ = rs.getInt(15);
				
				lista = lista.concat("Usuario: " + nombre + " " + usuario + "\n");
				
				unCocinero = new Cocinero(usuario, contraseña, email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario, id, IDJ, especialidad);
				
				cocineros.add(unCocinero);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, lista);
		return cocineros;
	}

	@Override
	public ArrayList<Camarero> verCamarero() {
		
		ArrayList<Camarero> camareros = new ArrayList<>();
		Camarero unCamarero;
		String usuario, contraseña, email, nombre, apellido, telefono, dNI, aviso, talla, horario, lista = "";
		Contratos contrato;
		float salario, propina;
		int id, IDJ, zona;

		String sql = "SELECT Persona.usuario, Persona.contraseña, Persona.email, Persona.Nombre, Persona.Apellido, Persona.Telefono, Empleados.dni, Empleados.Contrato, Empleados.Salario, Empleados.Aviso, Empleados.Talla, Empleados.Horario, Camarero.idcamarero, Camarero.idjefe ,Camarero.Zona, Camarero.Propina FROM Camarero, Persona, Empleados WHERE Camarero.usuario = Empleados.usuario AND Camarero.usuario = Persona.usuario";
		try {

			Statement enunciado = con.createStatement();
			ResultSet rs = enunciado.executeQuery(sql);
			
			while(rs.next()){

				usuario = rs.getString(1);
				contraseña = rs.getString(2);
				email = rs.getString(3);
				nombre = rs.getString(4);
				apellido = rs.getString(5);
				telefono = rs.getString(6);
				dNI = rs.getString(7);
				contrato = Contratos.valueOf(rs.getString(8));
				salario = rs.getFloat(9);
				aviso = rs.getString(10);
				talla = rs.getString(11);
				horario = rs.getString(12);
				id = rs.getInt(13);
				IDJ = rs.getInt(14);
				zona = rs.getInt(15);
				propina = rs.getFloat(16);
				
				
				
				lista = lista.concat("Usuario: " + nombre + " " + usuario + "\n");
				
				unCamarero = new Camarero(usuario, contraseña,email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario, id, IDJ, zona, propina);
				
				camareros.add(unCamarero);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, lista);

		
		return camareros;
	}

	@Override
	public ArrayList<Limpiador> verLimpiadores() {
		
		ArrayList<Limpiador> limpiadores = new ArrayList<>();
		Limpiador unLimpiador;
		String usuario, contraseña, email, nombre, apellido, telefono, dNI, aviso, talla, horario, lista = "";
		Contratos contrato;
		float salario;
		int id, IDJ;

		String sql = "SELECT Persona.usuario, Persona.contraseÃ±a, Persona.email, Persona.Nombre, Persona.Apellido, Persona.Telefono, Empleados.dni, Empleados.Contrato, Empleados.Salario, Empleados.Aviso, Empleados.Talla, Empleados.Horario, Limpiador.idlimpiador, Limpiador.idjefe FROM Limpiador, Persona, Empleados WHERE Limpiador.usuario = Empleados.usuario AND Limpiador.usuario = Persona.usuario";
		try {

			Statement enunciado = con.createStatement();
			ResultSet rs = enunciado.executeQuery(sql);
			
			while(rs.next()){

				usuario = rs.getString(1);
				contraseña = rs.getString(2);
				email = rs.getString(3);
				nombre = rs.getString(4);
				apellido = rs.getString(5);
				telefono = rs.getString(6);
				dNI = rs.getString(7);
				contrato = Contratos.valueOf(rs.getString(8));
				salario = rs.getFloat(9);
				aviso = rs.getString(10);
				talla = rs.getString(11);
				horario = rs.getString(12);
				id = rs.getInt(13);
				IDJ = rs.getInt(14);

				
				
				
				lista = lista.concat("Usuario: " + nombre + " " + usuario + "\n");
				
				unLimpiador = new Limpiador(usuario, contraseña,email, nombre, apellido, telefono, dNI, contrato, salario, aviso, talla, horario, id, IDJ);
				
				limpiadores.add(unLimpiador);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, lista);

		
		return limpiadores;
	}

	@Override
	public Clientes devolverCliente(String nombre, String Apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void añadirClientes(Clientes cliente) {
		
		String sql = "insert into cliente (idcliente, metododepago, contraseña, email) values (?,?,?,?)";

		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			pst.setInt(1, cliente.getIDClientes());
			pst.setString(2, cliente.getMetodoDePago().name());
			pst.setString(3, cliente.getContraseña());
			pst.setString(4, cliente.getEmail());
			
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void añadirReceta(Recetas receta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void añadirCocineros(Cocinero c1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean clienteExiste(String email, String contraseña) {
		ArrayList<Clientes> clientes = new ArrayList<>();
		Clientes unCliente;
		String contraseña1, email1, lista = "";
		MetodoPago metodopago;
		int id;
		String sql = "SELECT * FROM Cliente WHERE email="+email+" AND contraseña="+contraseña;
		try {
			Statement enunciado = con.createStatement();
			ResultSet rs = enunciado.executeQuery(sql);
			
			while(rs.next()){
				
				id = rs.getInt(1);
				metodopago = MetodoPago.valueOf(rs.getString(2));
				contraseña1 = rs.getString(3);
				email1 = rs.getString(4);
				
			
				
				lista = lista.concat(id + " / " + metodopago + " / " + contraseña1 + " / " + email1 + "\n");
				
				unCliente = new Clientes(id, metodopago, contraseña1, email1);
				
				clientes.add(unCliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, lista);
		if(clientes.isEmpty())
			return false;
			else
		return true;
		}
	}
