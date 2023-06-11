package ar.edu.unju.fi.service.imp;


import ar.edu.unju.fi.listas.ListaContacto;
import ar.edu.unju.fi.model.Contacto;
import ar.edu.unju.fi.service.IContactoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImp implements IContactoService{
	@Autowired
	private Contacto contacto;
	
	@Autowired
	private ListaContacto listaMensajes;

	@Override
	public List<Contacto> getlistaMensajes() {		
		return listaMensajes.getListaMensaje();
	}
	public Contacto getContacto() {
		return this.contacto;
	}
	
	@Override
	public void borrarMensajes(Contacto contacto) {
		listaMensajes.getListaMensaje().remove(contacto);
	}
}
