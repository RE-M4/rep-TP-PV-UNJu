package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ServiciosDePaseoLista;
import ar.edu.unju.fi.model.ServicioDePaseo;
import ar.edu.unju.fi.service.IServicioDePaseosService;

@Service
public class ServicioDePaseosImp implements IServicioDePaseosService{
	@Autowired
	private ServiciosDePaseoLista serviciosLista;
	@Autowired
	private ServicioDePaseo servicioDePaseo;
	
	@Override
	public List<ServicioDePaseo> getListaServicios() {
		return serviciosLista.getServiciosDePaseo();
	}

	@Override
	public ServicioDePaseo getServicio() {
		return this.servicioDePaseo;
	}

	public ServicioDePaseo buscarServicio (String nombreBuscado) {
		ServicioDePaseo servicioEncontrado = servicioDePaseo;
		for(ServicioDePaseo servicio : serviciosLista.getServiciosDePaseo()) {/*Se busca un objeto dentro del Array tienendo en cuenta el nombre*/
			if(servicio.getPaseador().equals(nombreBuscado)) {
				servicioEncontrado = servicio;
				break;
			}
		}
		return servicioEncontrado;
	}

	public void modificarServicio(ServicioDePaseo servicioAModificar) {
		for(ServicioDePaseo servicioOriginal : serviciosLista.getServiciosDePaseo()) {
			if(servicioOriginal.getPaseador().equals(servicioAModificar.getPaseador())) {
				//servicioOriginal = servicioModificado /*Esta línea no modifica los datos de un objeto con otro objeto, solo crea 2 punteros al mismo objeto*/
				servicioOriginal.setPaseador(servicioAModificar.getPaseador()); /*Al momento de querer cambiar este atributo, queda como está porque sirve como identificador, se debe usar un identificador único que no pueda ser modificado*/
				servicioOriginal.setDia(servicioAModificar.getDia());
				servicioOriginal.setHorario(servicioAModificar.getHorario());
				break;
			}
		}
	}

	public void borrarServicio(String servicioABorrar) {
		ServicioDePaseo servicioEncontrado = buscarServicio(servicioABorrar);
		serviciosLista.getServiciosDePaseo().remove(servicioEncontrado);
	}

	public void guardarServicio(ServicioDePaseo servicioAGuardar) {
		serviciosLista.getServiciosDePaseo().add(servicioAGuardar);
	}
}
