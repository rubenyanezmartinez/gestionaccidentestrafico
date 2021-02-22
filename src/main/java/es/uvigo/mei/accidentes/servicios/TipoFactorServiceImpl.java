package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.daos.TipoFactorDAO;
import es.uvigo.mei.accidentes.entidades.TipoFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoFactorServiceImpl implements TipoFactorService{

    @Autowired
    TipoFactorDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoFactor> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoFactor buscarPorId(Long id) {
        return dao.findTipoFactorById(id);
    }
}
