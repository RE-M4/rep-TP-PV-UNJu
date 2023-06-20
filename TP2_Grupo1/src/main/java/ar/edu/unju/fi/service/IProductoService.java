package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Producto;

import java.util.List;

public interface IProductoService {

	Producto getProducto();
	public List<Producto> getListaProductos();

	public Producto getBuscarProducto(int codigo);
	public void guardarProducto(Producto producto);
	public void modificarProducto(Producto producto);

	public void eliminarProducto(Producto producto);


}
