package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Accidente;

import java.util.List;

public interface AccidenteService {

    Accidente crear (Accidente accidente);
    Accidente modificar (Accidente accidente);
    void eliminar (Accidente accidente);

    List<Accidente> buscarPorDNIConductor(String dni);
    List<Accidente> buscarTodos();
    Accidente buscarPorId(Long id);
}
