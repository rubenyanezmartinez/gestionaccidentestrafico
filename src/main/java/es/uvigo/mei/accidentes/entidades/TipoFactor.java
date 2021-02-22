package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TipoFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=50)
    private String nombre;

    public TipoFactor () {

    }
    public TipoFactor(Long id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoFactor that = (TipoFactor) o;
        return id.equals(that.id) &&
                nombre == that.nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "TipoFactor{" +
                "id=" + id +
                ", nombre=" + nombre +
                '}';
    }
}
