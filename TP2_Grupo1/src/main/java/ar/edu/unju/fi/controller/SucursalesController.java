package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SucursalesController {

	@GetMapping("/sucursales")
	public String index(Model model) {
		return "sucursales";
	}
}