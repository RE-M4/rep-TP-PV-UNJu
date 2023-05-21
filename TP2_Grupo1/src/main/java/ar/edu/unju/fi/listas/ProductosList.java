package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ProductosList {
	private List<Producto> productos;
	
	public ProductosList() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("OLYMPIC PERRO ADULTO 19KG","Alimento canino",50,5750.00,"../images/producto1.jpg",1));
		productos.add(new Producto("COMPLETE PERRO CACHORRO RAZA PEQUEÑA 20 KG","Alimento canino cachorro",25,10837.00,"../images/producto2.jpg",2));
		productos.add(new Producto("OLYMPIC PERRO ADULTO 19KG","Alimento canino",0,5750.00,"../images/producto1.jpg",3));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
