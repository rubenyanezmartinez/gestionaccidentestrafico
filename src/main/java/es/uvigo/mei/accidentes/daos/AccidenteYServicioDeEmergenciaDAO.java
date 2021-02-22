package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.AccidenteYServicioEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidenteYServicioDeEmergenciaDAO extends JpaRepository<AccidenteYServicioEmergencia, Long> {
    AccidenteYServicioEmergencia findAccidenteYServicioEmergenciaById (Long id);
    List<AccidenteYServicioEmergencia> findAll();
    List<AccidenteYServicioEmergencia> findAccidenteYServicioEmergenciaByAccidente_Id(Long id);
    List<AccidenteYServicioEmergencia> findAllByAccidente_Id (Long id);
    void deleteAllByAccidente_Id (Long id);
    void deleteAllByServicioEmergencia_Id (Long id);
    void deleteAllByServicioEmergencia_IdAndAccidente_Id (Long idServicio, Long idAccidente);
}