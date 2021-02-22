package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.ServicioEmergencia;

import java.util.List;

public interface ServicioDeEmergenciaService {

    ServicioEmergencia crear (ServicioEmergencia servicioEmergencia);
    ServicioEmergencia modificar (ServicioEmergencia servicioEmergencia);
    void eliminar (ServicioEmergencia servicioEmergencia);

    List<ServicioEmergencia> buscarTodos();
    ServicioEmergencia buscarPorId(Long id);
}
