package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ProductosList;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductosController {
	
	@Autowired
	private ProductosList productos;
	
	@Autowired
	private Producto producto;
	
	/**
	 * Este metodo nos devuelve
	 * @return 
	 */
	@GetMapping("/productos")
	public ModelAndView mostrarProductos() {
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("/nuevo_producto")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		modelAndView.addObject("Producto", producto);
		boolean edicion=false;
		modelAndView.addObject("edicion", edicion);
		return modelAndView;
	}
	@PostMapping("/guardar_producto")
	public ModelAndView guardarConsejoSalud(@Valid @ModelAttribute("Producto") Producto producto ,BindingResult result ) {
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("Producto", producto);
			boolean edicion=false;
			modelAndView.addObject("edicion", edicion);
			return modelAndView;
		}
		producto.setCodigo(productos.getProductos().get(productos.getProductos().size()-1).getCodigo()+1);  
		productos.getProductos().add(producto);
		modelAndView.addObject("productos", productos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("/modificar_producto/{codigo}")
	public ModelAndView getModificarConsejo(@PathVariable(value="codigo")Integer codigo) {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		Producto productoEncontrado = producto;
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
	public ModelAndView modificarConsejoSalud(@Valid @ModelAttribute("Producto") Producto producto,BindingResult result) {
		System.out.println(producto);
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			boolean edicion = true;
			modelAndView.addObject("edicion",edicion);
			modelAndView.addObject("Producto", producto);
			
			return modelAndView;
		}
		
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

}
