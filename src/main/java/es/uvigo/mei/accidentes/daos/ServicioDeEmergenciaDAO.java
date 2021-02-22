package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.ServicioEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioDeEmergenciaDAO extends JpaRepository<ServicioEmergencia, Long> {
    ServicioEmergencia findServicioEmergenciaById (Long id);
    List<ServicioEmergencia> findAll();
}
