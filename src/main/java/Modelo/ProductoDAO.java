package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.ConexionSQL;

public class ProductoDAO {
	ConexionSQL cnn= new ConexionSQL();
	Connection conec=cnn.hacerConexion();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean CargarArchivo(String ruta){
		
		boolean resultado = false;
		
		try {
			String sql="load data infile '"+ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
			ps=conec.prepareStatement(sql);
			resultado=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Error al insertar el archivo:"+ex);
			}
		return resultado;
	}
	
	
public ArrayList<ProductoDTO> cargarProductos(){
		
		ProductoDTO producto=null;
		ArrayList<ProductoDTO> lista= new ArrayList<>();
		try {
		String sql="select * from productos";	
		ps=conec.prepareStatement(sql);
		res=ps.executeQuery();
		
		while(res.next()) {
			producto= new ProductoDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5));
			lista.add(producto);
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar Productos" +ex);
		}
		 return lista;
	}

public ProductoDTO consultarProducto(long codigo) {
	
	ProductoDTO producto = null;
	String consultar = "select * from tiendagenerica.productos where codigo_producto=?";
	
	try {
		ps = conec.prepareStatement(consultar);
		ps.setLong(1, codigo);
		res=ps.executeQuery();
		
		while(res.next()) {
			producto= new ProductoDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5));
		}
		
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error al consultar el producto"+e);
	}
	
	return producto;
}
	
}
