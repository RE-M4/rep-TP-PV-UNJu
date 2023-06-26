package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;

@Service
public class EmpleadoServiceMysqlImp implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getListaEmpleados() {
		return empleadoRepository.findByEstado(true);
	}

	@Override
	public Empleado getEmpleado(Long id) {
		return empleadoRepository.findById(id).get();
	}
	
}
