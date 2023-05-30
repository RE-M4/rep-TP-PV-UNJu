package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class ConsejoSalud {
	
	private String img;
	private String titulo;
	private String descripcion;
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
