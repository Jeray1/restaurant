package BD;

import java.sql.Connection;
import java.util.ArrayList;

import Clases.Camarero;
import Clases.Clientes;
import Clases.Cocinero;
import Clases.Limpiador;
import Clases.Recetas;

public interface BaseDatos {
	
	public void conectar();
	public void iniciar();
	public ArrayList<Clientes> verClientes();
	public ArrayList<Cocinero> verCocineros();
	public ArrayList<Camarero> verCamarero();
	public ArrayList<Limpiador> verLimpiadores();
	public Clientes devolverCliente(String nombre,String Apellidos);
	public void a�adirClientes(Clientes cliente);
	public void a�adirReceta(Recetas receta);
	public void a�adirCocineros(Cocinero c1);
	public boolean clienteExiste(String email,String contrase�a);
	
	
}
