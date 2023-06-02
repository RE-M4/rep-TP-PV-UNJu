package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.ServicioDePaseo;

@Component
public class ServiciosDePaseoLista {
	/*Se crea una lista de tipo ServicioDePaseo*/
	private List<ServicioDePaseo> serviciosDePaseo;
	/*La lista se transforma en un ArrayList y se cargan datos*/
	public ServiciosDePaseoLista() {
		serviciosDePaseo = new ArrayList<ServicioDePaseo>();
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Juan Perez", "Lunes y Miércoles"));
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Lucas Díaz", "Martes"));
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "María Mamani", "Jueves y Sábado"));
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Josefina Lopez", "Viernes"));
	}
	/*Getters y setters*/
	public List<ServicioDePaseo> getServiciosDePaseo() {
		return serviciosDePaseo;
	}
	public void setServiciosDePaseo(List<ServicioDePaseo> serviciosDePaseo) {
		this.serviciosDePaseo = serviciosDePaseo;
	}
	
}
