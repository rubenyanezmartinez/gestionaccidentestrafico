package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.daos.CarreteraDAO;
import es.uvigo.mei.accidentes.entidades.Carretera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarreteraServiceImpl implements CarreteraService{

    @Autowired
    CarreteraDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Carretera> buscarPorNombreYKm(String nombre, Integer km) {
        return this.dao.findAllByNombreAndKilometro(nombre, km);
    }

    @Override
    @Transactional
    public Carretera crear(Carretera carretera) {
        return this.dao.save(carretera);
    }

    @Override
    @Transactional
    public void eliminar(Carretera carretera) {
        this.dao.delete(carretera);
    }
}
