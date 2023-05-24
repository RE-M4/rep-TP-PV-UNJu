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

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getMensaje() {
	return mensaje;
}

public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
	

	

}
