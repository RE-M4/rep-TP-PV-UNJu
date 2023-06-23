package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.ConsejoSalud;

@Component
public class ListaConsejoSalud {

	private List<ConsejoSalud> listaConsejoSalud;
	
	
	/**
	 * constructor que carga una lista con objetos de tipo ConsejoSalud
	 */
	public ListaConsejoSalud() {
	//	listaConsejoSalud = new ArrayList<ConsejoSalud>();
		//listaConsejoSalud.add(new ConsejoSalud("../images/saludMascotas4.jpg","La importancia de desparasitar a su paciente felino, incluso si no sale de casa","Los felinos, al igual que todos los animales de compañía e incluso los humanos, son \r\n"
	//			+ "					afectados por una amplia gama de parásitos. Por definición, el parásito produce\r\n"
	//			+ "					efectos dañinos en su hospedador y se considera que aquellos que viven en la \r\n"
	//			+ "					superficie externa del hospedador o en la piel, denominados ectoparásitos, \r\n"
	//			+ "					causan infestaciones.",1));
	//	listaConsejoSalud.add(new ConsejoSalud("../images/saludMascotas2.jpg","La importancia de la prevención parasitaria continuada","La consulta veterinaria es una oportunidad para llevar a cabo\r\n"
	//			+ "					medicina preventiva y generar recomendaciones que pueden evitar \r\n"
	//			+ "					enfermedades a largo plazo en animales de compañía.\r\n"
	//			+ "						Es un espacio para discutir acerca de los esquemas de vacunación,\r\n"
	//			+ "					cuidados generales, nutrición, estado físico del animal y prevención\r\n"
	//			+ "					de enfermedades. También, es una oportunidad para educar a los \r\n"
	//			+ "					selección y uso periódico de los diferentes antiparasitarios.",2));
		
	//	listaConsejoSalud.add(new ConsejoSalud("../images/saludMascotas3.jpg","Manejo de la Diabetes en Perros y Gatos","La diabetes mellitus es una enfermedad endocrina que requiere un monitoreo\r\n"
	//			+ "					continuo y ajustes en el estilo de vida de las mascotas y de sus propietarios.\r\n"
	//			+ "					Aunque este diagnóstico puede sonar aterrador, se puede mantener una buena \r\n"
	//			+ "					calidad de vida para \r\n"
	//			+ "					las mascotas y un buen pronóstico a largo plazo siguiendo un plan de manejo\r\n"
	//			+ "					adecuado a las necesidades de cada paciente.\r\n"
	//			+ "					El manejo de la diabetes en perros y gatos es fundamental para evitar \r\n"
	//			+ "					consecuencias serias y las secuelas de esta compleja enfermedad. \r\n"
	//			+ "					Aunque algunos de los signos pueden variar entre perros y gatos, \r\n"
	//			+ "					los principios básicos de manejo clínico son similares y abarcan la \r\n"
	//			+ "					modificación del estilo de vida de las mascotas y el tratamiento con \r\n"
	//			+ "					insulina a largo plazo.",3));
		
		
	}

	//getter and setter
	public List<ConsejoSalud> getListaConsejoSalud() {
		return listaConsejoSalud;
	}

	public void setListaConsejoSalud(List<ConsejoSalud> listaConsejoSalud) {
		this.listaConsejoSalud = listaConsejoSalud;
	}
	
}
