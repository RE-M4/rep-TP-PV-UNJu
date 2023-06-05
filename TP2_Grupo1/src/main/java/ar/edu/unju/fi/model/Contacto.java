package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;

@Component 
public class Contacto {
	
	  @NotBlank(message="Debe ingresar nombre")
	private String nombre;
	
	  
	  @NotBlank(message="Debe ingresar email válido")
	private String email;
	  
	  @NotBlank(message="Debe ingresar ciudad en la que recide")
	private String ciudad;
	  
	  @NotBlank(message="Ingrese mensaje")
	private String mensaje;
	  

	
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
