package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Carretera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=50)
    private String nombre;

    @NotNull
    @Min(1)
    @Max(9999)
    private Integer kilometro;

    public Carretera (){

    }

    public Carretera(Long id, String nombre, Integer kilometro) {
        this.setId(id);
        this.setNombre(nombre);
        this.setKilometro(kilometro);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getKilometro() {
        return kilometro;
    }

    public void setKilometro(Integer kilometro) {
        this.kilometro = kilometro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carretera carretera = (Carretera) o;
        return id.equals(carretera.id) &&
                nombre.equals(carretera.nombre) &&
                kilometro.equals(carretera.kilometro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, kilometro);
    }

    @Override
    public String toString() {
        return "Carretera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", kilometro=" + kilometro +
                '}';
    }
}
