package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Accidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoManiobra maniobra = TipoManiobra.OTRO;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoGravedad gravedad = TipoGravedad.LEVE;

    @ManyToOne
    private Conductor conductor;

    @ManyToOne
    private Carretera carretera;

    public Accidente(){

    }

    public Accidente(Long id, TipoManiobra maniobra, Date fecha, TipoGravedad gravedad, Conductor conductor, Carretera carretera) {
        this.setId(id);
        this.setManiobra(maniobra);
        this.setFecha(fecha);
        this.setGravedad(gravedad);
        this.setConductor(conductor);
        this.setCarretera(carretera);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public TipoManiobra getManiobra() {
        return maniobra;
    }

    public void setManiobra(TipoManiobra maniobra) {
        this.maniobra = maniobra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoGravedad getGravedad() {
        return gravedad;
    }

    public void setGravedad(TipoGravedad gravedad) {
        this.gravedad = gravedad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Carretera getCarretera() {
        return carretera;
    }

    public void setCarretera(Carretera carretera) {
        this.carretera = carretera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accidente accidente = (Accidente) o;
        return id.equals(accidente.id) &&
                maniobra == accidente.maniobra &&
                fecha.equals(accidente.fecha) &&
                gravedad == accidente.gravedad &&
                conductor.equals(accidente.conductor) &&
                carretera.equals(accidente.carretera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maniobra, fecha, gravedad, conductor, carretera);
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "id=" + id +
                ", maniobra=" + maniobra +
                ", fecha=" + fecha +
                ", gravedad=" + gravedad +
                ", conductor=" + conductor +
                ", carretera=" + carretera +
                '}';
    }
}
