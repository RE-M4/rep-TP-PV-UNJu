package ar.edu.unju.fi.controller;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ProductosList;

@Controller
public class ProductosController {
	
	private ProductosList productos = new ProductosList();
	
	/**Este GetMapping utliza ModelAndView y usa un ArrayList de otra clase Java llamada ProductosList */
	@GetMapping("/productos")
	public ModelAndView mostrarProductos() {
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	/**Este GetMapping utiliza Model y crea el ArrayList y precarga datos dentro del controlador ProductosController */
	/*@GetMapping("/productos")
	public String mostrarProductos(Model model) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("OLYMPIC PERRO ADULTO 19KG","Alimento canino adulto",0001,50,5750.00));
		productos.add(new Producto("COMPLETE PERRO CACHORRO RAZA PEQUEÑA 20 KG","Alimento canino cachorro",0002,25,10837.00));
		model.addAttribute("productos", productos);
		return "productos";
	}*/
}
