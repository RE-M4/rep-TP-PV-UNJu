package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.listas.ListasSucursales;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sucursales")
public class SucursalesController {

	@Autowired
	private ListasSucursales listaSucursales;
	@Autowired
	private Sucursal sucursal;
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";

	}

	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "nueva_sucursal";
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultadoValidacion) {
		sucursal.setId(listaSucursales.getSucursales().get(listaSucursales.getSucursales().size() - 1).getId() + 1);
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		if (resultadoValidacion.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			modelView.addObject("sucursales", listaSucursales.getSucursales());
			return modelView;
		}
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		modelView.addObject("sucursal", new Sucursal());
		return modelView;
	}
@GetMapping("/modificar/{id}")
public ModelAndView getModificarSucursalPage(@PathVariable(value = "id") Integer id) {
	ModelAndView modelAndView = new ModelAndView("nueva_sucursal");
	Sucursal sucursalEncontrada = new Sucursal();
	for (Sucursal sucu : listaSucursales.getSucursales()) {
		if (sucu.getId().equals(id)) {
			sucursalEncontrada = sucu;
			break;
		}
	}
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
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(sucursal.getId())) {
				sucu.setNombre(sucursal.getNombre());
				sucu.setCalle(sucursal.getCalle());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setDiaApertura(sucursal.getDiaApertura());
				sucu.setDiaCierre(sucursal.getDiaCierre());
				// Validar rango de horaApertura
				if (sucursal.getHoraApertura() >= 0 && sucursal.getHoraApertura() <= 23) {
					sucu.setHoraApertura(sucursal.getHoraApertura());
				}

				// Validar rango de horaCierre
				if (sucursal.getHoraCierre() >= 0 && sucursal.getHoraCierre() <= 23) {
					sucu.setHoraCierre(sucursal.getHoraCierre());
				}

				sucu.setTelefono(sucursal.getTelefono());
				break;
			}
		}
		return "redirect:/sucursales/listado";
	}


		@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value = "id") Integer id) {
			for (Sucursal sucu : listaSucursales.getSucursales()) {
				if (sucu.getId().equals(id)) {
						listaSucursales.getSucursales().remove(sucu);
					break;
				}
			}
			return "redirect:/sucursales/listado";
	}

	@ModelAttribute("diasSemana")
	public String[] getDiasSemana() {
		return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	}

}