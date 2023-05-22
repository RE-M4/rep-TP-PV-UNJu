package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NuevoProductoController {
	
	@GetMapping("/nuevo_producto")
	public String nuevoProducto(Model model) {
		return "nuevo_producto";
	}
}
