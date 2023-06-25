package ar.edu.unju.fi.entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="con_id")
    private Long id;
    @Column(name="con_estado")
    private boolean estado;

    @Column(name="con_nombre")
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @Column(name="con_calle")
    @NotBlank(message = "La calle es requerida")
    private String calle;

    @Column(name="con_provincia")
    @NotEmpty(message = "La provincia no debe estar vacía")
    private String provincia;

    @Column(name="con_diaApertura")
    @NotEmpty(message = "El día de apertura no debe estar vacío")
    private String diaApertura;

    @Column(name="con_diaCierre")
    @NotEmpty(message = "El día de cierre no debe estar vacío")
    private String diaCierre;

    @Column(name="con_horaApertura")
    @Min(value = 0, message = "La hora de apertura debe ser mayor o igual a 0")
    @Max(value = 23, message = "La hora de apertura debe ser menor o igual a 23")
    private int horaApertura;
    @Column(name="con_horaCierre")
    @Min(value = 0, message = "La hora de cierre debe ser mayor o igual a 0")
    @Max(value = 23, message = "La hora de cierre debe ser menor o igual a 23")
    private int horaCierre;

    @Column(name="con_telefono")
    @NotBlank(message = "El teléfono no debe estar en blanco")
    private String telefono;

    /**
     * Constructor sin argumentos de la clase Sucursal.
     * Se inicializa el atributo estado en true.
     */
    public Sucursal() {
        this.estado = true;
    }

    /**
     * Constructor de la clase Sucursal.
     * @param nombre nombre de la sucursal
     * @param calle calle de la ubicacion de la sucursal
     * @param provincia provincia donde se encuetra la sucursal
     * @param diaApertura dia de apertura de la sucursal
     * @param diaCierre dia de cierre de la sucursal
     * @param horaApertura hora de apertura de la sucursal
     * @param horaCierre hora de cierre de la sucursal
     * @param telefono numero telefono de la sucursal
     * @param id identificador de la sucursal
     */
	public Sucursal(String nombre, String calle, String provincia, String diaApertura, String diaCierre, int horaApertura, int horaCierre,String telefono, long id) {

				this.nombre = nombre;
        this.calle = calle;
        this.provincia = provincia;
        this.diaApertura = diaApertura;
        this.diaCierre = diaCierre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.telefono = telefono;
        this.id = id;
        this.estado = true;
    }
// Metodos getters y setters de la clase Sucursal
    /**
     * Devuelve el identificador de la sucursal.
     * @return id de la sucursal
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna un identificador a la sucursal.
     * @param id identificador de la sucursal
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el estado de la sucursal.
     * @return true si la sucursal esta activa, false si esta inactiva
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Asigna un estado a la sucursal.
     * @param estado estado de la sucursal
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Establece el nombre de la sucursal.
     * @return nombre de la sucursal
     */
    public String getNombre() {
        return nombre;
    }

    /**
      * Devuelve el nombre de la sucursal.
     * @param nombre nombre de la sucursal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la calle de la ubicacion de la sucursal.
     * @return calle de la ubicacion de la sucursal
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la ubicacion de la sucursal.
     * @param calle calle de la ubicacion de la sucursal
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Devuelve la provincia donde se encuentra la sucursal.
     * @return provincia donde se encuentra la sucursal
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia donde se encuentra la sucursal.
     * @param provincia provincia donde se encuentra la sucursal
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve el dia de apertura de la sucursal.
     * @return dia de apertura de la sucursal
     */
    public String getDiaApertura() {
        return diaApertura;
    }

    /**
     * Establece el dia de apertura de la sucursal.
     * @param diaApertura dia de apertura de la sucursal
     */
    public void setDiaApertura(String diaApertura) {
        this.diaApertura = diaApertura;
    }
    /**
     * Devuelve el dia de cierre de la sucursal.
     * @return dia de cierre de la sucursal
     */
    public String getDiaCierre() {
        return diaCierre;
    }
    /**
     * Establece el dia de cierre de la sucursal.
     * @param diaCierre dia de cierre de la sucursal
     */
    public void setDiaCierre(String diaCierre) {
        this.diaCierre = diaCierre;
    }
    /**
     * Devuelve la hora de apertura de la sucursal.
     * @return hora de apertura de la sucursal
     */
    public int getHoraApertura() {
        return horaApertura;
    }
    /**
     * Establece la hora de apertura de la sucursal.
     * @param horaApertura hora de apertura de la sucursal
     */
    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }
    /**
     * Devuelve la hora de cierre de la sucursal.
     * @return hora de cierre de la sucursal
     */
    public int getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre de la sucursal.
     * @param horaCierre hora de cierre de la sucursal
     */
    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }
    /**
     * Devuelve el telefono de la sucursal.
     * @return telefono de la sucursal
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Establece el telefono de la sucursal.
     * @param telefono telefono de la sucursal
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
