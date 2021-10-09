package Modelo;

public class ClienteDTO {
	
	private int cedula;
	private String direccion;
	private String nombre;
	private String telefono;
	private String correo;
	
	public ClienteDTO(int cedula, String direccion, String correo, String nombre,  String telefono) {
		this.cedula = cedula;
		this.telefono = telefono;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
				
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
}