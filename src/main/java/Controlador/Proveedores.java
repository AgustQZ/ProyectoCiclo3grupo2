package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedoresDAO;
import Modelo.ProveedoresDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Proveedores
 */
@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedores() {
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
		
		ProveedoresDAO proveedor = new ProveedoresDAO();
		
		if(request.getParameter("crear")!=null) {
			String  nombre, direccion, telefono, ciudad;
			int nit;
			
			nit = Integer.parseInt(request.getParameter("nit"));
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ciudad = request.getParameter("ciudad");
			ProveedoresDTO proveedorDTO = new ProveedoresDTO(nit, nombre,direccion, telefono, ciudad);
			if(proveedor.CrearCliente(proveedorDTO)) {
				//JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
				response.sendRedirect("Proveedores.jsp?mensaje=Usuario creado exitosamente");
			}else {
				//JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
				response.sendRedirect("Proveedores.jsp?mensaje=Error al crear el usuario");
			}
		
			
		}else if(request.getParameter("consultar")!= null) {
			int nit = Integer.parseInt(request.getParameter("nit"));
			ProveedoresDTO proveedorDTO = proveedor.consultarProveedor(nit);
			if(proveedorDTO!=null) {
				String nombre, direccion, telefono, ciudad, estado;
				nit = proveedorDTO.getNit_proveedor();
				nombre = proveedorDTO.getNombre_proveedor();
				direccion = proveedorDTO.getDireccion_proveedor();
				telefono = proveedorDTO.getTelefono_proveedor();
				ciudad = proveedorDTO.getCiudad_proveedor();
				estado = "disabled";
				response.sendRedirect("Proveedores.jsp?nit="+nit+"&&nombre="+nombre+"&&direccion="+direccion+"&&telefono="+telefono+"&&ciudad="+ciudad+"&&estado="+estado);
			}else {
			JOptionPane.showMessageDialog(null, "El usuario no existe");
			response.sendRedirect("Proveedores.jsp");
			}
		}  else if(request.getParameter("actualizar")!=null) { 
			String  nombre, correo, user, pass;
			int cedula;
			cedula = Integer.parseInt(request.getParameter("code"));//NOTA: se utiliza esta variable ya que se deshabilito el input "nit" del proveedor.jsp
			nombre = request.getParameter("nombre");
			correo = request.getParameter("direccion");
			user = request.getParameter("telefono");
			pass = request.getParameter("ciudad");
			ProveedoresDTO proveedorDTO = new ProveedoresDTO(cedula, nombre, correo, user, pass);
			if(proveedor.actualizarProveedor(proveedorDTO)) {
				response.sendRedirect("Proveedores.jsp?mensaje=Usuario actualizado exitosamente");
			}else {
			response.sendRedirect("Proveedores.jsp?mensaje=Error al actualizar el usuario");
			}
		}else if(request.getParameter("eliminar")!=null) {
			int cedula = Integer.parseInt(request.getParameter("code"));			
			if(proveedor.eliminarproveedor(cedula)) {
				response.sendRedirect("Proveedores.jsp?mensaje=Usuario eliminado exitosamente");
			}else {
				response.sendRedirect("Proveedores.jsp?mensaje=Cedula de usuario no existe");
			}
		}
		
		else if(request.getParameter("limpiar") != null) {
			
			String nombre, direccion, telefono, ciudad,estado;
			int nit;
			nit = 0;
			nombre ="";
			direccion ="";
			telefono = "";
			ciudad ="";
			estado = "";
			response.sendRedirect("Proveedores.jsp?nit="+nit+"&&nombre="+nombre+"&&direccion="+direccion+"&&telefono="+telefono+"&&ciudad="+ciudad+"&&estado="+estado);

			
		}
	}

}
