package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListasSucursales;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ListasSucursales listasSucursales;
	@Override
	public Sucursal getSucursal() {
		return new Sucursal();
	}
	@Override
	public List<Sucursal> getListaSucursales(){
		return listasSucursales.getSucursales();
	}
	@Override
	public void guardarSucursal(Sucursal sucursal) {
		listasSucursales.getSucursales().add(sucursal);
	}
	@Override
	public Sucursal getBuscarSucursal(Long id) {
		for (Sucursal sucursal : listasSucursales.getSucursales()) {
			if (sucursal.getId().equals(id)) {
				return sucursal;
			}
		}
		return null;
	}
	@Override
	public void modificar(Sucursal sucursal) {
		for (Sucursal sucursal2 : listasSucursales.getSucursales()) {
			if (sucursal2.getId().equals(sucursal.getId())) {
				sucursal2.setNombre(sucursal.getNombre());
				sucursal2.setCalle(sucursal.getCalle());
				sucursal2.setProvincia(sucursal.getProvincia());
				sucursal2.setDiaApertura(sucursal.getDiaApertura());
				sucursal2.setDiaCierre(sucursal.getDiaCierre());
				// Validar rango de horaApertura
				if (sucursal.getHoraApertura() >= 0 && sucursal.getHoraApertura() <= 23) {
					sucursal2.setHoraApertura(sucursal.getHoraApertura());
				}

				// Validar rango de horaCierre
				if (sucursal.getHoraCierre() >= 0 && sucursal.getHoraCierre() <= 23) {
					sucursal2.setHoraCierre(sucursal.getHoraCierre());
				}

				sucursal2.setTelefono(sucursal.getTelefono());
				break;
			}
		}
	}

	@Override
	public void eliminar(Sucursal sucursal) {
		listasSucursales.getSucursales().remove(sucursal);
	}


}
