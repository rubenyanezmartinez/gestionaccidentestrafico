package es.uvigo.mei.accidentes.daos;

import es.uvigo.mei.accidentes.entidades.Conductor;
import es.uvigo.mei.accidentes.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoDAO extends JpaRepository<Vehiculo, String> {
    List<Vehiculo> findAllByConductorDni (String dni);
    Vehiculo findVehiculoByMatricula (String matricula);
    void deleteAllByConductor_Dni(String dni);
}
