package ar.edu.unju.fi.model;

import java.time.LocalTime;

public class Sucursal {
    private String nombre;
    private String calle;
    private String provincia;
    private String diaApertura;
    private String diaCierre;
    private int horaApertura;
    private int horaCierre;
    private boolean horariosEspeciales;
    private LocalTime horaAperturaEspecial;
    private LocalTime horaCierreEspecial;
    private String telefono;

    public Sucursal() {

    }
	public Sucursal(String nombre, String calle, String provincia, String diaApertura, String diaCierre, int horaApertura, int horaCierre, boolean horariosEspeciales, LocalTime horaAperturaEspecial, LocalTime horaCierreEspecial, String telefono) {

				this.nombre = nombre;
        this.calle = calle;
        this.provincia = provincia;
        this.diaApertura = diaApertura;
        this.diaCierre = diaCierre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.horariosEspeciales = horariosEspeciales;
        this.horaAperturaEspecial = horaAperturaEspecial;
        this.horaCierreEspecial = horaCierreEspecial;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDiaApertura() {
        return diaApertura;
    }

    public void setDiaApertura(String diaApertura) {
        this.diaApertura = diaApertura;
    }

    public String getDiaCierre() {
        return diaCierre;
    }

    public void setDiaCierre(String diaCierre) {
        this.diaCierre = diaCierre;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    public boolean isHorariosEspeciales() {
        return horariosEspeciales;
    }

    public void setHorariosEspeciales(boolean horariosEspeciales) {
        this.horariosEspeciales = horariosEspeciales;
    }

    public LocalTime getHoraAperturaEspecial() {
        return horaAperturaEspecial;
    }

    public void setHoraAperturaEspecial(LocalTime horaAperturaEspecial) {
        this.horaAperturaEspecial = horaAperturaEspecial;
    }

    public LocalTime getHoraCierreEspecial() {
        return horaCierreEspecial;
    }

    public void setHoraCierreEspecial(LocalTime horaCierreEspecial) {
        this.horaCierreEspecial = horaCierreEspecial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
