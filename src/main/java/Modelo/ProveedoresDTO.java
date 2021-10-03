package Modelo;

public class ProveedoresDTO {
	
	private String nombre_proveedor;
	private int nit_proveedor;
	private String direccion_proveedor;
	private String telefono_proveedor;
	private String ciudad_proveedor;
	
	public ProveedoresDTO ( int nit,String nombre, String direccion, String telefono, String ciudad ) {

	this.nombre_proveedor = nombre;
	this.nit_proveedor = nit;
	this.direccion_proveedor = direccion;
	this.telefono_proveedor = telefono;
	this.ciudad_proveedor = ciudad;
	
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public int getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(int nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}
	
	

}
