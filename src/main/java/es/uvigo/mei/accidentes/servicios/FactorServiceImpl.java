package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.daos.FactorDAO;
import es.uvigo.mei.accidentes.entidades.Factor;
import es.uvigo.mei.accidentes.entidades.TipoFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FactorServiceImpl implements FactorService{

    @Autowired
    FactorDAO dao;

    @Override
    @Transactional
    public Factor crear(Factor factor) {
        return this.dao.save(factor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factor> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factor buscarPorId(Long id) {
        return this.dao.findFactorById(id);
    }
}
