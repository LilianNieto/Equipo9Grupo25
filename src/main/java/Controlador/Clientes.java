package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO clienDao= new ClienteDAO();
		if(request.getParameter("botonCrear")!=null) {
			String direccion, nombre, telefono, correo;
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("ceduCliente"));
			correo =request.getParameter("correoElectronCliente");
			nombre =request.getParameter("nombrecompletoCliente");
			direccion =request.getParameter("direccionCliente");
			telefono =request.getParameter("telefonCliente");
			
			ClienteDTO client= new ClienteDTO(cedula, direccion, correo, nombre, telefono);
			
			if(clienDao.Crea_Cliente(client)) {
				JOptionPane.showMessageDialog(null, "Se Registro el cliente exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Registro el cliente");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonConsultar")!=null) {
			
			int cedula=Integer.parseInt(request.getParameter("codigo2"));
			ClienteDTO client=clienDao.Buscar_Cliente(cedula);
			
			if(client!=null) {
			String direccion, nombre, telefono, correo;
			
		
			cedula=client.getCedula();
			nombre=client.getNombre();
			correo=client.getCorreo();
			direccion=client.getDireccion();
			telefono=client.getTelefono();
			response.sendRedirect("Menu.jsp?ceduCliente="+cedula+"&&nombrecompletoCliente="+nombre+"&&telefonCliente="+telefono
								+"&&correoElectronCliente="+correo+"&&direccionCliente="+direccion);
			
			}else
			{
				JOptionPane.showMessageDialog(null, "El cliente no existe");
				response.sendRedirect("Menu.jsp");
			}
			
		}
		
		if(request.getParameter("botonActualizar")!=null) {
			String direccion, nombre, telefono, correo;
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("codcliente"));
			telefono =request.getParameter("telefonCliente");
			nombre =request.getParameter("nombrecompletocliente");
			correo =request.getParameter("correoElectronCliente");
			direccion =request.getParameter("direccionCliente");
			
			ClienteDTO client= new ClienteDTO(cedula, direccion, correo, nombre, telefono);
			
			if(clienDao.Actualizar_Cliente(client)) {
				JOptionPane.showMessageDialog(null, "Se Actualizo el cliente exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Actualizo el cliente");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonBorrar")!=null) {
			
			int cedula;
			
			cedula =Integer.parseInt(request.getParameter("codcliente"));
			
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente con Cedula: "+cedula);
			if (op==0) {
				if(clienDao.Borrar_Cliente(cedula)) {
					JOptionPane.showMessageDialog(null, "Se Borro el cliente exitosamente....");
					response.sendRedirect("Menu.jsp?cliente Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "NO Se Elimino el cliente");
					response.sendRedirect("Menu.jsp?men=El cliente no se elimino");
				
				}
			}else {
				response.sendRedirect("Menu.jsp");
			}
		}
			
		
	}

}
