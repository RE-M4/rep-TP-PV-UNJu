package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ServiciosDePaseoLista;
import ar.edu.unju.fi.model.ServicioDePaseo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/servicioDePaseos") /*Hace falta esta línea para no mezclar los GetMapping o PostMapping de otros Controllers*/
public class ServicioDePaseosController {
	/*Se crea un objeto tipo lista*/
	ServiciosDePaseoLista serviciosLista = new ServiciosDePaseoLista();
	/*Se crea una variable controladora para saber que función tendrá el formulario cuando se lo invoque*/
	Boolean edicion = false;
	/*GetMapping que usa el método "get" del objeto tipo lista y lo carga en el HTML*/
	@GetMapping("/listado")
	public String getServicioDePaseos(Model model) {
		model.addAttribute("servicios", serviciosLista.getServiciosDePaseo());
		return "servicioDePaseos";
	}
	@GetMapping("/modificarDatos/{nombrePaseador}")
	public String getModificarDatos(Model model, @PathVariable(value="nombrePaseador")String nombrePaseador) { /*PathVariable se obtiene de la línea 28 de servicioDePaseos.html*/
		ServicioDePaseo servicioEncontrado = new ServicioDePaseo();
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
	public String modificarDatos(@ModelAttribute("ServicioDePaseo")ServicioDePaseo servicioModificado) {/*ModelAttribute sirve para identificar un objeto a modificar | ServicioDePaseo (o sea, la etiqueta servicioModificado) es el th:object de modificar_servicios.html con sus atributos cambiados al momento de cambiar los inputs y pulsar "Guardar"*/
		edicion = true;
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
		ServicioDePaseo servicioEncontrado = new ServicioDePaseo();
		for(ServicioDePaseo servicio : serviciosLista.getServiciosDePaseo()) {
			if(servicio.getPaseador().equals(nombrePaseador)) {
				servicioEncontrado = servicio;
				servicioEncontrado.setPaseador("");
				servicioEncontrado.setDia("");
				servicioEncontrado.setHorario("");
				break;
			}
		}
		return "redirect:/servicioDePaseos/listado";
	}
	@GetMapping("/nuevoServicio")
	public String nuevaSucursal(Model model) {
		model.addAttribute("ServicioDePaseo", new ServicioDePaseo());//Se envia un nuevo objeto "ServicioDePaseo" que será el th:object de modificar_servicios.html.
		model.addAttribute("edicion", edicion);
		return "modificar_servicios";
	}
	@PostMapping("/guardarDato")
	public String guardarNuevoDato(@ModelAttribute("ServicioDePaseo")ServicioDePaseo nuevoServicio) {
		//ModelAndView modelAndView = new ModelAndView("servicioDePaseos"); Se crea un objeto ModelAndView, lo que está entre comillas es la página HTML a la que se va a redirigir.
		serviciosLista.getServiciosDePaseo().add(nuevoServicio);
		//modelAndView.addObject("servicioDePaseos", serviciosLista.getServiciosDePaseo());
		return "redirect:/servicioDePaseos/listado";
	}
}
