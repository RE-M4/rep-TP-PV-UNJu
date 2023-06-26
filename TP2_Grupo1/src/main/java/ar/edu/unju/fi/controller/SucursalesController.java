package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	@Autowired
	@Qualifier("sucursalServiceMysqlImp")
	private ISucursalService sucursalServiceImp;
	@Autowired
	private IProvinciaService provinciaService;
	/**
	 * Método que devuelve la vista de la lista de sucursales.
	 * @param model Modelo pasa los datos a la vista.
	 * @return Devuelve la vista de la lista de sucursales.
	 */
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalServiceImp.getListaSucursales());
		return "sucursales";

	}
	/**
	 * Muestra la vista de la página para agregar una nueva sucursal.
	 * @param model Modelo pasa los datos a la vista.
	 * @return Devuelve la vista de la página de nueva sucursal.
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", sucursalServiceImp.getSucursal());
		model.addAttribute("Provincias", provinciaService.getListaProvincias());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("sucursales", sucursalServiceImp.getListaSucursales());
		return "nueva_sucursal";
	}
	/**
	 * Método que guarda una nueva sucursal.
	 * @param sucursal Sucursal a guardar.
	 * @param resultadoValidacion Resultado de la validación de los datos ingresados.
	 * @return Devuelve la vista de la lista de sucursales.
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		if (resultadoValidacion.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			boolean edicion = false;
			modelView.addObject("edicion", edicion);
			modelView.addObject("Provincias", provinciaService.getListaProvincias());
			return modelView;
		}
//		sucursal.setId(sucursalService.getListaSucursales().get(sucursalService.getListaSucursales().size() - 1).getId() + 1);
		sucursalServiceImp.guardarSucursal(sucursal);
		modelView.addObject("sucursales", sucursalServiceImp.getListaSucursales());

		return modelView;
	}
	/**
	 * Método que muestra la vista de la página de modificación de sucursal.
	 * @param id Id de la sucursal a modificar.
	 * @return objeto ModelAndView con la vista y los datos asociados
	 */
	@GetMapping("/modificar/{id}")
	public ModelAndView getModificarSucursalPage(@PathVariable(value = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("nueva_sucursal");
		Sucursal sucursalEncontrada = sucursalServiceImp.getBuscarSucursal(id);
		boolean edicion = true;
		modelAndView.addObject("edicion", edicion);
		modelAndView.addObject("sucursal", sucursalEncontrada);
		modelAndView.addObject("Provincias", provinciaService.getListaProvincias());
		return modelAndView;

	}
	/**
	 * Método que modifica una sucursal existente.
	 * @param sucursal Sucursal a modificar.
	 * @param resultadoValidacion Resultado de la validación de los datos ingresados.
	 * @return nombre de la vista a redireccionar.
	 */
	@PostMapping("/modificar")
	public ModelAndView modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
		ModelAndView modelAndView = new ModelAndView("nueva_sucursal");
		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nueva_sucursal");
			modelAndView.addObject("sucursal", sucursal);
			modelAndView.addObject("Provincias", provinciaService.getListaProvincias());
			return modelAndView;
		}
		sucursalServiceImp.modificar(sucursal);
		modelAndView.addObject("sucursales", sucursalServiceImp.getListaSucursales());
		return modelAndView;
	}

	/**
	 * Método que elimina una sucursal existente.
	 * @param id Id de la sucursal a eliminar.
	 * @return nombre de la vista a redireccionar.
	 */
		@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value = "id") Long id) {
			Sucursal sucursal = sucursalServiceImp.getBuscarSucursal(id);
			sucursalServiceImp.eliminar(sucursal);
			return "redirect:/sucursales/listado";
	}
	/**
	 * Método que devuelve la vista de la lista de sucursales.
	 * @return Devuelve la vista de la lista de sucursales.
	 */
	@ModelAttribute("diasSemana")
	public String[] getDiasSemana() {
		return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	}

}