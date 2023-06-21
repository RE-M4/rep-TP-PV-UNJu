package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ConsejoSalud;
import ar.edu.unju.fi.repository.IConsejoSaludRepository;
import ar.edu.unju.fi.service.IConsejoSaludService;

@Service("ConsejoSaludServiceMysqlImp")
public class ConsejoSaludServiceMysqlImp implements IConsejoSaludService {

	@Autowired
	private IConsejoSaludRepository ConsejoSaludRespository;
	
	@Autowired
	ConsejoSalud consejoSalud;
	
	
	@Override
	public ConsejoSalud getConsejoSalud() {
		// TODO Auto-generated method stub
		return consejoSalud;
	}

	@Override
	public List<ConsejoSalud> getListaConsejo() {
		// TODO Auto-generated method stub
		return ConsejoSaludRespository.findByEstado(true);
	}

	@Override
	public ConsejoSalud getBuscarConsejoSalud(long id) {
		// TODO Auto-generated method stub
		return ConsejoSaludRespository.findById(id).get();
	}

	@Override
	public ConsejoSalud getBuscarConsejoxTirulo(String titulo) {
		// TODO Auto-generated method stub
		return ConsejoSaludRespository.findByTitulo(titulo);
	}

	@Override
	public void guardarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		ConsejoSaludRespository.save(consejo);
	}

	@Override
	public void modificarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		ConsejoSaludRespository.save(consejo);
	}

	@Override
	public void eliminarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		consejo.setEstado(false);
		ConsejoSaludRespository.save(consejo);
	}

	@Override
	public long getAsignarId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
