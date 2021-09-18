package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO uDAO = new UsuarioDAO();
		if(request.getParameter("crear")!=null) {
			String cedula, nombre, correo, pass, user;
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			pass = request.getParameter("pass");
			user = request.getParameter("user");
			UsuarioDTO uDTO = new UsuarioDTO(cedula, nombre, correo, pass, user);
			if(uDAO.insertarUsuario(uDTO)) {
				//JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
				response.sendRedirect("Usuarios.jsp?mensaje=Usuario creado exitosamente");
			}else {
				//JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
				response.sendRedirect("Usuarios.jsp?mensaje=No se pudo crear el usuario");
			}
		}
		if(request.getParameter("consultar")!= null) {
			String cedula = request.getParameter("cedula");
			UsuarioDTO userDTO = uDAO.buscarUsuario(cedula);
			String nombre, correo, pass, user;
			cedula = userDTO.getCedula_usuario();
			nombre = userDTO.getNombre_usuario();
			correo = userDTO.getEmail_usuario();
			pass = userDTO.getPassword();
			user = userDTO.getUsuario();
			response.sendRedirect("Usuario.jsp?cedula="+cedula+"&&nombre="+nombre+"&&correo="+pass+"&&user="+user);
		}
	}
}
