package ar.edu.unju.fi.model;

import java.time.LocalDate;


public class Contacto {
	public String nombre;
	public String email;
	public String ciudad;
	public String mensaje;
	
public Contacto(String nombre, String email, String ciudad, String mensaje) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.ciudad = ciudad;
	this.mensaje = mensaje;
}

public Contacto() {}
	
	public String getnombre() {
		return nombre;
	}
	
	public String getemail() {
		return email;
	}
	public String getciudad() {
		return ciudad;
	}
	public String getmensaje() {
		return mensaje;
	}
	

}
