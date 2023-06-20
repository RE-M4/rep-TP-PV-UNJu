package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long> {
			public List<Sucursal> findByEstado(boolean estado);

}
