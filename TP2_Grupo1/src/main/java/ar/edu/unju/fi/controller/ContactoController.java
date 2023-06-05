package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.fi.listas.ListaContacto;

import ar.edu.unju.fi.controller.ContactoController;

import ar.edu.unju.fi.model.Contacto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	ListaContacto listaMensajes;
	
	@Autowired
	Contacto contacto;
	
	@GetMapping("/listaMensaje")
	public String contacto(Model model) {
		model.addAttribute("contacto", listaMensajes.getListaMensaje());
		return "listaMensaje";
	}
	
	@PostMapping("/guardarMensaje")
    public String guardar(Model model ,@Valid @ModelAttribute("Contacto") Contacto contacto,BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("Contacto",  contacto);
            return "contacto";
        }

        System.out.println(contacto);
        listaMensajes.getListaMensaje().add(contacto); 
        model.addAttribute("listaMensajes" , listaMensajes.getListaMensaje());
    return "redirect:/contacto/listaMensaje";
    }
	
	 
	@GetMapping("/contacto")
	public String getContacto(Model model ) {
		model.addAttribute("Contacto", new Contacto());
		return "contacto";
	}
	
	@GetMapping("/eliminar_mensaje/{nombreMensaje}")
    public String eliminarMensaje(Model model, @PathVariable(value="nombreMensaje")String nombreMensaje) {
	for (Contacto contacto  : listaMensajes.getListaMensaje()) {
		if (contacto.getNombre().equals(nombreMensaje)) {
				listaMensajes.getListaMensaje().remove(contacto);
			break;
		}
	}
	return "redirect:/contacto/listaMensaje";
	}
	
}	