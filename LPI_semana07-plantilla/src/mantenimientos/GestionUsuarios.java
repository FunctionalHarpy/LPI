package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuarios implements UsuarioInterface {

	@Override
	public int registrar(Usuario u) {		
		int rs = 0; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "insert into tb_usuarios values (null,?, ?, ?, ?, ?, curdate(),default,default)";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1, u.getNombre());
		   pst.setString(2, u.getApellido());
		   pst.setString(3, u.getUsuario());
		   pst.setString(4, u.getClave());
		   pst.setString(5, u.getFnacim());
		   		   
		   rs = pst.executeUpdate(); 

		} catch (Exception e) {
		   System.out.println("Error en registrar " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}

		return rs; 
	}

	@Override
	public int eliminar(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Usuario nu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Usuario> listado() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
