package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ConsejoSalud;
import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.service.IConsejoSaludService;


@Service("ConsejoSaludServiceImp")
public class ConsejoSaludServiceImp implements IConsejoSaludService {

	@Autowired	
	ListaConsejoSalud listaConsejoSalud;
	
	@Autowired
	ConsejoSalud consejoSalud;
	
	
	/**
	 * Metodo que retorna un objeto de tipo ConsejoSalud
	 */
	@Override
	public ConsejoSalud getConsejoSalud() {
		// TODO Auto-generated method stub
		return consejoSalud;
	}

	/**
	 * Metodo que retorna una lista con obejetos de tipo ConsejoSalud
	 */
	@Override
	public List<ConsejoSalud> getListaConsejo() {
		// TODO Auto-generated method stub
		return listaConsejoSalud.getListaConsejoSalud();
	}

	/**
	 * Busca y devuelve un Consejo de Salud según su id.
	 * 
	 * @param id el identificador del Consejo de Salud a buscar
	 * @return el objeto ConsejoSalud correspondiente al id dado
	 */
	@Override
	public ConsejoSalud getBuscarConsejoSalud(long id) {
		// TODO Auto-generated method stub
		for(ConsejoSalud consejo: listaConsejoSalud.getListaConsejoSalud()) {
			if(consejo.getId().equals(id)) {
				return consejo;
			}
		}
		return null;
	}
	
	
	/**
	 * Guarda un nuevo Consejo de Salud en en la lista 
	 * 
	 * @param consejo el objeto ConsejoSalud a guardar
	 */
	@Override
	public void guardarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		listaConsejoSalud.getListaConsejoSalud().add(consejo);
	}

	/**
	 * Modifica un Consejo de Salud existente en la lista.
	 * 
	 * @param consejo el objeto ConsejoSalud modificado
	 */
	@Override
	public void modificarConsejo(ConsejoSalud consejoSalud) {
		// TODO Auto-generated method stub
		for(ConsejoSalud consejo: listaConsejoSalud.getListaConsejoSalud()) {
			if(consejo.getId().equals(consejoSalud.getId())) {
				consejo.setTitulo(consejoSalud.getTitulo());
				consejo.setImg(consejoSalud.getImg());
				consejo.setDescripcion(consejoSalud.getDescripcion());
				break;
			}
		}
	}

	/**
	 * Elimina un Consejo de Salud de la lista.
	 * 
	 * @param consejo el objeto ConsejoSalud a eliminar
	 */
	@Override
	public void eliminarConsejo(ConsejoSalud consejo) {
		// TODO Auto-generated method stub
		listaConsejoSalud.getListaConsejoSalud().remove(consejo);
	}

	/**
	 * Busca y devuelve un objeto ConsejoSalud según su título.
	 *
	 * @param titulo el título del ConsejoSalud a buscar
	 * @return el objeto ConsejoSalud correspondiente al título dado, o null si no se encuentra
	 */
	@Override
	public ConsejoSalud getBuscarConsejoxTirulo(String titulo) {
		// TODO Auto-generated method stub
		for(ConsejoSalud consejo: listaConsejoSalud.getListaConsejoSalud()) {
			if(consejo.getTitulo().equals(titulo)) {
				return consejo;
			}
		}
		return null;
	}

	/**
	 * Genera y devuelve un nuevo id para un objeto ConsejoSalud
	 *
	 * @return un nuevo id generado
	 */
	
}
