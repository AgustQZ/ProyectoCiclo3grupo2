package Modelo;

public class VentasDTO {
	
	String codigoVentas;
	String NombreCliente;
	String cedulaCliente;
	int ivaVenta;	// iva de la venta
	int totalVenta;// total sin iva
	int valorVenta; // total con iva
	
	public VentasDTO(int iva, int sinIva, int total) {
		
		this.ivaVenta = iva;
		this.totalVenta = sinIva;
		this.valorVenta = total;
		
		
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

	public int getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(int ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public int getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}

	public int getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(int valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	
	
		
}
