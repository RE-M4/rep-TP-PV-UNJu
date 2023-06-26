package ar.edu.unju.fi.entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
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

    @JoinColumn(name="pro_id")
    @OneToOne(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    private Provincia provincia;


    @NotEmpty(message = "El nombre no puede estar vacio")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name="con_nombre")
    private String nombre;

    @NotNull(message = "La calle es requerida")
    @NotEmpty(message = "La calle no puede estar vacio")
    @NotBlank(message = "La calle no puede estar en blanco")
    @Column(name="con_calle")
    private String calle;


    @NotEmpty(message = "El día de apertura  no puede estar vacio")
    @NotBlank(message = "El día de apertura  no puede estar en blanco")
    @Column(name="con_diaApertura")
    private String diaApertura;


    @NotEmpty(message = "El día de cierre  no puede estar vacio")
    @NotBlank(message = "El día de cierre  no puede estar en blanco")
    @Column(name="con_diaCierre")
    private String diaCierre;

    @Min(value = 1, message = "La hora de apertura debe ser igual o mayor a 0")
    @Max(value = 23, message = "La hora de apertura debe ser igual o menor a 23")
    private int horaApertura;

    @Min(value = 0, message = "La hora de cierre debe ser igual o mayor a 0")
    @Max(value = 23, message = "La hora de cierre debe ser igual o menor a 23")
    private int horaCierre;

    @NotNull(message = "El teléfono no debe estar en blanco")
    @NotEmpty(message = "El teléfono no puede estar vacio")
    @NotBlank(message = "El teléfono no puede estar en blanco")
    @Column(name="con_telefono")
    private String telefono;

    /**
     * Constructor sin argumentos de la clase Sucursal.
     * Se inicializa el atributo estado en true.
     */
    public Sucursal() {
        this.estado = true;
    }

    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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
	public Sucursal(String nombre, String calle, Provincia provincia, String diaApertura, String diaCierre, int horaApertura, int horaCierre,String telefono, long id) {

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
