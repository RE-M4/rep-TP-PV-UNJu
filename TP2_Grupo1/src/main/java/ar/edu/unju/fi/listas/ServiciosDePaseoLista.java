package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.ServicioDePaseo;

//Se agrega esta etiqueta para que el objeto sirva como inyección de dependencia dentro de la capa service
@Component
public class ServiciosDePaseoLista {
	/*Se crea una lista de tipo ServicioDePaseo*/
	private List<ServicioDePaseo> serviciosDePaseo;
	/*La lista se transforma en un ArrayList y se cargan datos*/
	public ServiciosDePaseoLista() {
		serviciosDePaseo = new ArrayList<ServicioDePaseo>();
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Juan Perez", "Lunes y Miercoles"));
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Lucas Diaz", "Martes"));
		serviciosDePaseo.add(new ServicioDePaseo("9 a 12 - 16 a 18", "Maria Mamani", "Jueves y Sabado"));
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
