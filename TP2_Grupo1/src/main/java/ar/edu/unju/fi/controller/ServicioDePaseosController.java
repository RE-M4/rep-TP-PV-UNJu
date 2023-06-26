package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ServiciosDePaseoLista;
import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.service.IServicioDePaseosService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*Se agrega esta etiqueta para indicar a la clase que trabaje como un controlador*/
@Controller
/*Hace falta esta línea para no mezclar los GetMapping o PostMapping de otros Controllers*/
@RequestMapping("/servicioDePaseos") //Hace referencia a servicioDePaseos.html
public class ServicioDePaseosController {
	
	/*Se inyecta un objeto tipo lista (AL USAR CAPA SERVICE, ESTA LINEA YA NO ES VÁLIDA)
	@Autowired
	private ServiciosDePaseoLista serviciosLista;*/
	
	/*Se crea una variable booleana para saber que función tendrá el formulario de modificar_servicios.html cuando se lo invoque (por defecto (false), esta variable hace que el formulario guarde un nuevo objeto) (línea 21)*/
	Boolean edicion = false;
	
	/*Se inyecta un objeto tipo ServicioDePaseo (AL USAR CAPA SERVICE, ESTA LINEA YA NO ES VÁLIDA)
	@Autowired
	private ServicioDePaseo servicioDePaseo;*/
	
	/*Al implementar la capa repository, se usa "Qualifier" para apuntar al servicio que contiene métodos
	 * de BD*/
	/*Se inyecta el servicio para reemplazar la inyección del Objeto y de la Lista*/
	/*Se debe agregar la etiqueta "Qualifier" para que el controller sepa cual de las 2 implementaciones
	 * debe usar*/
	@Autowired
	@Qualifier("servicioDePaseoServiceImpMysql")
	/*@Qualifier("servicioDePaseoServiceImp")*/
	private IServicioDePaseosService paseosService;
	
	/**
	 * GetMapping que carga una lista en servicioDePaseos.html (utilizado en navigation.html).
	 * @param model
	 * @return Array de objetos de ServiciosDePaseoLista.java
	 */
	@GetMapping("/listado")
	public String getServicioDePaseos(Model model) {
		model.addAttribute("servicios", paseosService.getListaServicios()); //La etiqueta "servicios" sirve para identificar y usar al objeto dentro de la tabla de servicioDePaseos.html
		return "servicioDePaseos"; //Vuelve a la misma página
	}
	
	/**
	 * GetMapping que redirige a modificar_servicios.html llevando un dato de servicioDePaseos.html 
	 * (servicio.paseador) utilizando @PathVariable (utilizado en servicioDePaseos.html).
	 * @param model
	 * @param nombrePaseador
	 * @return Un objeto de ServicioDePaseoLista.java
	 */
	@GetMapping("/modificarDatos/{id}")
	public String getModificarDatos(Model model, @PathVariable(value="id")Long id) { //PathVariable se obtiene de la línea 44 de servicioDePaseos.html
		System.out.println("Nombre: " + paseosService.getBy(id).getPaseador());
		System.out.println("ID: " + paseosService.getBy(id).getId());
		System.out.println("Nombre: " + paseosService.getBy(id).isEstado());
		edicion = true; //Se cambia el valor a true.
		
		//ESTE CÓDIGO SE DEBE INSERTAR EN LA CAPA SERVICE
		/*ServicioDePaseo servicioEncontrado = paseosService.getServicio();
		for(ServicioDePaseo servicio : paseosService.getListaServicios()) {
			if(servicio.getPaseador().equals(nombrePaseador)) {
				servicioEncontrado = servicio;
				break;
			}
		}*/
		
		model.addAttribute("ServicioDePaseo", paseosService.getBy(id)); //El objeto encontrado se envía al formulario de modificar_servicios.html | La etiqueta "ServicioDePaseo" sirve para identificar y usar al objeto dentro del th:object del formulario de modificar_servicios.html
		model.addAttribute("edicion", edicion); //La variable se envía al formulario de modificar_servicios.html para modificar su funcionalidad
		return "modificar_servicios";
	}
	
