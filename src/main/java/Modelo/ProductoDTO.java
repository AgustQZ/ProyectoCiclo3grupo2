package Modelo;

public class ProductoDTO {
	
	private int codigo_producto;
	private int nitproveedor;
	private String nombreProducto;
	private int precio_compra;
	private int precio_venta;
	
	public ProductoDTO(int cod, int nit, String nombre,int precioCom, int precioVen) {
		
		this.codigo_producto = cod;
		this.nitproveedor = nit;
		this.nombreProducto = nombre;
		this.precio_compra = precioCom;
		this.precio_venta = precioVen;
		
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	

}
