package ar.edu.unju.fi.controller;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ProductosList;
import ar.edu.unju.fi.model.ConsejoSalud;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductosController {
	
	private ProductosList productos = new ProductosList();
	
	/**Este GetMapping utliza ModelAndView y usa un ArrayList de otra clase Java llamada ProductosList */
	@GetMapping("/productos")
	public ModelAndView mostrarProductos() {
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("/nuevo_producto")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		modelAndView.addObject("Producto", new Producto());
		boolean edicion=false;
		modelAndView.addObject("edicion", edicion);
		return modelAndView;
	}
	@PostMapping("/guardar_producto")
	public ModelAndView guardarConsejoSalud(@ModelAttribute("Producto") Producto producto) {
		producto.setCodigo(productos.getProductos().get(productos.getProductos().size()-1).getCodigo()+1);  
		productos.getProductos().add(producto);
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("/modificar_producto/{codigo}")
	public ModelAndView getModificarConsejo(@PathVariable(value="codigo")Integer codigo) {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		Producto productoEncontrado = new Producto();
		for(Producto p: productos.getProductos()) {
			if(p.getCodigo().equals(codigo)) {
				productoEncontrado = p;
				break;
			}
		}
		boolean edicion = true;
		modelAndView.addObject("edicion",edicion);
		
		modelAndView.addObject("Producto", productoEncontrado);
		System.out.println(productoEncontrado);
		
		return modelAndView;
	}
	
	@PostMapping("/modificar_producto")
	public ModelAndView modificarConsejoSalud(@ModelAttribute("Producto") Producto producto) {
		System.out.println(producto);
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		for(Producto p: productos.getProductos()) {
			if(p.getCodigo().equals(producto.getCodigo())) {
				p.setCategoria(producto.getCategoria());
				p.setDescuento(producto.getDescuento());
				p.setImagen(producto.getImagen());
				p.setNombre(producto.getNombre());
				p.setPrecio(producto.getPrecio());
				break;
			}
		}
		
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("eliminar_producto/{codigo}")
	public ModelAndView eliminarConsejoSalud(@PathVariable(value="codigo")Integer codigo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		for(Producto p: productos.getProductos()) {
			if(p.getCodigo().equals(codigo)) {
				productos.getProductos().remove(p);
				break;
			}
		}
		return modelAndView;
	}
	
	
	@GetMapping("/volver")
	public String volverConsejoSalud() {
		return "redirect:/producto/productos";
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
