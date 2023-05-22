package ar.edu.unju.fi.model;

public class ConsejoSalud {
	
	private String img;
	private String titulo;
	private String descripcion;
	private Integer id;
	
	
	
	 
	
	public ConsejoSalud() {
	}
	
	public ConsejoSalud(String img, String titulo, String descripcion,Integer id) {
		super();
		this.img = img;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id=id;
	}
	
	
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

	@Override
	public String toString() {
		return "ConsejoSalud [img=" + img + ", titulo=" + titulo + ", descripcion=" + descripcion + ", id=" + id + "]";
	}
	
	
}
