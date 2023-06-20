package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

@Component
public class ServicioDePaseo {
	/*Atributos*/
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Size(min=5, max = 20, message="Este campo tiene que tener al menos 5 caracteres")
	private String horario;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Pattern(regexp = "[a-z A-Z]*", message="Este campo solo debe tener letras")
	private String paseador;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Pattern(regexp = "[a-z A-Z]*", message="Este campo solo debe tener letras")
	@Size(min=5, max = 20, message="Este campo tiene que tener al menos 5 caracteres")
	private String dia;
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
	/*Constructores*/
	public ServicioDePaseo(String horario, String paseador, String dia) {
		super();
		this.horario = horario;
		this.paseador = paseador;
		this.dia = dia;
	}
	public ServicioDePaseo() {
		
	}
}
