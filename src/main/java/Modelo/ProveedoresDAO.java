package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.ConexionSQL;

public class ProveedoresDAO {

	ConexionSQL conn = new ConexionSQL();
	Connection  conect = conn.hacerConexion();
	PreparedStatement re = null;
	ResultSet resultado = null;
	
	public boolean CrearCliente(ProveedoresDTO proveedor)  {
		boolean bool = false;
		
		String ingresar = "insert into proveedores values (?,?,?,?,?)";
		try {
			re = conect.prepareStatement(ingresar);
			re.setInt(1, proveedor.getNit_proveedor());
			re.setString(2, proveedor.getNombre_proveedor());
			re.setString(3, proveedor.getDireccion_proveedor());
			re.setString(5, proveedor.getTelefono_proveedor());
			re.setString(4, proveedor.getCiudad_proveedor());
			
		//carga de información en data base//
		bool = re.executeUpdate()>0;
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar el usuario"+e);
		}
		
		return bool;
	}
	
	
	public ProveedoresDTO consultarProveedor(int nit) {
		ProveedoresDTO proveedor = null;
		
		String buscar = "select * from proveedores where nitproveedor=?";
			try {
				re= conect.prepareStatement(buscar);
				re.setInt(1, nit);
				resultado = re.executeQuery();
				while(resultado.next()) {
					proveedor = new ProveedoresDTO(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5));
				}
				
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Error al consultar el proveedor"+e);
				
			}
			return proveedor;
		
	}
	
	/**
	 * 
	 * @param cliente
	 * @return resultado
	 */
	
	public boolean actualizarProveedor(ProveedoresDTO proveedor) {
		
		boolean resultado = false;
		
		String actualizar = "update proveedores set nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, ciudad_proveedor=? where nitproveedor=?";
		
		try {
			re = conect.prepareStatement(actualizar);
			re.setString(1, proveedor.getNombre_proveedor());
			re.setString(2, proveedor.getDireccion_proveedor());
			re.setString(3, proveedor.getTelefono_proveedor());
			re.setString(4, proveedor.getCiudad_proveedor());
			re.setInt(5, proveedor.getNit_proveedor());
			resultado= re.executeUpdate()> 0;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al actualizar el proveedor"+ e);
		}
		
		
		return resultado;
	}
	
	public boolean eliminarproveedor(int nit) {
		boolean resultado = false;
		
		String eliminar = "delete from clientes where nitproveedor=? ";
		
		try {
			re=conect.prepareStatement(eliminar);
			re.setInt(1, nit);
			resultado = re.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor"+e);
		}
		
		
		return resultado;
	}


}
