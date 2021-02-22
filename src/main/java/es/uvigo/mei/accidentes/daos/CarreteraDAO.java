package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Carretera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreteraDAO extends JpaRepository<Carretera, Long> {
    List<Carretera> findAll();
    Carretera findCarreteraById (Long id);
    List<Carretera> findAllByNombreAndKilometro(String nombre, Integer kilometro);
}
