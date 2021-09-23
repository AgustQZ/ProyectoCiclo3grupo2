package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.ConexionSQL;

public class UsuarioDAO {
	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearUsuario(UsuarioDTO uDTO) {
		boolean resultado = false;
		try {
			String insertar = "insert into usuarios values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getCedula_usuario());			
			ps.setString(2, uDTO.getEmail_usuario());
			ps.setString(3, uDTO.getNombre_usuario());
			ps.setString(4, uDTO.getUsuario());
			ps.setString(5, uDTO.getPassword());
			resultado = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el usuario"+sqle);
		}
		return resultado;
	}
	
	public UsuarioDTO consultarUsuario(String cedula) {
		UsuarioDTO uDTO = null;
		try {
			String buscar = "select * from usuarios where cedula_usuario=?";
			ps = con.prepareStatement(buscar);
			ps.setString(1, cedula);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				uDTO = new UsuarioDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el usuario "+sqle);
		}
		return uDTO;
	}
	
	public boolean actualizarUsuario(UsuarioDTO uDTO) {
		boolean resultado = false;
		try {
			String insertar = "update usuarios set nombre_usuario=?, email_usuario=?, usuario=?, contraseña=? where cedula_usuario=?";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getNombre_usuario());
			ps.setString(2, uDTO.getEmail_usuario());
			ps.setString(3, uDTO.getUsuario());
			ps.setString(4, uDTO.getPassword());
			ps.setString(5, uDTO.getCedula_usuario());
			resultado = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el usuario"+sqle);
		}
		return resultado;
	}
	
	public boolean eliminarUsuario(String cedula) {
		boolean resultado = false;
		try {
			String eliminar = "delete from usuarios where cedula_usuario=?";
			ps = con.prepareStatement(eliminar);
			ps.setString(1, cedula);
			resultado = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el usuario"+sqle);
		}
		return resultado;
	}
}
