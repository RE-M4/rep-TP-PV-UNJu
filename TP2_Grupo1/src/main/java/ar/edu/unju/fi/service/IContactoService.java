package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Contacto;

public interface IContactoService {
	List<Contacto> getlistaMensajes();
	Contacto getContacto();
	public void guardarMensaje(Contacto contacto);
	
	public void borrarMensajes(Contacto contacto);
}
