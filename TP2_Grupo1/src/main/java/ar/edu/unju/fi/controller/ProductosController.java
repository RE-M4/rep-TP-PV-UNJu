package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductosController {
	
	@Autowired
	@Qualifier("ProductoServiceMysqlImp")
	private IProductoService serviceProductos;

	/**
	 * Este metodo nos devuelve
	 * @return 
	 */
	@GetMapping("/productos")
	public ModelAndView mostrarProductos() {
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", serviceProductos.getListaProductos());
		System.out.println(serviceProductos.getProducto());
		return modelAndView;
	}
	
	@GetMapping("/nuevo_producto")
	public ModelAndView getNuevoConsejo() {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		modelAndView.addObject("Producto", serviceProductos.getProducto());
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
		//producto.setCodigo(serviceProductos.getListaProductos().get(serviceProductos.getListaProductos().size()-1).getCodigo()+1);//seteo el codigo id del producto
		serviceProductos.guardarProducto(producto);
		modelAndView.addObject("productos", serviceProductos.getListaProductos());
		return modelAndView;
	}
	
	@GetMapping("/modificar_producto/{codigo}")
	public ModelAndView getModificarConsejo(@PathVariable(value="codigo")Long codigo) {
		ModelAndView modelAndView = new ModelAndView("nuevo_producto");
		Producto productoEncontrado = serviceProductos.getBuscarProducto(codigo);
		boolean edicion = true;
		modelAndView.addObject("edicion",edicion);
		modelAndView.addObject("Producto", productoEncontrado);
		return modelAndView;
	}

	@PostMapping("/modificar_producto")
	public ModelAndView modificarConsejoSalud(@Valid @ModelAttribute("Producto") Producto producto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("Producto", producto);
			return modelAndView;
		}
		serviceProductos.modificarProducto(producto);
		modelAndView.addObject("productos", serviceProductos.getListaProductos());
		System.out.println(producto.getCodigo());
		return modelAndView;
	}

	@GetMapping("eliminar_producto/{codigo}")
	public ModelAndView eliminarConsejoSalud(@PathVariable(value="codigo")Integer codigo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/producto/productos");
		serviceProductos.eliminarProducto(serviceProductos.getBuscarProducto(codigo));
		return modelAndView;
	}


	@GetMapping("/volver")
	public String volverConsejoSalud() {
		return "redirect:/producto/productos";
	}

}
