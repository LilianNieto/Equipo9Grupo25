package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedorDAO proDAO= new ProveedorDAO();
		if(request.getParameter("botonCrear")!=null) {
			int nit;
			String ciudad, direccion, nombre, telefono;
			
			nit =Integer.parseInt(request.getParameter("nitProveedor"));
			ciudad=request.getParameter("ciudadProveedor");
			direccion =request.getParameter("direccionProvedor");
			nombre =request.getParameter("nombreProveedor");
			telefono =request.getParameter("telefonProveedor");
			ProveedorDTO pro= new ProveedorDTO(nit, ciudad, direccion, nombre, telefono);
			
			if(proDAO.Crea_Proveedor(pro)) {
				JOptionPane.showMessageDialog(null, "Se Registro Proveedor exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Registro Proveedor");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonConsultar")!=null) {
			
			int nit=Integer.parseInt(request.getParameter("nitProveedor"));
			ProveedorDTO pro=proDAO.Buscar_Proveedor(nit);
			
			if(pro!=null) {
			
				String ciudad, direccion, nombre, telefono;
			
		
				nit =pro.getNit();
				ciudad=pro.getCiudad();
				direccion = pro.getDireccion();
				nombre = pro.getNombre();
				telefono = pro.getTelefono();
				
			response.sendRedirect("Menu.jsp?nitProveedor="+nit+"&&ciudadProveedor="+ciudad+"&&direccionProvedor="+direccion+"&&nombreProveedor="
								+nombre+"&&telefonProveedor="+telefono);
			}else
			{
				JOptionPane.showMessageDialog(null, "El Proveedor no existe");
				response.sendRedirect("Menu.jsp");
			}
			
		}
		
		if(request.getParameter("botonActualizar")!=null) {
			int nit;
			String ciudad, direccion, nombre, telefono;
			
			nit =Integer.parseInt(request.getParameter("nitProveedor"));
			ciudad=request.getParameter("ciudadProveedor");
			direccion =request.getParameter("direccionProvedor");
			nombre =request.getParameter("nombreProveedor");
			telefono =request.getParameter("telefonProveedor");
			ProveedorDTO pro= new ProveedorDTO(nit, ciudad, direccion, nombre, telefono);
			
			if(proDAO.Actualizar_Proveedor(pro)) {
				JOptionPane.showMessageDialog(null, "Se Actualizo  Proveedor exitosamente....");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "NO Se Actualizo Proveedor");
				response.sendRedirect("Menu.jsp");
				
			}
			
		}
		
		if(request.getParameter("botonBorrar")!=null) {
			
			int nit;
						
			nit=Integer.parseInt(request.getParameter("nitProveedor"));
			
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el Proveedor con Nit: "+nit);
			if (op==0) {
				if(proDAO.Borrar_Proveedor(nit)) {
					JOptionPane.showMessageDialog(null, "Se Borro el Proveedor exitosamente....");
					response.sendRedirect("Menu.jsp?Proveedor Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "NO Se Elimino Proveedor ");
					response.sendRedirect("Menu.jsp?men=El Proveedor no se elimino");
				
				}
			}else {
				response.sendRedirect("Menu.jsp");
			}
		}
			
		
	}

}
