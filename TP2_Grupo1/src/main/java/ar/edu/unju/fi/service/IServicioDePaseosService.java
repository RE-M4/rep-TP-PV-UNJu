package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.ServicioDePaseo;

public interface IServicioDePaseosService {
	List<ServicioDePaseo> getListaServicios();
	ServicioDePaseo getServicio();
	ServicioDePaseo buscarServicio(String nombrePaseador);
	void modificarServicio(ServicioDePaseo servicioAModificar);
	void borrarServicio(String servicioABorrar);
	void guardarServicio(ServicioDePaseo servicioAGuardar);
}
