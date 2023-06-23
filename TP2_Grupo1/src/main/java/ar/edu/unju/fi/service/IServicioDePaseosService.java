package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ServicioDePaseo;

/*
 * Archivo de la capa service que sirve para ser inyectada dentro de ServicioDePaseoController.
 * Este archivo es un intermediario entre el controller (que solicita los métodos) y la implementación
 * que es el archivo que contiene la lógica de negocio (los métodos) => (ServicioDePaseosImp.java).
 */
public interface IServicioDePaseosService {
	List<ServicioDePaseo> getListaServicios();
	ServicioDePaseo getBy(Long id);
	ServicioDePaseo getServicio();
	//ServicioDePaseo buscarServicio(String nombrePaseador);
	void modificarServicio(ServicioDePaseo servicioAModificar);
	void borrarServicio(ServicioDePaseo servicio);
	//void borrarServicio(String servicioABorrar);
	void guardarServicio(ServicioDePaseo servicioAGuardar);
}
