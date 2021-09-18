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
	
	public boolean insertarUsuario(UsuarioDTO user) {
		boolean bool = false;
		try {
			String insertar = "insert into usuarios values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, user.getCedula_usuario());
			ps.setString(2, user.getEmail_usuario());
			ps.setString(3, user.getNombre_usuario());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getUsuario());
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el usuario"+sqle);
		}
		return bool;
	}
	
	public UsuarioDTO buscarUsuario(String cedula) {
		UsuarioDTO user = null;
		try {
			String buscar = "select * from usuarios where cedula_usuario = ?";
			ps = con.prepareStatement(buscar);
			ps.setString(1, cedula);
			resultado = ps.executeQuery();
			user = new UsuarioDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));						
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el libro"+sqle);
		}
		return user;
	}
}
