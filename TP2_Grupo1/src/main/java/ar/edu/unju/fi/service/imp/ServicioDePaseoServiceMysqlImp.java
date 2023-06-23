package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.repository.IServicioDePaseosRepository;
import ar.edu.unju.fi.service.IServicioDePaseosService;

/*Esta implementación se crea a partir de aplicar la capa repository, cumple la misma función pero ahora
  debe utilizar métodos correspondientes a CrudRepository*/
/*Se debe agregar un nombre en la etiqueta "Service" ya que hace un contrato con el archivo service (al igual
  que ServiciosDePaseoImp.java y el controller tiene conflictos para saber cual de los 2 usar*/

@Service("servicioDePaseoServiceImpMysql")
public class ServicioDePaseoServiceMysqlImp implements IServicioDePaseosService {
	
	/*Se debe hacer Autowired de IServicioDePaseosRepository para que también busque las funciones que 
	 * están en este archivo*/
	@Autowired
	private IServicioDePaseosRepository servicioRepository;
	
	@Autowired
	private ServicioDePaseo servicio;
	
	@Override
	public List<ServicioDePaseo> getListaServicios() {
		return servicioRepository.findByEstado(true);
	}

	public ServicioDePaseo getBy(Long id) {
		return servicioRepository.findById(id).get();
	}

	public void modificarServicio(ServicioDePaseo servicioAModificar) {
		servicioRepository.save(servicioAModificar);
	}

	public void borrarServicio(ServicioDePaseo servicio) {
		servicio.setEstado(false);
		servicioRepository.save(servicio);
	}

	public void guardarServicio(ServicioDePaseo servicioAGuardar) {
		servicioRepository.save(servicioAGuardar);
	}
	
	public ServicioDePaseo getServicio() {
		return this.servicio;
	}

}
