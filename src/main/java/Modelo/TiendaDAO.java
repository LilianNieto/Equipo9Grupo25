package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;



public class TiendaDAO {

	Conexion cnn= new Conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	
	public boolean Crea_Usuario(TiendaDTO usu) {
		boolean resul=false;
		try{
			
			String sql="insert into usuarios values (?,?,?,?,?)";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, usu.getCedula());
			ps.setString(2, usu.getCorreo());
			ps.setString(3, usu.getNombre());
			ps.setString(4, usu.getContrasena());
			ps.setString(5, usu.getUsuario());
			
			resul=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al insertar"+ex);
			
		}
		return resul;
	}
	
	public TiendaDTO Buscar_usuario(int cedula) {
		
		TiendaDTO usu=null;
		
		try {
			
			String sql= "select * from usuarios where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			res=ps.executeQuery();
			while (res.next()) {
				usu= new TiendaDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
			
		}catch( SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al Consultar"+ex);
		}
		return usu;
		
		
	}
	
	public boolean Actualizar_Usuario(TiendaDTO usu) {
		boolean resul=false;
		try{
			
			String sql="update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			
			ps.setString(1, usu.getCorreo());
			ps.setString(2, usu.getNombre());
			ps.setString(3, usu.getContrasena());
			ps.setString(4, usu.getUsuario());
			ps.setInt(5, usu.getCedula());
			
			resul=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al actualizar usuario"+ex);
			
		}
		return resul;
	}

}
