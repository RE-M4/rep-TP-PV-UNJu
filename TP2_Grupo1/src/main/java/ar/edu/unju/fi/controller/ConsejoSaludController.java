package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.model.ConsejoSalud;

@Controller

public class ConsejoSaludController {
	
	ListaConsejoSalud lista = new ListaConsejoSalud();
	
	/**
	 * Este metodo envia la lista de consejos usando como peticion /consejoSalud
	 * @return
	 */
	@GetMapping("/consejoSalud")
	public ModelAndView index() {
		ModelAndView modelAndView = new  ModelAndView("consejoSalud");
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		
		return modelAndView;
	}
	
	/**
	 * este metdo linkea al template nuevo_consejo y lleva como parametro un objeto de tipo ConsejoSalud y una bandera edicion
	 * @return
	 */
	@GetMapping("/nuevo_consejo")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		modelAndView.addObject("Consejo", new ConsejoSalud());
		boolean edicion=false;
		modelAndView.addObject("edicion", edicion);
		return modelAndView;
	}
	/**
	 * el metodo guarda un objeto en la lita q es enviado desde la vista por medio de la peticion /guardar_consejo
	 * @param consejoSalud
	 * @return
	 */
	@PostMapping("/guardar_consejo")
	public ModelAndView guardarConsejoSalud(@ModelAttribute("Consejo") ConsejoSalud consejoSalud) {
		lista.getListaConsejoSalud().add(consejoSalud);
		ModelAndView modelAndView = new ModelAndView("redirect:/consejoSalud");
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		return modelAndView;
	}
	
	/**
	 * 
	 * @param titulo
	 * @return
	 */
	@GetMapping("/modificar_consejo/{titulo}")
	public ModelAndView getModificarConsejo(@PathVariable(value="titulo")String titulo) {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		ConsejoSalud consejoEncontrado = new ConsejoSalud();
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getTitulo().equals(titulo)) {
				consejoEncontrado = consejo;
				break;
			}
		}
		boolean edicion = true;
		modelAndView.addObject("edicion",edicion);
		modelAndView.addObject("Consejo", consejoEncontrado);
		
		return modelAndView;
	}
	
	/**
	 * esta peticion modifica un objeto de la lista 
	 * @param consejoSalud
	 * @return
	 */
	@PostMapping("/modificar_consejo")
	public ModelAndView modificarConsejoSalud(@ModelAttribute("Consejo") ConsejoSalud consejoSalud) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/consejoSalud");
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getTitulo().equals(consejoSalud.getTitulo())) {
				consejo.setTitulo(consejoSalud.getTitulo());
				consejo.setImg(consejoSalud.getImg());
				consejo.setDescripcion(consejoSalud.getDescripcion());
				break;
			}
		}
		
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		return modelAndView;
	}
	
	/**
	 * este metodo recibe como parametro un titulo que es enviado por la peticion eliminar_consejo
	 * compara el titulo con cada uno de los objetos q se encuentra en la lita.
	 * si hay concidencia procede a eliminar dicho abojeto
	 * @param titulo
	 * @return
	 */
	@GetMapping("eliminar_consejo/{titulo}")
	public ModelAndView eliminarConsejoSalud(@PathVariable(value="titulo")String titulo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/consejoSalud");
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getTitulo().equals(titulo)) {
				lista.getListaConsejoSalud().remove(consejo);
				break;
			}
		}
		return modelAndView;
	}
	
	/**
	 * Este metodo redirique al template consejoSalud.html
	 * @return
	 */
	@GetMapping("/volver")
	public String volverConsejoSalud() {
		return "redirect:/consejoSalud";
	}
}
