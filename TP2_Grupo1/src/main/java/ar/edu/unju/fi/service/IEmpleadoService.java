package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
	public List<Empleado> getListaEmpleados();
	public Empleado getEmpleado(Long id);
}
