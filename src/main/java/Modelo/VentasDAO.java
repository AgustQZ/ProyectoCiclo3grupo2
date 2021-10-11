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
		
		
		
	try {
		String insertar = "insert into tiendagenerica.ventas (nombre_cliente,cedula_cliente,preciobase,iva,precio_total)values (?,?,?,?,?)";
		ps=conect.prepareStatement(insertar);
		ps.setString(1, ventas.getNombreCliente());
		ps.setString(2, ventas.getCedulaCliente());
		ps.setDouble(3,ventas.getTotalVenta());
		ps.setDouble(4, ventas.getIvaVenta());
		ps.setDouble(5, ventas.getValorVenta());
		resultado = ps.executeUpdate()>0;
		
		
		
	}catch(SQLException e) {
		JOptionPane.showMessageDialog(null, "Error al insertar venta"+e);
	}
		
		
		return resultado;
	}
	
	public VentasDTO buscarVenta(String cedula) {
		VentasDTO venta = null;
		
		try {
			String buscar = "select * from ventas where cedula_cliente=?";
			ps = conect.prepareStatement(buscar);
			ps.setString(1, cedula);
			res = ps.executeQuery();
			while(res.next()) {
				venta = new VentasDTO(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getDouble(6));
			}
			
			
		}catch(SQLException e){
			
		}
		return venta;
	}
	

}
