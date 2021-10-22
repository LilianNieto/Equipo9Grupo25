package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ProductosDTO;
import Modelo.ProductosDAO;

/**
 * Servlet implementation class productos
 */
@WebServlet("/productos")
public class productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductosDAO prodDAO= new ProductosDAO();
		if (request.getParameter("Insertar") !=null) {
			String nombre_producto, codigo_producto, nitproveedor;
			double Ivacompra, precio_compra, precio_venta;
			codigo_producto =request.getParameter("codigo_producto");
			Ivacompra =Double.parseDouble(request.getParameter("Ivacompra"));
			nitproveedor =request.getParameter("nitproveedor");
			nombre_producto =request.getParameter("nombre_producto");
			precio_compra =Double.parseDouble(request.getParameter("precio_compra"));
			precio_venta =Double.parseDouble(request.getParameter("precio_venta"));
			ProductosDTO prod= new ProductosDTO(codigo_producto,Ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta);
			if(prodDAO.Inserta_producto(prod)) {
				//JOptionPaneshowMessageDialog(null, "Se regitro el producto Exitosamente　");
				response.sendRedirect("producto.jsp?men=Se regitro el producto Exitosamente　");
			}else {
				//JOptionPane.showMessageDialog(null, "No Se Regitro el Producto");
				response.sendRedirect("producto.jsp?men=No se regitro el producto");
			}
				
		}
		if (request.getParameter("Consultar") !=null) {
			
			String codigo_producto=request.getParameter("codigo_producto"); 
			ProductosDTO prod=prodDAO.Buscar_producto("nitproveedor");
			if (prod!=null) {
				String nombre_producto, nitproveedor;
				double Ivacompra, precio_compra, precio_venta;
			nitproveedor=prod.getNitproveedor();
			nombre_producto=prod.getNombre_producto();
			codigo_producto=prod.getCodigo_producto();
			Ivacompra=prod.getIvacompra();
			precio_compra=prod.getPrecio_compra();
			precio_venta=prod.getPrecio_venta();
			response.sendRedirect("Producto.jsp?Codigo_producto="+codigo_producto+"&&Nitproveedor="+nitproveedor+
					"&&Nombre_producto="+nombre_producto+"&&Ivacompra="+Ivacompra+"&&Precio_compra="+precio_compra+
					"&&Precio_venta="+precio_venta);
			
			
		}else {
			JOptionPane.showMessageDialog(null,"El producto no existe");
			response.sendRedirect("producto.jsp");
			}
		}
		if (request.getParameter("Actualizar") !=null) {
			String nombre_producto, nitproveedor, codigo_producto;
			double Ivacompra, precio_compra, precio_venta;
			nitproveedor =request.getParameter("nitproveedor");
			nombre_producto =request.getParameter("nombre_producto");
			codigo_producto =request.getParameter("codigo_producto");
			Ivacompra =Double.parseDouble(request.getParameter("Ivacompra"));
			precio_compra =Double.parseDouble(request.getParameter("precio_compra"));
			precio_venta =Double.parseDouble(request.getParameter("precio_venta"));
			ProductosDTO prod= new ProductosDTO(codigo_producto,Ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta);
			if(prodDAO.Actualiza_producto(prod)) {
				//JOptionPaneshowMessageDialog(null, "Se regitro el producto Exitosamente　");
				response.sendRedirect("producto.jsp?men=Se actualizo el producto Exitosamente　");
			}else {
				//JOptionPane.showMessageDialog(null, "No se regitro el producto");
				response.sendRedirect("producto.jsp?men=No se actualizo el producto");
			}
		}
		if (request.getParameter("eliminar")!= null){
			
			String codigo_producto;
			codigo_producto=request.getParameter("cod");
			int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Producto: "+codigo_producto);
			if (op==0) {
			if(prodDAO.Eliminar_producto(codigo_producto)) {
			 response.sendRedirect("Producto.jsp?men=Producto Eliminado");
			 }else {
				 response.sendRedirect("Producto.jsp?men=Producto no se Elimino");
			 }
			}else {
				response.sendRedirect("productos.jsp");
			}
		}
		
		if (request.getParameter("cargar")!= null){
			
			Part archivo= request.getPart("archivo");
			String Url="C:\\Users\\57313\\eclipse-workspace\\TiendaGenerica1\\src\\main\\webapp\\Documento\\";
			try {
				InputStream file = archivo.getInputStream();
				File copia = new File(Url+"Base_prod.csv");
				FileOutputStream escribir  = new FileOutputStream(copia);
				int num= file.read();
				while(num != -1) {
					escribir.write(num);
					num=file.read();
				}
				escribir.close();
				file.close();
				JOptionPane.showMessageDialog(null, "Se Cargo El Archivo Correctamente");
				if(prodDAO.Cargar_producto(Url+"Documento.csv")) {
					response.sendRedirect("producto.jsp?men=Se Inserto Los Productos Corerctamente..");
					
				}else {
					response.sendRedirect("producto.jsp?men=No Se Inserto Los Productos Corerctamente..");
				}
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error De Archivo..."+e);
			
			}
		}
	}

}
