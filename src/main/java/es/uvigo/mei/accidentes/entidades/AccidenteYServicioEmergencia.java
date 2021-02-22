package es.uvigo.mei.accidentes.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AccidenteYServicioEmergencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Accidente accidente;

    @ManyToOne
    private ServicioEmergencia servicioEmergencia;

    public AccidenteYServicioEmergencia () {

    }

    public AccidenteYServicioEmergencia(Long id, Accidente accidente, ServicioEmergencia servicioEmergencia) {
        this.setId(id);
        this.setAccidente(accidente);
        this.setServicioEmergencia(servicioEmergencia);
    }

    public Accidente getAccidente() {
        return accidente;
    }

    public void setAccidente(Accidente accidente) {
        this.accidente = accidente;
    }

    public ServicioEmergencia getServicioEmergencia() {
        return servicioEmergencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServicioEmergencia(ServicioEmergencia servicioEmergencia) {
        this.servicioEmergencia = servicioEmergencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidenteYServicioEmergencia that = (AccidenteYServicioEmergencia) o;
        return id.equals(that.id) &&
                accidente.equals(that.accidente) &&
                servicioEmergencia.equals(that.servicioEmergencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accidente, servicioEmergencia);
    }

    @Override
    public String toString() {
        return "AccidenteYServicioEmergencia{" +
                "id=" + id +
                ", accidente=" + accidente +
                ", servicioEmergencia=" + servicioEmergencia +
                '}';
    }
}
