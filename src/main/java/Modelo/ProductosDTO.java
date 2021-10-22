package Modelo;

public class ProductosDTO {
	private String codigo_producto;
	private String nitproveedor;
	private String nombre_producto;
	private Double Ivacompra;
	private Double precio_compra;
	private Double precio_venta;
	
	public ProductosDTO(String codigo_producto, Double ivacompra, String nitproveedor, String nombre_producto,
			Double precio_compra, Double precio_venta) {

		this.codigo_producto = codigo_producto;
		Ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Double getIvacompra() {
		return Ivacompra;
	}

	public void setIvacompra(Double ivacompra) {
		Ivacompra = ivacompra;
	}

	public String getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	

}
