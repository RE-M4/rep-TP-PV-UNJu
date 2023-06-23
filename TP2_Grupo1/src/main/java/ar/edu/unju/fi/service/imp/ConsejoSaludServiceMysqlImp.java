package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ConsejoSalud;
import ar.edu.unju.fi.repository.IConsejoSaludRepository;
import ar.edu.unju.fi.service.IConsejoSaludService;

@Service("ConsejoSaludServiceMysqlImp")
public class ConsejoSaludServiceMysqlImp implements IConsejoSaludService {
	
	@Autowired
	private IConsejoSaludRepository consejoRepository;
	
	@Autowired
	private ConsejoSalud consejoSalud;

	@Override
	public ConsejoSalud getConsejoSalud() {
		// TODO Auto-generated method stub
		return consejoSalud;
	}

	@Override
	public List<ConsejoSalud> getListaConsejo() {
		// TODO Auto-generated method stub
		return consejoRepository.findByEstado(true);
	}

	@Override
	public ConsejoSalud getBuscarConsejoSalud(long id) {
		// TODO Auto-generated method stub
		return consejoRepository.findById(id).get();
	}

	@Override
	public ConsejoSalud getBuscarConsejoxTirulo(String titulo) {
		// TODO Auto-generated method stub
		return consejoRepository.findByTitulo(titulo);
	}

	@Override
	public void guardarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		consejoRepository.save(consejo);
	}

	@Override
	public void modificarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		consejoRepository.save(consejo);
	}

	@Override
	public void eliminarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		consejo.setEstado(false);
		consejoRepository.save(consejo);
	}

}
