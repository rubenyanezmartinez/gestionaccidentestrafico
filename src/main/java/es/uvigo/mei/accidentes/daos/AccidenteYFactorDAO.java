package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Accidente;
import es.uvigo.mei.accidentes.entidades.AccidenteYFactor;
import es.uvigo.mei.accidentes.entidades.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidenteYFactorDAO extends JpaRepository<AccidenteYFactor, Long> {
    List<AccidenteYFactor> findAccidenteYFactorByAccidente_Id(Long id);
    AccidenteYFactor findAccidenteYFactorById (Long id);
    List<AccidenteYFactor> findAllByAccidente_Id (Long id);
    List<AccidenteYFactor> findAll();
    void deleteAllByAccidente_Id(Long id);
    void deleteAllByFactor_IdAndAccidente_Id(Long idFactor, Long idAccidente);
}
