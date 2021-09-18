package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("enviar")!=null) {
			String usuario, contrasena;
			usuario = request.getParameter("user");
			contrasena = request.getParameter("pass");
			if(usuario.equals("admininicial") && contrasena.equals("admin123456")) {
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
				response.sendRedirect("Login.jsp");
			}
		}
	}

}
