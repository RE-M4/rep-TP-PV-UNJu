package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviciaServiceMysqlImp implements IProvinciaService {
	@Autowired
	private IProvinciaRepository provinciaRepository;
	@Override
	public List<Provincia> getListaProvincias() {
		// TODO Auto-generated method stub
		return provinciaRepository.findByEstado(true);
	}
}
