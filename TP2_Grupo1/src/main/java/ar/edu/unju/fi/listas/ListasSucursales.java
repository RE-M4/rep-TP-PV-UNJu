package ar.edu.unju.fi.listas;

import ar.edu.unju.fi.model.Sucursal;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListasSucursales {
    public List<Sucursal> sucursales;
//    private String nombre;
//    private String calle;
//    private String provincia;
//    private String diaApertura;
//    private String diaCierre;
//    private LocalTime horaApertura;
//    private LocalTime horaCierre;
//    private boolean horariosEspeciales;
//    private LocalTime horaAperturaEspecial;
//    private LocalTime horaCierreEspecial;
//    private String telefono;
//    <h3 class="sucursal-nombre">Sucursal Nueva Cordoba 1°</h3>
//    <p class="sucursal-calle">AV. 9 DE SEPTIEMBRE 25 | RIO TERCERO | Córdoba</p>
//    <p class="sucursal-horario">Horario: Lunes a Viernes de 9 a 17hs y Sábados de 8 a 12hs.</p>
//    <p class="sucursal-tel"> 0800 123 4567</p>
    public ListasSucursales(){
        sucursales=new ArrayList<Sucursal>();
        //sucursales.add(new Sucursal("Sucursal Nueva Cordoba 1°", "AV. 9 DE SEPTIEMBRE 25","Córdoba","Lunes","Viernes",LocalTime.of(3)));
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
