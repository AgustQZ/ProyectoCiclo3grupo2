package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.ConexionSQL;

public class VentasDAO {
	
	ConexionSQL conn = new ConexionSQL();
	Connection conect = conn.hacerConexion();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	
	public boolean crearVenta(VentasDTO ventas) {
		
		boolean resultado = false; 
		
		ClienteDTO cliente = null;
		String nombre = cliente.getNombre_cliente();
		String cedula =cliente.getCedula_cliente();
		
	
		
		
		return resultado;
	}
	

}
