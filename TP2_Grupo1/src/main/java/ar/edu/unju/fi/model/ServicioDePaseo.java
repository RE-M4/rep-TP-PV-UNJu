package ar.edu.unju.fi.model;

public class ServicioDePaseo {
	/*Atributos*/
	private String horario;
	private String paseador;
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
