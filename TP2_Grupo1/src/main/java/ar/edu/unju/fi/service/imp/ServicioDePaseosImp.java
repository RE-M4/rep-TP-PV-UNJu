package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.listas.ServiciosDePaseoLista;
import ar.edu.unju.fi.service.IServicioDePaseosService;

/*
 * Archivo de la capa service que contiene los métodos solicitados por ServicioDePaseoController.
 * La palabra reservada "implements" hace que se cree un contrato entre IServicioDePaseosService y este archivo
 * por lo que todos los métodos declarados dentro del service deben existir dentro de este archivo también.
 * Se agrega esta etiqueta para declarar el archivo como parte de la capa service.
 */
/*Se debe agregar un nombre en la etiqueta "Service" ya que hace un contrato con el archivo service (al igual
que ServiciosDePaseoServiceMysqlImp.java y el controller tiene conflictos para saber cual de los 2 usar*/

@Service("servicioDePaseoServiceImp")
public class ServicioDePaseosImp implements IServicioDePaseosService{
	//Inyección del objeto lista
	@Autowired
	private ServiciosDePaseoLista serviciosLista;
	
	//Inyección del objeto
	@Autowired
	private ServicioDePaseo servicioDePaseo;
	
	/**
	 * Método que devuelve el Array de objetos
	 */
	@Override
	public List<ServicioDePaseo> getListaServicios() {
		return serviciosLista.getServiciosDePaseo();
	}
	
	/**
	 * Método que devuelve un objeto vacío
	 */
	@Override
	public ServicioDePaseo getServicio() {
		return this.servicioDePaseo;
	}
	
	/**
	 * Método que recibe un String, busca un objeto en particular y lo devuelve
	 */
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
	
	/**
	 * Método que recibe un objeto en particular con datos cambiados, lo busca en 
	 * el Array de objetos (con un valor único que lo identifique) y, de encontrarlo, cambia sus valores originales
	 * por los que llegan como parámetro.
	 */
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
	
	/**
	 * Método que recibe un objeto en particular, lo busca en el Array y, de encontrarlo, lo elimina.
	 */
	public void borrarServicio(String servicioABorrar) {
		ServicioDePaseo servicioEncontrado = buscarServicio(servicioABorrar);
		serviciosLista.getServiciosDePaseo().remove(servicioEncontrado);
	}

	/**
	 * Método que recibe un objeto nuevo y lo guarda en el Array de objetos
	 */
	public void guardarServicio(ServicioDePaseo servicioAGuardar) {
		serviciosLista.getServiciosDePaseo().add(servicioAGuardar);
	}
}
