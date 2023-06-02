package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.model.ConsejoSalud;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ConsejoSalud")
public class ConsejoSaludController {
	
	
	@Autowired
	private ListaConsejoSalud lista;
	
	@Autowired
	private ConsejoSalud consejoSalud;
	
	/**
	 * Este metodo envia la lista de consejos usando como peticion /consejoSalud
	 * @return
	 */
	@GetMapping("/listado")
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
		modelAndView.addObject("Consejo",consejoSalud);
		boolean edicion=false;
		modelAndView.addObject("edicion", edicion);
		return modelAndView;
	}
	/**
	 * el metodo guarda un objeto en la lita q es enviado desde la vista por medio de la peticion /guardar_consejo
	 * @param consejoSalud parametro que se gurda en la lista
	 * @param result parametro para consultar si esque hubo errores o no hubo errores
	 * @return
	 */
	@PostMapping("/guardar_consejo")
	public ModelAndView guardarConsejoSalud(@Valid @ModelAttribute("Consejo") ConsejoSalud consejoSalud, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ConsejoSalud/listado");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_consejo");
			modelAndView.addObject("Consejo",consejoSalud);
			boolean edicion=false;
			modelAndView.addObject("edicion", edicion);
			return modelAndView;
		}
		consejoSalud.setId(lista.getListaConsejoSalud().get(lista.getListaConsejoSalud().size()-1).getId()+1);
		lista.getListaConsejoSalud().add(consejoSalud);
		
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		return modelAndView;
	}
	
	/**
	 * 
	 * @param titulo
	 * @return
	 */
	@GetMapping("/modificar_consejo/{id}")
	public ModelAndView getModificarConsejo(@PathVariable(value="id")Integer id) {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		ConsejoSalud consejoEncontrado = consejoSalud;
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getId().equals(id)) {
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
	public ModelAndView modificarConsejoSalud(@Valid @ModelAttribute("Consejo") ConsejoSalud consejoSalud,BindingResult result) {
		System.out.println(consejoSalud);
		ModelAndView modelAndView = new ModelAndView("redirect:/ConsejoSalud/listado");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_consejo");
			boolean edicion = true;
			modelAndView.addObject("edicion",edicion);
			modelAndView.addObject("Consejo", consejoSalud);
			
			return modelAndView;
		}
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getId().equals(consejoSalud.getId())) {
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
		ModelAndView modelAndView = new ModelAndView("redirect:/ConsejoSalud/listado");
		for(ConsejoSalud consejo: lista.getListaConsejoSalud()) {
			if(consejo.getTitulo().equals(titulo)) {
				lista.getListaConsejoSalud().remove(consejo);
				break;
			}
		}
		return modelAndView;
	}
	
	/**
	 * Este metodo redirige al template consejoSalud.html
	 * @return
	 */
	@GetMapping("/volver")
	public String volverConsejoSalud() {
		return "redirect:/ConsejoSalud/listado";
	}
}
