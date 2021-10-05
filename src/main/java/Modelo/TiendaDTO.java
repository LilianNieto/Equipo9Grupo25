package Modelo;

public class TiendaDTO {
	
	private int cedula;
	private String usuario;
	private String nombre;
	private String contrasena;
	private String correo;
	
	
	public TiendaDTO(int cedula, String usuario, String nombre, String contrasena, String correo) {
		this.cedula = cedula;
		this.usuario = usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.correo = correo;
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
	
}
