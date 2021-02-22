package es.uvigo.mei.accidentes.entidades;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Conductor implements Serializable {
    @Id
    @Size(min=9, max=9, message = "La longitud del campo debe ser de 9 caracteres")
    private String dni;

    @NotNull
    @Size(min=1, max=50, message = "La longitud del campo debe ser entre 1 y 50 caracteres")
    private String nombre;

    @NotNull
    @Min(14)
    @Max(100)
    private Integer edad;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Genero genero = Genero.OTRO;

    public Conductor (){

    }

    public Conductor(String dni, String nombre, Integer edad, Genero genero) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setGenero(genero);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni){ this.dni = dni; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
}
