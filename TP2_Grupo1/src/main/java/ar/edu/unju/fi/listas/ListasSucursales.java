package ar.edu.unju.fi.listas;

import ar.edu.unju.fi.model.Sucursales;

import java.util.ArrayList;
import java.util.List;

public class ListasSucursales {
    public List<Sucursales> sucursales;
    public ListasSucursales(){
        sucursales=new ArrayList<Sucursales>();
    }

    public List<Sucursales> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursales> sucursales) {
        this.sucursales = sucursales;
    }
}
