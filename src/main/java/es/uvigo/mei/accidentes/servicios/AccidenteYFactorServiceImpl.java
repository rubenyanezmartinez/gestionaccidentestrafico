package es.uvigo.mei.accidentes.servicios;


import es.uvigo.mei.accidentes.daos.AccidenteYFactorDAO;
import es.uvigo.mei.accidentes.entidades.Accidente;
import es.uvigo.mei.accidentes.entidades.AccidenteYFactor;
import es.uvigo.mei.accidentes.entidades.Factor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccidenteYFactorServiceImpl implements AccidenteYFactorService{

    @Autowired
    AccidenteYFactorDAO dao;

    @Override
    @Transactional
    public AccidenteYFactor crear(AccidenteYFactor accidenteYFactor) {
        return this.dao.save(accidenteYFactor);
    }

    @Override
    @Transactional
    public void eliminar (AccidenteYFactor accidenteYFactor){
        this.dao.delete(accidenteYFactor);
    }

    @Override
    @Transactional
    public void eliminarPorIdAccidente(Long id) {
        this.dao.deleteAllByAccidente_Id(id);
    }

    @Override
    @Transactional
    public void eliminarPorIdFactorYAccidente(Long idFactor, Long idAccidente) {
        this.dao.deleteAllByFactor_IdAndAccidente_Id(idFactor, idAccidente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccidenteYFactor> buscarPorIdAccidente(Long id) {
        return this.dao.findAllByAccidente_Id(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccidenteYFactor> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AccidenteYFactor buscarPorId(Long id) {
        return this.dao.findAccidenteYFactorById(id);
    }
}
