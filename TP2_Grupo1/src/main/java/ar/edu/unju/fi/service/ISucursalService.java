package ar.edu.unju.fi.service;
import ar.edu.unju.fi.entity.Sucursal;

import java.util.List;

public interface ISucursalService {
	Sucursal getBuscarSucursal(Long id);

	Sucursal getSucursal();
	 List<Sucursal> getListaSucursales();
	 void guardarSucursal(Sucursal sucursal);
	 void modificar (Sucursal sucursal);
	 void eliminar (Sucursal sucursal);
}
