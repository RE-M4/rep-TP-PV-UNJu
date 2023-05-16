package ar.edu.unju.fi.model;

public class Sucursales {
    private String nombre;
    private String calle;
    private String provincia;
    private String horario;
    private String telefono;

    public Sucursales() {
    }

    public Sucursales(String nombre, String calle, String provincia, String horario, String telefono) {
        this.nombre = nombre;
        this.calle = calle;
        this.provincia = provincia;
        this.horario = horario;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
