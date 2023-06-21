package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
@Entity
@Table(name="Consejos_Salud")
public class ConsejoSalud {
	
	//Aca no agrego validacion porq en el controlador me aseguro que le estoy asignando el id adecuado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="con_id")
	private Long id;

	
	
	
    @Column(name="con_img")
	private String img;

	 @NotEmpty(message = "El título no puede estar vacio")
	 @NotBlank(message = "El título no puede estar en blanco")
	 @Column(name="con_titulo",length = 50)
	 private String titulo;

	 @NotEmpty(message = "La descripción no puede estar vacio")
	 @NotBlank(message = "La descripción no puede estar en blanco")
	 @Column(name="con_descripcion")
	 private String descripcion;
    
	 @Column(name="con_estado")
	 private boolean estado;
    	
	
	/**
	 * Constructor sin parametros
	 */
	public ConsejoSalud() {
		this.estado = true;
	}
	
	
	/**
	 * Constructor con parametros
	 * @param img
	 * @param titulo
	 * @param descripcion
	 * @param id
	 */
	public ConsejoSalud(String img, String titulo, String descripcion) {
		super();
		this.img = img;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = true;
		
	}
	
	//Getter and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	/**
	 * toString para mostrar el objeto
	 */
	@Override
	public String toString() {
		return "ConsejoSalud [img=" + img + ", titulo=" + titulo + ", descripcion=" + descripcion + ", id=" + id + "]";
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
