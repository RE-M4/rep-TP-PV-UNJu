package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component 
@Entity
@Table(name="tablamensajes")
public class Contacto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="col_id")
	private long id;
	
	@NotBlank(message="Debe ingresar nombre")
	@Size(min=3, message="El nombre debe contener como mínimo tres caracteres")
	@Column(name="col_nombre" , nullable= false )
	private String nombre;
	
	  @NotBlank(message="Debe ingresar email válido")
	  @Email(message = "El correo electrónico no es válido")
	  @Size(min=1, message="Porfavor complete el campo correctamente")
	  @Column(name="col_email" , nullable= false)
	  private String email;
	 
     @NotBlank(message="Debe ingresar ciudad en la que recide")
	 @Size(min=1, message="Complete el campo con una ciudad válida")
     @Column(name="col_ciudad" , nullable= false)
	 private String ciudad;
	
	
	
	@NotBlank(message="Ingrese mensaje")
	@Size(min=1,max=100, message="El mensaje debe contener menos de 100 caracteres")
	@Column(name="col_mensaje" , nullable= false)
	private String mensaje;
	
	@Column(name="col_estado")
	private boolean estado;
	
	
public Contacto(long id,String nombre, String email, String ciudad, String mensaje) {
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
}
