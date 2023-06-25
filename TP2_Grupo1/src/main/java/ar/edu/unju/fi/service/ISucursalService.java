package ar.edu.unju.fi.service;
import ar.edu.unju.fi.entity.Sucursal;
import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
	/**
	 * Busca y retorna una sucursal por su id
	 * @param id de la sucursal a buscar
	 * @return la sucursal encontrada
	 */
	Sucursal getBuscarSucursal(Long id);
	/**
	 * Retorna una sucursal
	 * @return nueva instancia de sucursal
	 */
	Sucursal getSucursal();
	/**
	 * Retorna una lista de sucursales
	 * @return lista de sucursales
	 */
	List<Sucursal> getListaSucursales();
	/**
	 * Guarda una sucursal
	 * @param sucursal a guardar
	 */
	void guardarSucursal(Sucursal sucursal);
	/**
	 * Modifica una sucursal
	 * @param sucursal a modificar
	 */
	void modificar (Sucursal sucursal);
	/**
	 * Elimina una sucursal
	 * @param sucursal a eliminar
	 */
	void eliminar (Sucursal sucursal);
}
