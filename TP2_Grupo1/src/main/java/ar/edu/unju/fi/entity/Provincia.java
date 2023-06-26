package ar.edu.unju.fi.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="provincias")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Long id;
	
	@Column(name="pro_nombre")
	private String nombre;

	@Column(name="pro_estado")
	private Boolean estado;

	public Provincia() {}
	public Provincia(Long id, String nombre, Boolean estado) {
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString(){
		return "Provincia [id="+id+", nombre="+nombre+", estado="+estado+"]";
	}
}
