package ar.edu.unju.fi.service;
import ar.edu.unju.fi.model.Sucursal;

import java.util.List;

public interface ISucursalService {
	Sucursal getSucursal();
	public  List<Sucursal> getListaSucursales();
	public Sucursal getBuscarSucursal(int id);
	public void guardarSucursal(Sucursal sucursal);
	public void modificar (Sucursal sucursal);
	public void eliminar (Sucursal sucursal);
}
