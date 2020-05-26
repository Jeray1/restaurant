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
	
	public void añadirMesa();
	
	public void ocuparMesa(int id);
	public void librarMesa(int id);
	
	public void añadirClientes(Clientes cliente);
	public void añadirReceta(Recetas receta);
	public void añadirCocineros(Cocinero c1);
	public void añadirJefe(Jefe j1);
	public void añadirCamarero(Camarero c1);
	
	public boolean clienteExiste(String email,String contraseña);
	
	
}