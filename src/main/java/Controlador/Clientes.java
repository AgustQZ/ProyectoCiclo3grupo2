package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creacion cliente DAO//
		
		ClienteDAO clienteDAO = new ClienteDAO();
		if(request.getParameter("crear") != null) {
			String nombre,cedula, email, direccion, telefono;
			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			email =  request.getParameter("email");
			direccion = request.getParameter("telefono");
			telefono = request.getParameter("direccion");
			
			//creacion de clienteDTO paso de informacion para crear un nuevo cliente//
			
			ClienteDTO cliente = new ClienteDTO(nombre, cedula, email, direccion, telefono );
			
			//ingreso del nuevo cliente a la base de datos//
			
			if(clienteDAO.CrearCliente(cliente)) {
				
				//muestra del mensaje en la página html de creacion o de error//
				
				response.sendRedirect("Clientes.jsp?mensaje=Usuario creado exitosamente");
										
			} else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al crear usuario");
			}
			
			
		}
		
		
		
		if(request.getParameter("consultar") != null) {
			
			//consultar usuario
			
			String cedula = request.getParameter("cedula");
			ClienteDTO cliente = clienteDAO.consultarCliente(cedula);
			
			if(cliente != null) {
				String nombre,correo,direccion,telefono;
				
				cedula = cliente.getCedula_cliente();
				nombre = cliente.getNombre_cliente();
				correo = cliente.getEmail_cliente();
				direccion = cliente.getDireccion_cliente();
				telefono = cliente.getTelefono_cliente();
				response.sendRedirect("Cliente.jsp?cedula="+cedula+"&&direccion="+direccion+"&&email="+correo+"&&nombre="+nombre+"&&telefono="+telefono);
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al consultar usuario");
				response.sendRedirect("Cliente.jsp");
			}
		
		}
		
		else if(request.getParameter("actualizar") != null) {
			
			String cedula,direccion,correo,nombre,telefono;
			
			cedula = request.getParameter("code");
			direccion = request.getParameter("direccion");
			correo = request.getParameter("email");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("telefono");
			
			ClienteDTO  cliente = new ClienteDTO(cedula,direccion,correo,nombre,telefono);
			
			if(clienteDAO.actualizarUsuario(cliente)) {
				response.sendRedirect("Cliente.jsp?mensaje=Usuario actualizado exitosamente");
			}else {
				response.sendRedirect("Cliente.jsp?mensaje=Usuario  no actualizado");
				response.sendRedirect("Cliente.jsp");
			}
			
		
		}
		
		else if (request.getParameter("eliminar")!= null) {
			String cedula = request.getParameter("code");
			if(clienteDAO.eliminarUsuario(cedula)) {
				response.sendRedirect("Cliente.jsp?mensaje=Usuario eliminado exitosamente");
			}else {
				response.sendRedirect("Cliente.jsp?mensaje=Usuario  no eliminado");
				response.sendRedirect("Cliente.jsp");
			}
		}
	}

}
