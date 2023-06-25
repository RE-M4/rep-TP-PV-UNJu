package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long> {
 /**
  * Metodo que permite buscar una sucursal segun su estado
	* @param estado - estado de la sucursal a buscar
	* @return lista de sucursales que coinciden con el estado
	*/
	public List<Sucursal> findByEstado(boolean estado);

}
