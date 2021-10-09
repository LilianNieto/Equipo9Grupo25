package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProveedorDAO {
	
	Conexion cnn= new Conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	
	public boolean Crea_Proveedor(ProveedorDTO pro) {
		boolean resul=false;
		ProveedorDTO proexiste=null;
		try{
			proexiste=Buscar_Proveedor(pro.getNit());
			if(proexiste==null) {
			String sql="insert into proveedores values (?,?,?,?,?)";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, pro.getNit());
			ps.setString(2, pro.getCiudad());
			ps.setString(3, pro.getDireccion());
			ps.setString(4, pro.getNombre());
			ps.setString(5, pro.getTelefono());
			
			resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El Proveedor ya existe..");
			}
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al insertar"+ex);
			
		}
		return resul;
	}
	
	public ProveedorDTO Buscar_Proveedor(int nit) {
		
		ProveedorDTO pro=null;
		
		try {
			
			String sql= "select * from proveedores where nit_proveedor=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, nit);
			res=ps.executeQuery();
			while (res.next()) {
				pro= new ProveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
			
		}catch( SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al Consultar"+ex);
		}
		return pro;
		
		
	}
	
	public boolean Actualizar_Proveedor(ProveedorDTO pro) {
		boolean resul=false;
		try{
			
			String sql="update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nit_proveedor=?";
			ps = conec.prepareStatement(sql);
			
			ps.setString(1, pro.getCiudad());
			ps.setString(2, pro.getDireccion());
			ps.setString(3, pro.getNombre());
			ps.setString(4, pro.getTelefono());
			ps.setInt(5, pro.getNit());
			
			resul=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al actualizar proveedor"+ex);
			
		}
		return resul;
		
	}
		
		public boolean Borrar_Proveedor(int nit) {
			boolean resul=false;
			try{
				
				String sql="delete from proveedores where nit_proveedor=?";
				ps = conec.prepareStatement(sql);
				
				ps.setInt(1, nit);
				
				resul=ps.executeUpdate()>0;
				
			}catch(SQLException ex) {
				
				JOptionPane.showMessageDialog(null, "Error al Borrar proveedor"+ex);
				
			}
			return resul;
			
			
	}
	

}
