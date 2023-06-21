package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ServicioDePaseo;

/*
 * Archivo de la capa service que sirve para ser inyectada dentro de ServicioDePaseoController.
 * Este archivo es un intermediario entre el controller (que solicita los métodos) y la implementación
 * que es el archivo que contiene la lógica de negocio (los métodos) => (ConsejoSaludServiceImp.java).
 */
public interface IServicioDePaseosService {
	List<ServicioDePaseo> getListaServicios();
	ServicioDePaseo getServicio();
	ServicioDePaseo buscarServicio(String nombrePaseador);
	void modificarServicio(ServicioDePaseo servicioAModificar);
	void borrarServicio(String servicioABorrar);
	void guardarServicio(ServicioDePaseo servicioAGuardar);
}
