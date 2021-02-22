package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactorDAO extends JpaRepository<Factor, Long> {
    List<Factor> findAll ();
    Factor findFactorById (Long id);
}
