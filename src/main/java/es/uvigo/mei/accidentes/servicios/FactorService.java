package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Factor;
import es.uvigo.mei.accidentes.entidades.TipoFactor;

import java.util.List;

public interface FactorService {

    Factor crear(Factor factor);

    List<Factor> buscarTodos();
    Factor buscarPorId(Long id);
}
