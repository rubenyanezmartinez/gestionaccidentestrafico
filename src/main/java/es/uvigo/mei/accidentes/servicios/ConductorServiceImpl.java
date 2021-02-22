package es.uvigo.mei.accidentes.servicios;


import es.uvigo.mei.accidentes.daos.ConductorDAO;
import es.uvigo.mei.accidentes.entidades.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    ConductorDAO dao;

    @Override
    @Transactional
    public Conductor crear(Conductor conductor) {
        return this.dao.save(conductor);
    }

    @Override
    @Transactional
    public Conductor modificar(Conductor conductor) {
        return this.dao.save(conductor);
    }

    @Override
    @Transactional
    public void eliminar(Conductor conductor) {
        this.dao.delete(conductor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conductor> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Conductor buscarPorDni(String dni) {
        return this.dao.findByDni(dni);
    }
}
