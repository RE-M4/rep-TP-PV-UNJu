package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.ConsejoSalud;

public interface IConsejoSaludService {
	
	/**
	 * Devuelve el Consejo de Salud null.
	 * 
	 * @return el objeto ConsejoSalud null
	 */
	public ConsejoSalud getConsejoSalud();

	/**
	 * Devuelve una lista de todos los Consejos de Salud disponibles.
	 * 
	 * @return una lista de objetos ConsejoSalud
	 */
	public List<ConsejoSalud> getListaConsejo();

	/**
	 * Busca y devuelve un Consejo de Salud según su id.
	 * 
	 * @param id el identificador del Consejo de Salud a buscar
	 * @return el objeto ConsejoSalud correspondiente al id dado
	 */
	public ConsejoSalud getBuscarConsejoSalud(int id);

	
	/**
	 * Busca y devuelve un objeto ConsejoSalud según su título.
	 *
	 * @param titulo el título del ConsejoSalud a buscar
	 * @return el objeto ConsejoSalud correspondiente al título dado, o null si no se encuentra
	 */
	public ConsejoSalud getBuscarConsejoxTirulo(String titulo);
	
	/**
	 * Guarda un nuevo Consejo de Salud en en la lista 
	 * 
	 * @param consejo el objeto ConsejoSalud a guardar
	 */
	public void guardarConsejo(ConsejoSalud consejo);

	/**
	 * Modifica un Consejo de Salud existente en la lista.
	 * 
	 * @param consejo el objeto ConsejoSalud modificado
	 */
	public void modificarConsejo(ConsejoSalud consejo);

	/**
	 * Elimina un Consejo de Salud de la lista.
	 * 
	 * @param consejo el objeto ConsejoSalud a eliminar
	 */
	public void eliminarConsejo(ConsejoSalud consejo);

	/**
	 * Genera y devuelve un nuevo id para un objeto ConsejoSalud
	 *
	 * @return un nuevo id generado
	 */
	public int getAsignarId();
	
}
