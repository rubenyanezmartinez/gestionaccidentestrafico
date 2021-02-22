package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.entidades.Accidente;
import es.uvigo.mei.accidentes.entidades.Carretera;

import java.util.List;

public interface CarreteraService {

    List<Carretera> buscarPorNombreYKm (String nombre, Integer km);
    Carretera crear (Carretera carretera);
    void eliminar (Carretera carretera);
}
