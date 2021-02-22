package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Conductor;
import es.uvigo.mei.accidentes.entidades.ServicioEmergencia;

import java.util.List;

public interface ConductorService {
    Conductor crear (Conductor conductor);
    Conductor modificar (Conductor conductor);
    void eliminar (Conductor conductor);

    List<Conductor> buscarTodos();
    Conductor buscarPorDni(String dni);
}
