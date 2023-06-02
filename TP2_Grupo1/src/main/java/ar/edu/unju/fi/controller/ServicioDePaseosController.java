package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ServiciosDePaseoLista;
import ar.edu.unju.fi.model.ServicioDePaseo;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/servicioDePaseos") /*Hace falta esta línea para no mezclar los GetMapping o PostMapping de otros Controllers*/
public class ServicioDePaseosController {
	/*Se crea un objeto tipo lista*/
	@Autowired
	private ServiciosDePaseoLista serviciosLista;
	/*Se crea una variable controladora para saber que función tendrá el formulario cuando se lo invoque*/
	Boolean edicion = false;
	/*GetMapping que usa el método "get" del objeto tipo lista y lo carga en el HTML*/
	@Autowired
	private ServicioDePaseo servicioDePaseo;
	@GetMapping("/listado")
	public String getServicioDePaseos(Model model) {
		model.addAttribute("servicios", serviciosLista.getServiciosDePaseo());
		return "servicioDePaseos";
	}
	@GetMapping("/modificarDatos/{nombrePaseador}")
	public String getModificarDatos(Model model, @PathVariable(value="nombrePaseador")String nombrePaseador) { /*PathVariable se obtiene de la línea 28 de servicioDePaseos.html*/
		edicion = true;
		System.out.println(edicion);
		ServicioDePaseo servicioEncontrado = servicioDePaseo;
		for(ServicioDePaseo servicio : serviciosLista.getServiciosDePaseo()) {/*Se busca un objeto dentro del Array tienendo en cuenta el nombre*/
			if(servicio.getPaseador().equals(nombrePaseador)) {
				servicioEncontrado = servicio;
				break;
			}
		}
		model.addAttribute("ServicioDePaseo", servicioEncontrado);/*El objeto encontrado se envía a modificar_servicios.html | La etiqueta sirve para identificar dentro de th:object*/
		model.addAttribute("edicion", edicion);
		return "modificar_servicios";
	}
	@PostMapping("/modificarDatos")
	public String modificarDatos(@Valid @ModelAttribute("ServicioDePaseo")ServicioDePaseo servicioModificado, BindingResult result, Model model) {/*ModelAttribute sirve para identificar un objeto a modificar | ServicioDePaseo (o sea, la etiqueta servicioModificado) es el th:object de modificar_servicios.html con sus atributos cambiados al momento de cambiar los inputs y pulsar "Guardar"*/
		System.out.println(edicion);
		if(result.hasErrors()) {
			model.addAttribute("ServicioDePaseo", servicioModificado);
			return "modificar_servicios";
		}
		for(ServicioDePaseo servicioOriginal : serviciosLista.getServiciosDePaseo()) {
			if(servicioOriginal.getPaseador().equals(servicioModificado.getPaseador())) {
				//servicioOriginal = servicioModificado /*Esta línea no modifica los datos de un objeto con otro objeto, solo crea 2 punteros al mismo objeto*/
				servicioOriginal.setPaseador(servicioModificado.getPaseador()); /*Al momento de querer cambiar este atributo, queda como está porque sirve como identificador, se debe usar un identificador único que no pueda ser modificado*/
				servicioOriginal.setDia(servicioModificado.getDia());
				servicioOriginal.setHorario(servicioModificado.getHorario());
			}
		}
		return "redirect:/servicioDePaseos/listado";
	}
	@GetMapping("/eliminarDatos/{nombrePaseador}")
	public String eliminarDatos(Model model, @PathVariable(value="nombrePaseador")String nombrePaseador){
		ServicioDePaseo servicioEncontrado = servicioDePaseo;
		for(ServicioDePaseo servicio : serviciosLista.getServiciosDePaseo()) {
			if(servicio.getPaseador().equals(nombrePaseador)) {
				servicioEncontrado = servicio;
				serviciosLista.getServiciosDePaseo().remove(servicioEncontrado);
				break;
			}
		}
		return "redirect:/servicioDePaseos/listado";
	}
	@GetMapping("/nuevoServicio")
	public String nuevaSucursal(Model model) {
		edicion = false;
		System.out.println(edicion);
		model.addAttribute("ServicioDePaseo", servicioDePaseo);//Se envia un nuevo objeto "ServicioDePaseo" que será el th:object de modificar_servicios.html.
		model.addAttribute("edicion", edicion);
		return "modificar_servicios";
	}
	@PostMapping("/guardarDato")
	public ModelAndView guardarNuevoDato(@Valid @ModelAttribute("ServicioDePaseo")ServicioDePaseo nuevoServicio, BindingResult result) {
		System.out.println(edicion);
		ModelAndView modelAndView = new ModelAndView("redirect:/servicioDePaseos/listado"); //Se crea un objeto ModelAndView, lo que está entre comillas es la página HTML a la que se va a redirigir.
		if(result.hasErrors()) {
			modelAndView.setViewName("modificar_servicios");
			modelAndView.addObject("ServicioDePaseo", nuevoServicio); //"ServicioDePaseo" tiene que coincidir con el th:object de modificar_servicios.html
			return modelAndView;
		}
		serviciosLista.getServiciosDePaseo().add(nuevoServicio);
		modelAndView.addObject("serviciosDePaseo", serviciosLista.getServiciosDePaseo());
		return modelAndView;
	}
}
