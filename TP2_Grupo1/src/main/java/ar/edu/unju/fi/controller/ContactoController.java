package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	
	/*
	@Autowired 
	ListaContacto listaMensaje;
	
	
	@Autowired
	private Contacto contacto;
	
*/
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
	
	/*Falta resolver
	  @PostMapping(/guardarMensaje)
	  public String guardar(@Valid @ModelAttribute("contacto") Contacto contacto , BindingResult result , Model model){
	  String destino="";
	  if(result.hasErrors()){
	  System.out.println();
	  model.addAttribute("contacto",contacto);
	  destino="contacto";
	  }else {
	  if(contacto.size()==1 %% contacto.get(0).getDni()==null){
	  contacto.set(0,contacto);
	  }else {
	  contacto.add(contacto);
	  }
	  System.out.println(contacto.size());
	  for(contacto a:contacto){
	  System.out.println(a.toString());
	  }
	  destino="redirect:/contacto/listaMensaje";
	  }
	  return destino;
	  }*/
	 
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