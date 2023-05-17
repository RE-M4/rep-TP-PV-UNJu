package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ProductosList {
	private List<Producto> productos;
	
	public ProductosList() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("OLYMPIC PERRO ADULTO 19KG","Alimento canino",0001,50,5750.00));
		productos.add(new Producto("COMPLETE PERRO CACHORRO RAZA PEQUEÑA 20 KG","Alimento canino cachorro",0002,25,10837.00));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
