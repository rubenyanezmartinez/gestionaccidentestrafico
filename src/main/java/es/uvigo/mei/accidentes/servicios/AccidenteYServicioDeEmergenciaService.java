package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.AccidenteYFactor;
import es.uvigo.mei.accidentes.entidades.AccidenteYServicioEmergencia;

import java.util.List;

public interface AccidenteYServicioDeEmergenciaService {

    AccidenteYServicioEmergencia crear (AccidenteYServicioEmergencia accidenteYServicioEmergencia);
    void eliminar (AccidenteYServicioEmergencia accidenteYServicioEmergencia);
    void eliminarPorIdAccidente (Long id);
    void eliminarPorIdServicio (Long id);
    void eliminarPorIdServicioYAccidente (Long idServicio, Long idAccidente);

    List<AccidenteYServicioEmergencia> buscarTodos();
    AccidenteYServicioEmergencia buscarPorId(Long id);
    List<AccidenteYServicioEmergencia> buscarPorIdAccidente(Long id);
}
