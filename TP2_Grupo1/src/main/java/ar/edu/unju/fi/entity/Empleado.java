package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name="empleados")
public class Empleado {
	/*Atributos*/
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	@Column(name="emp_nombre")
	private String nombre;
	@Column(name="emp_apellido")
	private String apellido;
	@Column(name="emp_estado")
	private Boolean estado;
	/*Getters y Setters*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	/*Constructores*/
	public Empleado(String nombre, String apellido, Boolean estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
	}
	public Empleado() {
		this.estado = true;
	}
}
