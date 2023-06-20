package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
public class ConsejoSalud {
	
	@NotEmpty(message = "La imagen no puede estar vacia")
	@NotBlank(message = "La imagen no puede estar en blanco")
    private String img;

	 @NotEmpty(message = "El título no puede estar vacio")
    @NotBlank(message = "El título no puede estar en blanco")
    private String titulo;

	 @NotEmpty(message = "La descripción no puede estar vacio")
    @NotBlank(message = "La descripción no puede estar en blanco")
    private String descripcion;
    
    //Aca no agrego validacion porq en el controlador me aseguro que le estoy asignando el id adecuado
	private Integer id;
	
	
	/**
	 * Constructor sin parametros
	 */
	public ConsejoSalud() {
	}
	
	
	/**
	 * Constructor con parametros
	 * @param img
	 * @param titulo
	 * @param descripcion
	 * @param id
	 */
	public ConsejoSalud(String img, String titulo, String descripcion,Integer id) {
		super();
		this.img = img;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id=id;
	}
	
	//Getter and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	
}
