package ar.edu.unju.fi.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Component
@Entity
@Table(name="productos")
public class Producto {
	
	
	/*Atributos*/
	@NotEmpty(message = "El nombre no puede estar vacio")
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Column(name="prod_nombre")
	private String nombre;
	
	
    
	
	@JoinColumn(name="cat_id")
	@OneToOne(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
	private Categoria categoria;
	
	
    
	@NotEmpty(message = "La imagen no puede estar en vacio")
    @NotBlank(message = "La imagen no puede estar en blanco")
	@Column(name="prod_imagen")
	private String imagen;

    //el codigo no lleva validaciones porq en el controlador esta asegurado el codigo q corresponde

	@Id
	@Column(name="prod_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

    @NotNull(message = "El descuento no puede ser nulo")
    @Min(value = 0, message = "El descuento debe ser igual o mayor que 0")
    @Max(value = 50, message = "El descuento no puede ser mayor que 50")
    @Column(name="prod_descuento")
    private Integer descuento;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    @Column(name="prod_precio")
    private Double precio;
	
    @Column(name="prod_estado")
    private boolean estado;
    
	/*Getters y Setters*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
	
	
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/*Constructores*/
	public Producto(String nombre, Categoria categoria, Integer descuento, Double precio ,String imagen) { /*String imagen*/
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descuento = descuento;
		this.precio = precio;
		this.imagen = imagen;
		this.estado=true;
	}
	public Producto() {
		this.estado=true;
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
