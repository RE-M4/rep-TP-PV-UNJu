package ar.edu.unju.fi.listas;
import ar.edu.unju.fi.entity.Sucursal;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.util.ArrayList;
import java.util.List;
@Component
public class ListasSucursales {
    public List<Sucursal> sucursales;

    public ListasSucursales(){
        sucursales = new ArrayList<>();

        Sucursal sucursal1 = new Sucursal();
        sucursal1.setNombre("Sucursal Humberto 1°");
        sucursal1.setCalle("CASTRO BARROS 1639");
        sucursal1.setProvincia("Córdoba");
        sucursal1.setDiaApertura("Lunes");
        sucursal1.setDiaCierre("Viernes");
        sucursal1.setHoraApertura(9);
        sucursal1.setHoraCierre(17);
        sucursal1.setTelefono("08001234567");
        sucursales.add(sucursal1);

        Sucursal sucursal2 = new Sucursal();
        sucursal2.setNombre("Sucursal Cerro 1°");
        sucursal2.setCalle("AV. RAFAEL NUÑEZ 4460");
        sucursal2.setProvincia("Córdoba");
        sucursal2.setDiaApertura("Lunes");
        sucursal2.setDiaCierre("Viernes");
        sucursal2.setHoraApertura(9);
        sucursal2.setHoraCierre(17);
        sucursal2.setTelefono("08001234567");
        sucursales.add(sucursal2);

        Sucursal sucursal3 = new Sucursal();
        sucursal3.setNombre("Sucursal Nuevo Mundo 1°");
        sucursal3.setCalle("SAN MARTÍN 1600");
        sucursal3.setProvincia("Córdoba");
        sucursal3.setDiaApertura("Lunes");
        sucursal3.setDiaCierre("Viernes");
        sucursal3.setHoraApertura(9);
        sucursal3.setHoraCierre(17);
        sucursal3.setTelefono("08001234567");
        sucursales.add(sucursal3);

        Sucursal sucursal4 = new Sucursal();
        sucursal4.setNombre("Sucursal Nueva Cordoba 1°");
        sucursal4.setCalle("AV. 9 DE SEPTIEMBRE 25");
        sucursal4.setProvincia("Córdoba");
        sucursal4.setDiaApertura("Lunes");
        sucursal4.setDiaCierre("Viernes");
        sucursal4.setHoraApertura(9);
        sucursal4.setHoraCierre(17);
        sucursal4.setTelefono("08001234567");
        sucursales.add(sucursal4);

    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
