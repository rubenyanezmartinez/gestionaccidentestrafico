package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Conductor;
import es.uvigo.mei.accidentes.entidades.Vehiculo;

import java.util.List;

public interface VehiculoService {

    Vehiculo crear (Vehiculo vehiculo);
    void eliminar (Vehiculo vehiculo);
    void eliminarVehiculosDeConductor (String dni);

    List<Vehiculo> buscarTodosPorDniConductor(String dni);
    Vehiculo buscarPorMatricula(String matricula);
}
