package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {
	
	Conexion cnn= new Conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	
	public boolean Crea_Cliente(ClienteDTO client) {
		boolean resul=false;
		ClienteDTO usuexiste=null;
		try{
			usuexiste=Buscar_Cliente(client.getCedula());
			if(usuexiste==null) {
			String sql="insert into clientes values (?,?,?,?,?)";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, client.getCedula());
			ps.setString(2, client.getDireccion());
			ps.setString(3, client.getCorreo());
			ps.setString(4, client.getNombre());
			ps.setString(5, client.getTelefono());
			
			resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El Cliente ya existe..");
			}
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al insertar Cliente"+ex);
			
		}
		return resul;
	}
	
	public ClienteDTO Buscar_Cliente(int cedula) {
		
		ClienteDTO client=null;
		
		try {
			
			String sql= "select * from clientes where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			res=ps.executeQuery();
			while (res.next()) {
				client= new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
			
		}catch( SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al Consultar"+ex);
		}
		return client;
		
		
	}
	
	public boolean Actualizar_Cliente(ClienteDTO client) {
		boolean resul=false;
		try{
			
			String sql="update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
			
			ps = conec.prepareStatement(sql);
			
			ps.setString(1, client.getDireccion());
			ps.setString(2, client.getCorreo());
			ps.setString(3, client.getNombre());
			ps.setString(4, client.getTelefono());
			ps.setInt(5, client.getCedula());
			
			resul=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al actualizar Cliente"+ex);
			
		}
		return resul;
		
	}
		
		public boolean Borrar_Cliente(int cedula) {
			boolean resul=false;
			try{
				
				String sql="delete from clientes where cedula_cliente=?";
				ps = conec.prepareStatement(sql);
				
				ps.setInt(1, cedula);
				
				resul=ps.executeUpdate()>0;
				
			}catch(SQLException ex) {
				
				JOptionPane.showMessageDialog(null, "Error al Borrar cliente"+ex);
				
			}
			return resul;
			
		}

}
