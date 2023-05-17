package ar.edu.unju.fi.listas;

import java.util.List;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Contacto;

public class ListaContacto {
	private List<Contacto> listaMensaje;
	public ListaContacto () {
		listaMensaje = new ArrayList<Contacto>();
	}
	public List<Contacto> getListaMensaje() {
		return listaMensaje;
	}
	public void setListaMensaje(List<Contacto> listaMensaje) {
		this.listaMensaje = listaMensaje;
	}
}
