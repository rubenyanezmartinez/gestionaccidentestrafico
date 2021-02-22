package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConductorDAO extends JpaRepository<Conductor, String> {
    Conductor findByDni (String dni);
    List<Conductor> findAll();
}
