package ar.edu.unju.fi.model;

public class Producto {
	/*Atributos*/
	private String nombre, categoria; /*imagen*/
	private Integer codigo, descuento;
	private Double precio;
	
	/*Getters y Setters*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/*public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}*/
	/*Constructores*/
	public Producto(String nombre, String categoria, Integer codigo, Integer descuento, Double precio) { /*String imagen*/
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.codigo = codigo;
		this.descuento = descuento;
		this.precio = precio;
		/*this.imagen = imagen;*/
	}
	
	/*Métodos*/
	public Double calcularDescuento() {
		if (getDescuento() == 0) {
			return getPrecio();
		} else {
			return getPrecio() - getPrecio()*(getDescuento()*0.01);
		}
	}
}
