package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.listas.ListasSucursales;
import ar.edu.unju.fi.model.Sucursal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	ListasSucursales listaSucursales = new ListasSucursales();

//	@GetMapping("")
//	public String sucursalesPage(Model model){
//		if (listaSucursales == null) {
//			listaSucursales = new ListasSucursales();
//		}
//		return "sucursales";
//	}
//	public ListasSucursales getListaSucursales() {
//		return listaSucursales;
//	}

	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";

	}

	@GetMapping("/nueva_sucursal")
	public String getNuevaSucursalListaPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "nueva_sucursal";
	}

	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal") Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		modelView.addObject("sucursal", new Sucursal());
		return modelView;
	}

	@GetMapping("/modificar/{nombre}")
	public ModelAndView getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre) {
		Sucursal sucursalEncontrada = new Sucursal();
		boolean edicion = true;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return modelView;
	}

	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setCalle(sucursal.getCalle());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setDiaApertura(sucursal.getDiaApertura());
				sucu.setDiaCierre(sucursal.getDiaCierre());
				sucu.setHoraApertura(sucursal.getHoraApertura());
				sucu.setHoraCierre(sucursal.getHoraCierre());
				sucu.setTelefono(sucursal.getTelefono());
				break;
			}
		}
		return "redirect:/sucursales/listado";
	}


		@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value = "nombre") String nombre) {
			for (Sucursal sucu : listaSucursales.getSucursales()) {
				if (sucu.getNombre().equals(nombre)) {
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