package BD;

import java.util.ArrayList;
import Clases.Camarero;
import Clases.Clientes;
import Clases.Cocinero;
import Clases.Jefe;
import Clases.Limpiador;
import Clases.Recetas;

public interface BaseDatos {
	
	public void conectar();
	public void iniciar();
	public ArrayList<Clientes> verClientes();
	public ArrayList<Cocinero> verCocineros();
	public ArrayList<Camarero> verCamarero();
	public ArrayList<Limpiador> verLimpiadores();
	
	public void a�adirMesa();
	
	public void ocuparMesa(int id);
	public void librarMesa(int id);
	
	public void a�adirClientes(Clientes cliente);
	public void a�adirReceta(Recetas receta);
	public void a�adirCocineros(Cocinero c1);
	public void a�adirJefe(Jefe j1);
	public void a�adirCamarero(Camarero c1);
	
	public boolean clienteExiste(String email,String contrase�a);
	
	
}