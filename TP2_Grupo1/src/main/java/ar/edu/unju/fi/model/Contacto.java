package ar.edu.unju.fi.model;
/*
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;*/
import java.time.LocalDate;

/* @Component */
public class Contacto {
	public String nombre;
	/*
	 * @NotBlank(message="Debe ingresar nombre")
	 * @Size(min=3, message="El nombre debe contener como mínimo tres caracteres")
	 * @Pattern(regexp= "[a-z A-Z]", message="Debe ingresar unicamente letras")
	 *  */
	public String email;
	/* @NotBlank(message="Debe ingresar email válido")
	 * @Email(message = "El correo electrónico no es válido")
	 * @Size(min=1, message="Porfavor complete el campo correctamente")
	 *  */
	public String ciudad;
	/*@NotBlank(message="Debe ingresar ciudad en la que recide")
	 * @Size(min=1, message="Complete el campo con una ciudad válida")
	 * @Pattern(regexp= "[a-z A-Z]", message="Debe ingresar unicamente letras")
	 *  */
	public String mensaje;
	/*@NotBlank(message="Ingrese mensaje")
	 * @Size(min=1,max=100, message="El mensaje debe contener menos de 100 caracteres")
	 *  */
	
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
