package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Categoria;

@Repository
public interface ICategoriaReposiroty extends CrudRepository<Categoria, Long>{
	
	public List<Categoria> findByEstado(boolean estado);

}
