package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.listas.ListaContacto;

import ar.edu.unju.fi.controller.ContactoController;
import ar.edu.unju.fi.model.Contacto;

@Controller
public class ContactoController {
	
	ListaContacto listaMensajes = new ListaContacto();
	
	@GetMapping("/contacto")
	public String contacto(Model model) {
		model.addAttribute("Contacto", new Contacto());
		return "contacto";
	}
	
	@PostMapping("/guardarMensaje")
	public String guardar(Model model , Contacto contacto) {
		listaMensajes.getListaMensaje().add(contacto); 
		model.addAttribute("listaMensajes" , listaMensajes.getListaMensaje());
    return "listaMensaje";
	}
}