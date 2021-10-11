package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("consulta") != null) {

			String cedula = request.getParameter("cedula");
			ClienteDAO cliente = new ClienteDAO();
			ClienteDTO clienteDTO = cliente.consultarCliente(cedula);

			if (clienteDTO != null) {
				cedula = clienteDTO.getCedula_cliente();
				String nombre = clienteDTO.getNombre_cliente();
				response.sendRedirect("Ventas.jsp?cedula=" + cedula + "&&nombre=" + nombre);
			} else {
				response.sendRedirect("ventas.jsp?men=El cliente no Existe");
			}

		}

		if (request.getParameter("consultarProductoUno") != null) {

			long codigo = Long.parseLong(request.getParameter("cod.producto"));

			ProductoDAO producto = new ProductoDAO();
			ProductoDTO productoDTO = producto.consultarProducto(codigo);

			if (productoDTO != null) {

				codigo = productoDTO.getCodigo_producto();
				String nombre = productoDTO.getNombreProducto();

				response.sendRedirect("Ventas.jsp?codigoUno=" + codigo + "&&productoUno=" + nombre);

			}

		}

		if (request.getParameter("consultarProductoDos") != null) {

			long codigo = Long.parseLong(request.getParameter("codigoProductoDos"));

			ProductoDAO producto = new ProductoDAO();
			ProductoDTO productoDTO = producto.consultarProducto(codigo);

			if (productoDTO != null) {

				codigo = productoDTO.getCodigo_producto();
				String nombre = productoDTO.getNombreProducto();
				// int cantidad = Integer.parseInt(request.getParameter("cantidadDos"));
				int precio = /* cantidad * */productoDTO.getPrecio_venta();

				response.sendRedirect("Ventas.jsp?codigoDos=" + codigo + "&&productoDos=" + nombre );

			}

		}

		if (request.getParameter("consultarProductoTres") != null) {

			long codigo = Long.parseLong(request.getParameter("codigoProductoTres"));

			ProductoDAO producto = new ProductoDAO();
			ProductoDTO productoDTO = producto.consultarProducto(codigo);

			if (productoDTO != null) {

				codigo = productoDTO.getCodigo_producto();
				String nombre = productoDTO.getNombreProducto();

				int precio = /* cantidad * */productoDTO.getPrecio_venta();

				response.sendRedirect(
						"Ventas.jsp?codigoTres=" + codigo + "&&productoTres=" + nombre);

			}

		}

		if (request.getParameter("darCantidadUno") != null) {

			String cedula = request.getParameter("cedula");
			ClienteDAO cliente = new ClienteDAO();
			ClienteDTO clienteDTO = cliente.consultarCliente(cedula);

			long codigo = Long.parseLong(request.getParameter("cod.producto"));
			ProductoDAO producto = new ProductoDAO();

			ProductoDTO productoDTO = producto.consultarProducto(codigo);

			if (productoDTO != null) {

				codigo = productoDTO.getCodigo_producto();

				String nombre = productoDTO.getNombreProducto();

				int precio = productoDTO.getPrecio_venta();

				int cantidad = Integer.parseInt(request.getParameter("cantidadUno"));

				int total = precio * cantidad;

				response.sendRedirect("Ventas.jsp?codigoUno=" + codigo + "&&productoUno=" + nombre+"&&cantidadUno="+ cantidad + "&&precioUno=" + total);
			}
			
		}
			
			if (request.getParameter("darCantidadDos") != null) {

				String cedula = request.getParameter("cedula");
				ClienteDAO cliente = new ClienteDAO();
				ClienteDTO clienteDTO = cliente.consultarCliente(cedula);

				long codigo = Long.parseLong(request.getParameter("codigoProductoDos"));
				ProductoDAO producto = new ProductoDAO();

				ProductoDTO productoDTO = producto.consultarProducto(codigo);

				if (productoDTO != null) {

					codigo = productoDTO.getCodigo_producto();

					String nombre = productoDTO.getNombreProducto();

					int precio = productoDTO.getPrecio_venta();

					int cantidad = Integer.parseInt(request.getParameter("cantidadDos"));

					int total = precio * cantidad;

					response.sendRedirect("Ventas.jsp?codigoDos=" + codigo + "&&productoDos=" + nombre+"&&cantidadDos="+ cantidad + "&&precioDos=" + total);
				}
				

		
			}
			
			if (request.getParameter("darCantidadTres") != null) {

				String cedula = request.getParameter("cedula");
				ClienteDAO cliente = new ClienteDAO();
				ClienteDTO clienteDTO = cliente.consultarCliente(cedula);

				long codigo = Long.parseLong(request.getParameter("codigoProductoTres"));
				ProductoDAO producto = new ProductoDAO();

				ProductoDTO productoDTO = producto.consultarProducto(codigo);

				if (productoDTO != null) {

					codigo = productoDTO.getCodigo_producto();

					String nombre = productoDTO.getNombreProducto();

					int precio = productoDTO.getPrecio_venta();

					int cantidad = Integer.parseInt(request.getParameter("cantidadTres"));

					int total = precio * cantidad;

					response.sendRedirect("Ventas.jsp?codigoTres=" + codigo + "&&productoTres=" + nombre+"&&cantidadTres="+ cantidad + "&&precioTres=" + total);
				}
				

		
			}
	}

}
