package ar.edu.unju.fi.listas;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Contacto;

@Component
public class ListaContacto {
	private List<Contacto> listaMensaje;
	public ListaContacto () {
		listaMensaje = new ArrayList<Contacto>();
		listaMensaje.add(new Contacto("Juan","juan@gmail.com","San Salvador de Jujuy","Estoy muy conforme con los servicios brindados."));
		
	}
	
	public List<Contacto> getListaMensaje() {
		return listaMensaje;
	}
	public void setListaMensaje(List<Contacto> listaMensaje) {
		this.listaMensaje = listaMensaje;
	}
}
