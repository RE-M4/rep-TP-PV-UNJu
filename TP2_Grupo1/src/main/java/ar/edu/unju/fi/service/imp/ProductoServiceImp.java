package ar.edu.unju.fi.service.imp;


import ar.edu.unju.fi.listas.ProductosList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.entity.Producto;
import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ProductosList listaProductos;
	@Autowired
	private Producto producto;

	@Override
	public Producto getProducto() {
		return producto;
	}
	@Override
	public List<Producto> getListaProductos() {

		return listaProductos.getProductos();
	}
	@Override
	public void guardarProducto(Producto producto) {
		listaProductos.getProductos().add(producto);
	}
	@Override
	public Producto getBuscarProducto(int codigo) {
		Producto productoEncontrado = null;
		for(Producto p: listaProductos.getProductos()) {
			if(p.getCodigo().equals(codigo)) {
				productoEncontrado = p;
				break;
			}
		}
		return productoEncontrado;
	}

	@Override
	public void modificarProducto(Producto producto) {
		for (Producto producto2 : listaProductos.getProductos()) {
			if (producto2.getCodigo().equals(producto.getCodigo())) {
				producto2.setCategoria(producto.getCategoria());
				producto2.setDescuento(producto.getDescuento());
				producto2.setImagen(producto.getImagen());
				producto2.setNombre(producto.getNombre());
				producto2.setPrecio(producto.getPrecio());
			break;
			}
		}
	}

	@Override
	public void eliminarProducto(Producto producto) {
		listaProductos.getProductos().remove(producto);
	}


}
