package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Factor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoFactor tipoFactor;

    @NotNull
    @Size(min=1, max=50, message = "La longitud del campo debe ser entre 1 y 50 caracteres")
    private String valor;

    public Factor () {

    }

    public Factor(Long id, TipoFactor tipoFactor, String valor) {
        this.setId(id);
        this.setTipoFactor(tipoFactor);
        this.setValor(valor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoFactor getTipoFactor() {
        return tipoFactor;
    }

    public void setTipoFactor(TipoFactor tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factor factor = (Factor) o;
        return id.equals(factor.id) &&
                tipoFactor.equals(factor.tipoFactor) &&
                valor.equals(factor.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoFactor, valor);
    }

    @Override
    public String toString() {
        return "Factor{" +
                "id=" + id +
                ", tipoFactor=" + tipoFactor +
                ", valor='" + valor + '\'' +
                '}';
    }
}
