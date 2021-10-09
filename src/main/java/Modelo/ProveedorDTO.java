package Modelo;

public class ProveedorDTO {
	
	private int nit;
	private String ciudad;
	private String direccion;
	private String nombre;
	private String telefono;
	
	public ProveedorDTO(int nit, String ciudad, String direccion, String nombre, String telefono) {
		
		this.nit = nit;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		
	}


	public int getNit() {
		return nit;
	}


	public void setNit(int nit) {
		this.nit = nit;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
 	
	

}
