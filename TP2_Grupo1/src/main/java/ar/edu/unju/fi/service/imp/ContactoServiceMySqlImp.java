package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Contacto;
import ar.edu.unju.fi.repository.IContactoRepository;
import ar.edu.unju.fi.service.IContactoService;
@Service("contactoServiceMySql")
public class ContactoServiceMySqlImp implements IContactoService {
	
	@Autowired
	private IContactoRepository contactoRepository;
	@Autowired
	private Contacto contacto;

	@Override
	public List<Contacto> getlistaMensajes() {
		
		return contactoRepository.findByEstado(true);
	}

	@Override
	public Contacto getContacto() {
		
		return contacto;
	}

	@Override
	public void borrarMensajes(Contacto contacto) {
		// eliminación lógica
		contacto.setEstado(false);
		contactoRepository.save(contacto);

	}

	@Override
	public void guardarMensaje(Contacto contacto) {
		contacto.setEstado(true);
		contactoRepository.save(contacto);
		
	}

}
