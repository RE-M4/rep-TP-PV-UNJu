package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
	Sucursal getSucursal();
	public  List<Sucursal> getListaSucursales();
	public Sucursal getBuscarSucursal(int id);
	public void guardarSucursal(Sucursal sucursal);
	public void modificar (Sucursal sucursal);
	public void eliminar (Sucursal sucursal);
}
