package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.TiendaDAO;
import Modelo.TiendaDTO;

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
		
		TiendaDAO usuDao= new TiendaDAO();
		if(request.getParameter("botonCrear")!=null) {
			String usuario, nombre, contraseña, correo;
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("ceduUsuario"));
			usuario =request.getParameter("usuar");
			nombre =request.getParameter("nombrecompletoUsuario");
			contraseña =request.getParameter("contrasUsuario");
			correo =request.getParameter("correoElectUsuario");
			TiendaDTO usu= new TiendaDTO(cedula, usuario, nombre, contraseña, correo);
			
			if(usuDao.Crea_Usuario(usu)) {
				JOptionPane.showMessageDialog(null, "Se Registro el Usuario exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Registro el Usuario");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonConsultar")!=null) {
			
			int cedula=Integer.parseInt(request.getParameter("codigo"));
			TiendaDTO usu=usuDao.Buscar_usuario(cedula);
			
			if(usu!=null) {
			String usuario, nombre, contraseña, correo;
			
		
			cedula=usu.getCedula();
			nombre=usu.getNombre();
			correo=usu.getCorreo();
			usuario=usu.getUsuario();
			contraseña=usu.getContrasena();
			response.sendRedirect("Menu.jsp?ceduUsuario="+cedula+"&&correoElectUsuario="+correo+"&&nombrecompletoUsuario="+nombre+"&&contrasUsuario="
								+contraseña+"&&usuar="+usuario);
			}else
			{
				JOptionPane.showMessageDialog(null, "El Usuario no existe");
				response.sendRedirect("Menu.jsp");
			}
			
		}
		
		if(request.getParameter("botonActualizar")!=null) {
			String usuario, nombre, contraseña, correo;
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("cod"));
			usuario =request.getParameter("usuar");
			nombre =request.getParameter("nombrecompletoUsuario");
			contraseña =request.getParameter("contrasUsuario");
			correo =request.getParameter("correoElectUsuario");
			TiendaDTO usu= new TiendaDTO(cedula, usuario, nombre, contraseña, correo);
			
			if(usuDao.Actualizar_Usuario(usu)) {
				JOptionPane.showMessageDialog(null, "Se Actualizo el Usuario exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Actualizo el Usuario");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonBorrar")!=null) {
			
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("cod"));
			
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario con Cedula: "+cedula);
			if (op==0) {
				if(usuDao.Borrar_Usuario(cedula)) {
					JOptionPane.showMessageDialog(null, "Se Borro el Usuario exitosamente....");
					response.sendRedirect("Menu.jsp?Usuario Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "NO Se Elimino el Usuario");
					response.sendRedirect("Menu.jsp?men=El Usuario no se elimino");
				
				}
			}else {
				response.sendRedirect("Menu.jsp");
			}
		}
			
	}
		
		
}


