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




import ar.edu.unju.fi.controller.ContactoController;
import ar.edu.unju.fi.entity.Contacto;
import ar.edu.unju.fi.service.IContactoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	private IContactoService contactoservice;
	/*ahora hay q conectarlo con el servicio.
	@Autowired
	ListaContacto listaMensajes;
	*/
	/* copiado y pegado en ContactoServiceImp.java
	@Autowired
	Contacto contacto;
	*/
	/* reemplazar contacto por contactoService.getMensaje()*/
	@GetMapping("/listaMensaje")
	public String contacto(Model model) {
		model.addAttribute("contacto", contactoservice.getlistaMensajes());
		return "listaMensaje";
	}
	
	@PostMapping("/guardarMensaje")
    public String guardar(Model model ,@Valid @ModelAttribute("Contacto") Contacto contacto,BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("Contacto",  contacto);
            return "contacto";
        }
        
        System.out.println(contacto);
        contactoservice.getlistaMensajes().add(contacto); 
        model.addAttribute("listaMensajes" , contactoservice.getlistaMensajes());
    return "redirect:/contacto/listaMensaje";
    } 
	@GetMapping("/contacto")
	public String getContacto(Model model ) {
		model.addAttribute("Contacto", new Contacto());
		return "contacto";
	}
	@GetMapping("/eliminar_mensaje/{nombreMensaje}")
    public String eliminarMensaje(Model model, @PathVariable(value="nombreMensaje")String nombreMensaje) {
	for (Contacto contacto  : contactoservice.getlistaMensajes()) {
		if (contacto.getNombre().equals(nombreMensaje)) {
			contactoservice.borrarMensajes(contacto);/*contactoservice.getlistaMensajes().remove(contacto)*/
			break;
		}
	}
	return "redirect:/contacto/listaMensaje";
	}	
}	