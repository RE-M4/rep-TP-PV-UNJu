package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Provincia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProvinciaRepository extends CrudRepository<Provincia, Long> {

	public List<Provincia> findByEstado(boolean estado);
}
