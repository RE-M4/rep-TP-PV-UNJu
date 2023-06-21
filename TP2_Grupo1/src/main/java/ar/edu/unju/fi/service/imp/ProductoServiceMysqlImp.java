package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("ProductoServiceMysqlImp")
public class ProductoServiceMysqlImp implements IProductoService {

	@Autowired
	private IProductoRepository productoRespository;

	@Autowired
	private Producto producto;
	
	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return producto;
	}

	@Override
	public List<Producto> getListaProductos() {
		// TODO Auto-generated method stub
		return productoRespository.findByEstado(true);
	}

	@Override
	public Producto getBuscarProducto(long codigo) {
		// TODO Auto-generated method stub
		return productoRespository.findByCodigo(codigo);
	}

	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRespository.save(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRespository.save(producto);
	}

	@Override
	public void eliminarProducto(Producto producto) {
		// TODO Auto-generated method stub
		producto.setEstado(false);
		productoRespository.save(producto);
	}

}
