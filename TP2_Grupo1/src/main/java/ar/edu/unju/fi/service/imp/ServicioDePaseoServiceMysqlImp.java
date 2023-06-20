package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.repository.IServicioDePaseosRepository;
import ar.edu.unju.fi.service.IServicioDePaseosService;

@Service("servicioDePaseoServiceImpMysql")
public class ServicioDePaseoServiceMysqlImp implements IServicioDePaseosService {

	@Autowired
	private IServicioDePaseosRepository servicioRepository;
	
	@Override
	public List<ServicioDePaseo> getListaServicios() {
		
		return null;
	}

	@Override
	public ServicioDePaseo getServicio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicioDePaseo buscarServicio(String nombrePaseador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarServicio(ServicioDePaseo servicioAModificar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarServicio(String servicioABorrar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarServicio(ServicioDePaseo servicioAGuardar) {
		// TODO Auto-generated method stub

	}

}
