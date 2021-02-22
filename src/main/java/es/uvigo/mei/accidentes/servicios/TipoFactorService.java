package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.TipoFactor;

import java.util.List;

public interface TipoFactorService {

    List<TipoFactor> buscarTodos();
    TipoFactor buscarPorId(Long id);
}
