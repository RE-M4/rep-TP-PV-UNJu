package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/*Se agrega "Component", esta etiqueta sirve para que el objeto sirva como inyección de dependencia dentro de la capa service*/
/*"Entity" y "Table" sirve para que ahora actuen como tablas para MySQL*/
@Component
@Entity
@Table(name = "servicios")
public class ServicioDePaseo {
	/*Atributos con validaciones*/
	/* El nuevo atributo "id" se crea a partir de la implementación de la capa repository*/
	/* La etiqueta "Column" sirve para poner nombres personalizados a las columnas de la tabla en MySQL*/
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Esta etiqueta hace que se generen ids automáticamente al momento de crear la tabla en MySQL
    @Column(name="serv_id")
	private Long id;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Size(min=5, max = 20, message="Este campo tiene que tener al menos 5 caracteres")
	@Column(name="serv_horario")
	private String horario;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Pattern(regexp = "[a-z A-Z]*", message="Este campo solo debe tener letras")
	@Column(name="serv_paseador")
	private String paseador;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Pattern(regexp = "[a-z A-Z]*", message="Este campo solo debe tener letras")
	@Size(min=5, max = 20, message="Este campo tiene que tener al menos 5 caracteres")
	@Column(name="serv_dia")
	private String dia;
	@Column(name="serv_estado")
	private boolean estado;
	/*Getters y setters*/
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPaseador() {
		return paseador;
	}
	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/*Constructores*/
	public ServicioDePaseo(String horario, String paseador, String dia, Boolean estado) {
		super();
		this.horario = horario;
		this.paseador = paseador;
		this.dia = dia;
		this.estado = true;
	}
	/*Se actualiza este constructor para que cada objeto nuevo que se cree, siempre tenga estado en true*/
	public ServicioDePaseo() {
		this.estado = true;
	}
}
