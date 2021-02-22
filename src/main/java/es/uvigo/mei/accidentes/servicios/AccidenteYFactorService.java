package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Accidente;
import es.uvigo.mei.accidentes.entidades.AccidenteYFactor;
import es.uvigo.mei.accidentes.entidades.Factor;

import java.util.List;

public interface AccidenteYFactorService {

    AccidenteYFactor crear (AccidenteYFactor accidenteYFactor);
    void eliminar (AccidenteYFactor accidenteYFactor);
    void eliminarPorIdAccidente (Long id);
    void eliminarPorIdFactorYAccidente(Long idFactor, Long idAccidente);

    List<AccidenteYFactor> buscarPorIdAccidente(Long id);
    List<AccidenteYFactor> buscarTodos();
    AccidenteYFactor buscarPorId(Long id);
}
