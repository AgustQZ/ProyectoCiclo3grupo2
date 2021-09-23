package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionSQL {
	private String dataBase = "tiendagenerica";
	private String url = "jdbc:mysql://localhost:3306/"+dataBase;
	private String user = "root";
	private String pass = "Mick2019nuevo";
	
	Connection conexion= null;
	
	public Connection hacerConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al realizar la conexion"+e);
		}
		return conexion;
	}
	
}
