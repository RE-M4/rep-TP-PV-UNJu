package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaReposiroty;
import ar.edu.unju.fi.service.ICategoriaService;

@Service
public class CategoriaServiceMysqlImp implements ICategoriaService {
	
	@Autowired
	private ICategoriaReposiroty categoriaRepository;

	@Override
	public List<Categoria> getListaCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findByEstado(true);
	}

}
