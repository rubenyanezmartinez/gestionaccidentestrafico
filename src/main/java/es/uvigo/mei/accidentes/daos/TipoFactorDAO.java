package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.TipoFactor;
import es.uvigo.mei.accidentes.entidades.TipoGravedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoFactorDAO extends JpaRepository<TipoFactor, Long> {
    List<TipoFactor> findAll ();
    TipoFactor findTipoFactorById (Long id);
}
