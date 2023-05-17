package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.model.ConsejoSalud;

@Controller
public class ConsejoSaludController {
	
	ListaConsejoSalud lista = new ListaConsejoSalud();

	@GetMapping("/consejoSalud")
	public ModelAndView index() {
		ModelAndView modelAndView = new  ModelAndView("consejoSalud");
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		
		return modelAndView;
	}
	
	@GetMapping("/nuevo_consejo")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_consejo");
		modelAndView.addObject("Consejo", new ConsejoSalud());
		return modelAndView;
	}
	
	@PostMapping("/guardar_consejo")
	public ModelAndView guardarConsejoSalud(@ModelAttribute("Consejo") ConsejoSalud consejoSalud) {
		lista.getListaConsejoSalud().add(consejoSalud);
		ModelAndView modelAndView = new ModelAndView("/consejoSalud");
		modelAndView.addObject("listaConsejo", lista.getListaConsejoSalud());
		return modelAndView;
	}
}
