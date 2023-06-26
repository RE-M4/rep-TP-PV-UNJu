package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_id")
	private Long id;
	
	@Column(name="cat_nombre")
	private String nombre;
	
	@Column(name="cat_estado")
	private Boolean estado;
	
	
	public Categoria() {}
	
	
	
	
	public Categoria(Long id, String nombre, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Boolean getEstado() {
		return estado;
	}




	public void setEstado(Boolean estado) {
		this.estado = estado;
	}




	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
	
}
