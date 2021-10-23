package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductosDAO {
	
	Conexion cnn= new Conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_producto(ProductosDTO prod) {
		boolean resul=false;
		ProductosDTO prodEx=null;  
		try {
		prodEx=Buscar_producto(prod.getCodigo_producto());
		if(prodEx==null) {
		String sql="Insert into productos values(?,?,?,?,?,?)";
		ps = conec.prepareStatement(sql);
		ps.setString(1,prod.getCodigo_producto());
		ps.setDouble(2,prod.getIvacompra());
		ps.setString(3,prod.getNitproveedor());
		ps.setString(4,prod.getNombre_producto());
		ps.setDouble(5,prod.getPrecio_compra());
		ps.setDouble(6,prod.getPrecio_venta());
		resul=ps.executeUpdate()>0;
		}else {
			JOptionPane.showMessageDialog(null, "El Producto ya Exixte...");
		}
	}catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al insertar productos"+ex);
		
		}
		return resul;
	}
	
	public ProductosDTO Buscar_producto(String codigo_producto) {
		
		ProductosDTO prod=null;
		try {
			String sql="select * from productos_ were codigo_producto=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, codigo_producto);		
			res=ps.executeQuery();
			while(res.next()) {
				prod= new ProductosDTO(res.getString(1), res.getDouble(2), res.getString(3), res.getString(4), res.getDouble(5), res.getDouble(6));
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar" +ex);
	
		} 
		return prod;

	}
	
	public boolean Actualiza_producto(ProductosDTO prod) {
		boolean resul=false;
		try {
		String sql="update productos_ set Ivacompra=?,nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=?,were codigo_producto=?";
		ps = conec.prepareStatement(sql);
		ps.setDouble(1,prod.getIvacompra());
		ps.setString(2,prod.getNitproveedor());
		ps.setString(3,prod.getNombre_producto());
		ps.setDouble(4,prod.getPrecio_compra());
		ps.setDouble(5,prod.getPrecio_venta());
		ps.setString(6,prod.getCodigo_producto());
		resul=ps.executeUpdate()>0;
		
	}catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acualizar producto"+ex);
		
		}
		return resul;
	}
	public boolean Eliminar_producto(String codigo_producto) {
		boolean resul=false;
		try {
		String sql="delete from productos_ were codigo_producto=?";
		ps = conec.prepareStatement(sql);
		ps.setString(1, codigo_producto);
		resul=ps.executeUpdate()>0;
		
	}catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al eliminar producto"+ex);
		
		}
		return resul;
	}
	public boolean Cargar_producto(String Ruta) {
		
	 boolean result=false;
	 try {	
	 String sql="load data infile '"+Ruta+"'into table producto fields terminated by ';' lines terminated by '\r\n';";	
	 ps=conec.prepareStatement(sql);
	 result=ps.executeUpdate()>0;
	 }catch (SQLException ex) {
		 JOptionPane.showMessageDialog(null, "Error al procesar el archivo..."+ex);
	}
	 return result;
	}
}
