package es.uvigo.mei.accidentes.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AccidenteYFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Accidente accidente;

    @ManyToOne
    private Factor factor;

    public AccidenteYFactor () {

    }

    public AccidenteYFactor(Long id, Accidente accidente, Factor factor) {
        this.setId(id);
        this.setAccidente(accidente);
        this.setFactor(factor);
    }

    public Accidente getAccidente() {
        return accidente;
    }

    public void setAccidente(Accidente accidente) {
        this.accidente = accidente;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidenteYFactor that = (AccidenteYFactor) o;
        return id.equals(that.id) &&
                accidente.equals(that.accidente) &&
                factor.equals(that.factor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accidente, factor);
    }

    @Override
    public String toString() {
        return "AccidenteYFactor{" +
                "id=" + id +
                ", accidente=" + accidente +
                ", factor=" + factor +
                '}';
    }
}
