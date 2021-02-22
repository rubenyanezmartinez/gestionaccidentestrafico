package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Vehiculo implements Serializable {
    @Id
    @Size(min=7, max=10, message = "La longitud del campo debe ser entre 7 y 10 caracteres")
    private String matricula;

    @NotNull
    @Size(min=1, max=50, message = "La longitud del campo debe ser entre 1 y 50 caracteres")
    private String tipo;

    @NotNull
    @Min(1900)
    @Max(9999)
    private Integer anho_matriculacion;

    @ManyToOne
    private Conductor conductor;

    public Vehiculo () {

    }

    public Vehiculo (String matricula, String tipo, Integer anho_matriculacion, Conductor conductor){
        this.setMatricula(matricula);
        this.setTipo(tipo);
        this.setAnho_matriculacion(anho_matriculacion);
        this.setConductor(conductor);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAnho_matriculacion() {
        return anho_matriculacion;
    }

    public void setAnho_matriculacion(Integer anho_matriculacion) {
        this.anho_matriculacion = anho_matriculacion;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return matricula.equals(vehiculo.matricula) &&
                tipo.equals(vehiculo.tipo) &&
                anho_matriculacion.equals(vehiculo.anho_matriculacion) &&
                conductor.equals(vehiculo.conductor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, tipo, anho_matriculacion, conductor);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", tipo='" + tipo + '\'' +
                ", anho_matriculacion=" + anho_matriculacion +
                ", conductor=" + conductor +
                '}';
    }
}
