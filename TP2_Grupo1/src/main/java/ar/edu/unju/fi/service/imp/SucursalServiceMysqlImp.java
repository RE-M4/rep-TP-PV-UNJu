package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("sucursalServiceMysqlImp")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository;
	@Autowired
	private Sucursal sucursal;

	@Override
	public List<Sucursal> getListaSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardarSucursal(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}
	@Override
	public Sucursal getBuscarSucursal(Long id) {
		return sucursalRepository.findById(id).get();
	}
	@Override
	public void modificar(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}
	@Override
	public void eliminar(Sucursal sucursal) {
		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);
	}
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

}
