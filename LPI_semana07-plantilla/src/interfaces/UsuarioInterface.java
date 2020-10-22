package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterface {

	public int registrar(Usuario u);
	
	public int eliminar(int codigo);
	
	public int actualizar(Usuario u);
	
	public ArrayList<Usuario> listado();
}
