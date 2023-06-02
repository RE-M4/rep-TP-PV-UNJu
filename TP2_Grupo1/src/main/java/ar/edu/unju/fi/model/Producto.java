package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
public class Producto {
	/*Atributos*/
	@NotEmpty(message = "El nombre no puede estar vacio")
	@NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    
	@NotEmpty(message = "La categoría no puede estar en vacio")
    @NotBlank(message = "La categoría no puede estar en blanco")
    private String categoria;
    
	@NotEmpty(message = "La imagen no puede estar en vacio")
    @NotBlank(message = "La imagen no puede estar en blanco")
    private String imagen;

    //el codigo no lleva validaciones porq en el controlador esta asegurado el codigo q corresponde
    private Integer codigo;

    @NotNull(message = "El descuento no puede ser nulo")
    @Min(value = 0, message = "El descuento debe ser igual o mayor que 0")
    @Max(value = 50, message = "El descuento no puede ser mayor que 50")
    private Integer descuento;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/*Constructores*/
	public Producto(String nombre, String categoria, Integer descuento, Double precio ,String imagen,Integer codigo) { /*String imagen*/
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descuento = descuento;
		this.precio = precio;
		this.imagen = imagen;
		this.codigo=codigo;
	}
	public Producto() {
	
	}
	
	/*Métodos*/
	
	
	public Double calcularDescuento() {
		if (getDescuento() == 0) {
			return getPrecio();
		} else {
			return getPrecio() - getPrecio()*(getDescuento()*0.01);
		}
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", categoria=" + categoria + ", imagen=" + imagen + ", codigo=" + codigo
				+ ", descuento=" + descuento + ", precio=" + precio + "]";
	}
	
	
}
