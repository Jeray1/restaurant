package BD;

import java.util.ArrayList;

import Clases.Camarero;
import Clases.Clientes;
import Clases.Cocinero;
import Clases.Empleados;
import Clases.Limpiador;
import Clases.Recetas;

public interface BaseDatos {
	
	public void iniciar();
	public ArrayList<Clientes> verClientes();
	public ArrayList<Empleados> verEmpleados();
	public ArrayList<Cocinero> verCocineros();
	public ArrayList<Camarero> verCamarero();
	public ArrayList<Limpiador> verLimpiadores();
	public Clientes devolverCliente(String nombre,String Apellidos);
	public void añadirClientes(Clientes cliente);
	public void añadirEmpleados(Empleados empleado);
	public void añadirReceta(Recetas receta);
	
	
}
