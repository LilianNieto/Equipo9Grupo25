package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	
	private String bd="mydb";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="";
	
	Connection conec=null;
	
	public Connection Conecta() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conec = DriverManager.getConnection(url, user, pass);
			//JOptionPane.showMessageDialog(null, "Conexion ok....");
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en Conexion..."+e);
			
		}
		
		return conec;
	}

}
