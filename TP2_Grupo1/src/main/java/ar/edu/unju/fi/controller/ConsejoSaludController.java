package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.ConsejoSalud;
import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.service.IConsejoSaludService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo_salud")
public class ConsejoSaludController {
	
	
	@Autowired
	@Qualifier("ConsejoSaludServiceMysqlImp")
	IConsejoSaludService consejoSaludService;
	
	/**
	 * Método que maneja la petición para mostrar la lista de consejos de salud.
	 * Retorna un objeto ModelAndView que representa la vista "consejoSalud" con la lista de consejos.
	 * 
	 * @return Vista "consejoSalud" con la lista de consejos de salud.
	 */
	@GetMapping("/listado")
	public ModelAndView index() {
		ModelAndView modelAndView = new  ModelAndView("consejoSalud");
		modelAndView.addObject("listaConsejo", consejoSaludService.getListaConsejo());
	
		return modelAndView;
	}
	
	/**
	 * Método que maneja la petición para mostrar el formulario de creación de un nuevo consejo de salud.
	 * Retorna un objeto ModelAndView que representa la vista "nuevo_consejo" con los datos necesarios.
	 * 
	 * @return Vista "nuevo_consejo" con el objeto ConsejoSalud y la bandera de edición.
	 */
	@GetMapping("/nuevo_consejo")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		modelAndView.addObject("Consejo",consejoSaludService.getConsejoSalud());
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
		ModelAndView modelAndView = new ModelAndView("redirect:/consejo_salud/listado");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_consejo");
			modelAndView.addObject("Consejo",consejoSalud);
			boolean edicion=false;
			modelAndView.addObject("edicion", edicion);
			return modelAndView;
		}
		//consejoSalud.setId(consejoSaludService.getAsignarId());
		consejoSaludService.guardarConsejo(consejoSalud);
		
		modelAndView.addObject("listaConsejo", consejoSaludService.getListaConsejo());
		return modelAndView;
	}
	
	/**
	 * Método que maneja la petición para obtener la vista de modificación de un consejo de salud.
	 * Recibe como parámetro el ID del consejo a modificar.
	 * Carga los datos del consejo encontrado y los muestra en la vista "nuevo_consejo" en modo edición.
	 * 
	 * @param id El ID del consejo a modificar.
	 * @return ModelAndView con la vista "nuevo_consejo" y los datos del consejo a modificar.
	 */
	@GetMapping("/modificar_consejo/{id}")
	public ModelAndView getModificarConsejo(@PathVariable(value="id")Integer id) {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		ConsejoSalud consejoEncontrado = consejoSaludService.getBuscarConsejoSalud(id);
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
		ModelAndView modelAndView = new ModelAndView("redirect:/consejo_salud/listado");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_consejo");
			boolean edicion = true;
			modelAndView.addObject("edicion",edicion);
			modelAndView.addObject("Consejo", consejoSalud);
			
			return modelAndView;
		}
		consejoSaludService.modificarConsejo(consejoSalud);
		modelAndView.addObject("listaConsejo", consejoSaludService.getListaConsejo());
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
		ModelAndView modelAndView = new ModelAndView("redirect:/consejo_salud/listado");
		consejoSaludService.eliminarConsejo(consejoSaludService.getBuscarConsejoxTirulo(titulo));
		return modelAndView;
	}
	
	/**
	 * Método que maneja la petición para redirigir a la página de listado de consejos de salud.
	 * 
	 * @return Redirección a la página de listado de consejos de salud.
	 */
	@GetMapping("/volver")
	public String volverConsejoSalud() {
		return "redirect:/consejo_salud/listado";
	}
}
