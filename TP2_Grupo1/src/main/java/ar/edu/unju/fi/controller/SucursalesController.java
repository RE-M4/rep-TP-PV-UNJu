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

	@GetMapping("")
	public String sucursalesPage(Model model){
		return "sucursales";
	}
	public ListasSucursales getListaSucursales() {
		return listaSucursales;
	}

	@GetMapping("/listado")
	public String getListaSucursalesPageTabla(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "nueva_sucursal";
	}
	@GetMapping("/visualizar")
	public String getvisualizarSucursales(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		//boolean edicion = false;
		model.addAttribute("sucursal", new Sucursal());
		//model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal") Sucursal sucursales) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursales);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}

	//	@GetMapping("/{nombre}/eliminar")
//	public ModelAndView eliminarSucursal(@PathVariable(value = "nombre") String nombre) {
//		Sucursal sucursal = buscarSucursalPorNombre(nombre);
//		if (sucursal != null) {
//			listaSucursales.getSucursales().remove(sucursal);
//		}
//		return new ModelAndView("redirect:/sucursales");
//	}
//
//	@GetMapping("/{nombre}/editar")
//	public String getEditarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre) {
//		Sucursal sucursal = buscarSucursalPorNombre(nombre);
//		model.addAttribute("sucursal", sucursal);
//		return "nueva_sucursal";
//	}
//
//	@PostMapping("/editar")
//	public ModelAndView editarSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
//		Sucursal sucursalExistente = buscarSucursalPorNombre(sucursal.getNombre());
//		if (sucursalExistente != null) {
//			sucursalExistente.setCalle(sucursal.getCalle());
//			sucursalExistente.setProvincia(sucursal.getProvincia());
//			sucursalExistente.setDiaApertura(sucursal.getDiaApertura());
//			sucursalExistente.setDiaCierre(sucursal.getDiaCierre());
//			sucursalExistente.setHoraApertura(sucursal.getHoraApertura());
//			sucursalExistente.setHoraCierre(sucursal.getHoraCierre());
//			sucursalExistente.setHorariosEspeciales(sucursal.isHorariosEspeciales());
//			sucursalExistente.setHoraAperturaEspecial(sucursal.getHoraAperturaEspecial());
//			sucursalExistente.setHoraCierreEspecial(sucursal.getHoraCierreEspecial());
//			sucursalExistente.setTelefono(sucursal.getTelefono());
//		}
//		return new ModelAndView("redirect:/sucursales");
//	}
//	private Sucursal buscarSucursalPorNombre(String nombre) {
//		for (Sucursal sucursal : listaSucursales.getSucursales()) {
//			if (sucursal.getNombre().equals(nombre)) {
//				return sucursal;
//			}
//		}
//		return null;
//	}

	@ModelAttribute("diasSemana")
	public String[] getDiasSemana() {
		return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	}

}