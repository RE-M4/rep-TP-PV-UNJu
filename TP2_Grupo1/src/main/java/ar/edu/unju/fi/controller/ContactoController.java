package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaContacto;

import ar.edu.unju.fi.controller.ContactoController;
import ar.edu.unju.fi.model.Contacto;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	ListaContacto listaMensajes = new ListaContacto();
	
	@GetMapping("/listaMensaje")
	public String contacto(Model model) {
		model.addAttribute("contacto", listaMensajes.getListaMensaje());
		return "listaMensaje";
	}
	
	@PostMapping("/guardarMensaje")
	public String guardar(Model model , Contacto contacto) {
		listaMensajes.getListaMensaje().add(contacto); 
		model.addAttribute("listaMensajes" , listaMensajes.getListaMensaje());
    return "listaMensaje";
	}
	/*@GetMapping("/eliminarMensaje/{nombreMensaje}")
    public String eliminarMensaje(Model model, @PathVariable(value="nombreMensaje")String nombreMensaje) {
    Contacto mensajeEncontrado = new Contacto();
    for(Contacto contacto : listaMensajes.getListaMensaje()) {
    if(contacto.getNombre().equals(nombreMensaje)) {
      mensajeEncontrado = contacto;
      mensajeEncontrado.setNombre("");
      mensajeEncontrado.setEmail("");
      mensajeEncontrado.setCiudad("");
      mensajeEncontrado.setMensaje("");
      break;
    }	
	}
	return "redirect:/contacto/listaMensaje";
	}
	*/
}	
