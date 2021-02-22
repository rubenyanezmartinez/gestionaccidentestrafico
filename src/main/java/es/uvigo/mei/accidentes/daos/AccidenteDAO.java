package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Accidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidenteDAO extends JpaRepository<Accidente, Long> {
    List<Accidente> findAccidenteByConductor_Dni(String dni);
    Accidente findAccidenteById (Long id);
    List<Accidente> findAll();
}
