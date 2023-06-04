package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaContacto;

import ar.edu.unju.fi.controller.ContactoController;

import ar.edu.unju.fi.model.Contacto;
import ar.edu.unju.fi.model.Sucursal;

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
	public String guardar(Model model , @ModelAttribute("Contacto") Contacto contacto) {
		System.out.println(contacto);
		listaMensajes.getListaMensaje().add(contacto); 
		model.addAttribute("listaMensajes" , listaMensajes.getListaMensaje());
    return "redirect:/contacto/listaMensaje";
	}
	/* 
	 * @PostMapping(/guardarMensaje)
	 * public ModelAndView postPageSaveMensaje(@Valid @ModelAttribute("Contacto")
	 * Nuevo nuevo, BindingResult result){
	 * ModelAndView mav;
	 * if(result.hasErrors()){
	 * mav= new ModelAndView("contacto");
	 * 
	 * }else {
	 * if(nuevo.getnombre() != NULL && )
	 * listaMensaje.addNuevo(nuevo);
	 * mav=new ModelAndView("listaMensaje");
	 * mav.addObject("mensajes",listaMensaje,getListaMensaje());
	 * }
	 * return mav;
	 * }
	 * 
	 * 
	 * */
	
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