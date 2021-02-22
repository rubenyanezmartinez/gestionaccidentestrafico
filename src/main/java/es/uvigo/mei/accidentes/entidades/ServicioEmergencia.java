package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ServicioEmergencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoServicioEmergencia tipo = TipoServicioEmergencia.OTRO;

    @NotNull
    @Size(min=2, max=50, message = "La longitud del campo debe ser entre 1 y 50 caracteres")
    private String localidad;

    public ServicioEmergencia () {

    }

    public ServicioEmergencia(Long id, TipoServicioEmergencia tipo, String localidad) {
        this.setId(id);
        this.setTipo(tipo);
        this.setLocalidad(localidad);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public TipoServicioEmergencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicioEmergencia servicioEmergencia) {
        this.tipo = servicioEmergencia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioEmergencia that = (ServicioEmergencia) o;
        return id.equals(that.id) &&
                tipo == that.tipo &&
                localidad.equals(that.localidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, localidad);
    }

    @Override
    public String toString() {
        return "ServicioEmergencia{" +
                "id=" + id +
                ", servicioEmergencia=" + tipo +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
