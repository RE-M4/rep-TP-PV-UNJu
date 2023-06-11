package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Contacto;

public interface IContactoService {
	List<Contacto> getlistaMensajes();
	Contacto getContacto();
	
	public void borrarMensajes(Contacto contacto);
}