	/**
	 * PostMapping que usa los datos guardados del th:object de modificar_servicios.html para, usando la 
	 * funcionalidad de la capa service, cambiar los valores de un objeto ya existente (activado por el
	 * botón "Guardar" de modificar_servicios.html).
	 * Utiliza el concepto de validación con @Valid y BindingResult result.
	 * Vuelve a la página "/listado" con los datos cambiados.
	 * @param servicioModificado
	 * @param result
	 * @param model
	 * @return Array de objetos de ServiciosDePaseoLista.java
	 */
	@PostMapping("/modificarDatos") //Esta funcionalidad se implementa dentro del formulario de modificar_servicios.html (línea 21)
	public String modificarDatos(@Valid @ModelAttribute("ServicioDePaseo")ServicioDePaseo servicioModificado, BindingResult result, Model model) {//ModelAttribute sirve para identificar el objeto traido de modificar_servicios.html | ServicioDePaseo (o su etiqueta servicioModificado) es el th:object recuperado del formulario de modificar_servicios.html con sus atributos cambiados al momento de cambiar los inputs y pulsar "Guardar"
		System.out.println("--------------------");
		System.out.println(servicioModificado.getId());
		System.out.println("--------------------");
		if(result.hasErrors()) { //Validación que vuelve a modificar_servicios.html mostrando los mensajes de error 
			edicion = true; //Se debe volver a instanciar la variable para que el formulario siga con la funcionalidad de modificar
			model.addAttribute("ServicioDePaseo", servicioModificado); //El objeto que llega como parámetro se envía al formulario de modificar_servicios.html | La etiqueta "ServicioDePaseo" sirve para identificar y usar al objeto dentro del th:object del formulario de modificar_servicios.html
			model.addAttribute("edicion", edicion); //Se envía la variable para cambiar la funcionalidad del formulario de modificar_servicios.html
			return "modificar_servicios";
		}
		
		//ESTE CÓDIGO SE DEBE INSERTAR EN LA CAPA SERVICE
		/*for(ServicioDePaseo servicioOriginal : paseosService.getListaServicios()) {
			if(servicioOriginal.getPaseador().equals(servicioModificado.getPaseador())) {
				//servicioOriginal = servicioModificado
				servicioOriginal.setPaseador(servicioModificado.getPaseador());
				servicioOriginal.setDia(servicioModificado.getDia());
				servicioOriginal.setHorario(servicioModificado.getHorario());
				break;
			}
		}*/
		
		paseosService.modificarServicio(servicioModificado);
		return "redirect:/servicioDePaseos/listado";
	}
	
	/**
	 * GetMapping que elimina un objeto del Array de objetos y redirige a "/listado" 
	 * (utilizado en servicioDePaseos.html).
	 * @param model
	 * @param nombrePaseador
	 * @return Array de objetos de ServiciosDePaseoLista.java
	 */
	@GetMapping("/eliminarDatos/{id}")
	public String eliminarDatos(Model model, @PathVariable(value="id")Long id){ //PathVariable se obtiene de la línea 45 de servicioDePaseos.html
		
		//ESTE CÓDIGO SE DEBE INSERTAR EN LA CAPA SERVICE
		/*ServicioDePaseo servicioEncontrado = paseosService.getServicio();
		for(ServicioDePaseo servicio : paseosService.getListaServicios()) {
			if(servicio.getPaseador().equals(nombrePaseador)) {
				servicioEncontrado = servicio;
				paseosService.getListaServicios().remove(servicioEncontrado);
				break;
			}
		}*/
		
		paseosService.borrarServicio(paseosService.getBy(id));
		return "redirect:/servicioDePaseos/listado";
	}
	
	/**
	 * GetMapping que redirige a modificar_servicios.html con un objeto ServicioDePaseos limpio para ser
	 * llenado utilizando el formulario (utilizado en servicioDePaseos.html).
	 * @param model
	 * @return Un objeto vacío tipo ServicioDePaseo.java
	 */
	@GetMapping("/nuevoServicio")
	public String nuevaSucursal(Model model) {
		edicion = false; //Se cambia el valor a false
		model.addAttribute("ServicioDePaseo", paseosService.getServicio()); //El objeto nuevo se envía al formulario de modificar_servicios.html | La etiqueta "ServicioDePaseo" sirve para identificar y usar al objeto dentro del th:object del formulario de modificar_servicios.html
		model.addAttribute("edicion", edicion); //Se envía la variable para cambiar la funcionalidad del formulario de modificar_servicios.html
		return "modificar_servicios";
	}
	
	/**
	 * PostMapping que usa los datos guardados del th:object de modificar_servicios.html para, usando la
	 * funcionalidad de la capa service, guarda un nuevo objeto dentro del Array de objetos (activado por el
	 * botón "Guardar" de modificar_servicios.html).
	 * Utiliza el concepto de validación con @Valid y BindingResult result.
	 * Vuelve a la página "/listado" con el Array con el nuevo objeto.
	 * @param nuevoServicio
	 * @param result
	 * @return Array de objetos de ServiciosDePaseoLista.java
	 */
	@PostMapping("/guardarDato") //Esta funcionalidad se implementa dentro del formulario de modificar_servicios.html (línea 21)
	public ModelAndView guardarNuevoDato(@Valid @ModelAttribute("ServicioDePaseo")ServicioDePaseo nuevoServicio, BindingResult result) { //ModelAttribute sirve para identificar el objeto traido de modificar_servicios.html | ServicioDePaseo (o su etiqueta servicioModificado) es el th:object recuperado del formulario de modificar_servicios.html con sus atributos nuevos al momento de cambiar los inputs y pulsar "Guardar"
		ModelAndView modelAndView = new ModelAndView("redirect:/servicioDePaseos/listado"); //Se crea un objeto ModelAndView, lo que está entre comillas es la página HTML a la que se va a redirigir.
		if(result.hasErrors()) { //Validación que vuelve a modificar_servicios.html mostrando los mensajes de error
			modelAndView.setViewName("modificar_servicios");
			modelAndView.addObject("ServicioDePaseo", nuevoServicio); //El objeto que llega como parámetro se envía al formulario de modificar_servicios.html | La etiqueta "ServicioDePaseo" sirve para identificar y usar al objeto dentro del th:object del formulario de modificar_servicios.html
			return modelAndView;
		}
		paseosService.guardarServicio(nuevoServicio);
		modelAndView.addObject("serviciosDePaseo", paseosService.getListaServicios());
		return modelAndView;
	}
}
