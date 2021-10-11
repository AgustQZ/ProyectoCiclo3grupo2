package Modelo;

public class VentasDTO {
	
	String codigoVentas;
	String NombreCliente;
	String cedulaCliente;
	double ivaVenta;	// iva de la venta
	double totalVenta;// total sin iva
	double valorVenta; // total con iva
	
	
	
	
	

	public VentasDTO(String nombreCliente, String cedulaCliente, double ivaVenta,
			double totalVenta, double valorVenta) {
		
		
		this.NombreCliente = nombreCliente;
		this.cedulaCliente = cedulaCliente;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}
	
	

	public VentasDTO(String codigoVentas, String nombreCliente, String cedulaCliente, double ivaVenta,
			double totalVenta, double valorVenta) {
		
		this.codigoVentas = codigoVentas;
		this.NombreCliente = nombreCliente;
		this.cedulaCliente = cedulaCliente;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}



	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public double getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(int ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(int valorVenta) {
		this.valorVenta = valorVenta;
	}



	public String getCodigoVentas() {
		return codigoVentas;
	}



	public void setCodigoVentas(String codigoVentas) {
		this.codigoVentas = codigoVentas;
	}
	
	
	
		
}
