package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
	@Qualifier("sucursalServiceImp")
	private ISucursalService sucursalServiceImp;

	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalServiceImp.getListaSucursales());
		return "sucursales";

	}

	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", sucursalServiceImp.getSucursal());
		model.addAttribute("edicion", edicion);
		model.addAttribute("sucursales", sucursalServiceImp.getListaSucursales());
		return "nueva_sucursal";
	}

//	@PostMapping("/guardar")
//	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
//		ModelAndView modelView = new ModelAndView("nueva_sucursal");
//		if (resultadoValidacion.hasErrors()) {
//			modelView.addObject("sucursal", sucursal);
//			modelView.addObject("edicion", false);
//			modelView.addObject("sucursales", sucursalServiceImp.getListaSucursales());
//			return modelView;
//		}
////		sucursal.setId(sucursalService.getListaSucursales().get(sucursalService.getListaSucursales().size() - 1).getId() + 1);
//		sucursalServiceImp.guardarSucursal(sucursal);
//		modelView.addObject("sucursales", sucursalServiceImp.getListaSucursales());
//		modelView.addObject("sucursal", new Sucursal());
//		return modelView;
//	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		if (resultadoValidacion.hasErrors()) {
			modelView.addObject("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
//		sucursal.setId(sucursalService.getListaSucursales().get(sucursalService.getListaSucursales().size() - 1).getId() + 1);
		sucursalServiceImp.guardarSucursal(sucursal);
		modelView.addObject("sucursales", sucursalServiceImp.getListaSucursales());

		return modelView;
	}
@GetMapping("/modificar/{id}")
public ModelAndView getModificarSucursalPage(@PathVariable(value = "id") Long id) {
	ModelAndView modelAndView = new ModelAndView("nueva_sucursal");
	Sucursal sucursalEncontrada = sucursalServiceImp.getBuscarSucursal(id);
	boolean edicion = true;
	modelAndView.addObject("edicion", edicion);
	modelAndView.addObject("sucursal", sucursalEncontrada);
	return modelAndView;

}

	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
		if (resultadoValidacion.hasErrors()) {
			return "nueva_sucursal";
		}
		sucursalServiceImp.modificar(sucursal);
		return "redirect:/sucursales/listado";
	}


		@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value = "id") Long id) {
			Sucursal sucursal = sucursalServiceImp.getBuscarSucursal(id);
			sucursalServiceImp.eliminar(sucursal);
			return "redirect:/sucursales/listado";
	}

	@ModelAttribute("diasSemana")
	public String[] getDiasSemana() {
		return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	}

}