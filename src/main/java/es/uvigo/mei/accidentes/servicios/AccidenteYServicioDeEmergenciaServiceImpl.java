package es.uvigo.mei.accidentes.servicios;


import es.uvigo.mei.accidentes.daos.AccidenteYServicioDeEmergenciaDAO;
import es.uvigo.mei.accidentes.entidades.AccidenteYServicioEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccidenteYServicioDeEmergenciaServiceImpl implements AccidenteYServicioDeEmergenciaService{

    @Autowired
    AccidenteYServicioDeEmergenciaDAO dao;

    @Override
    @Transactional
    public AccidenteYServicioEmergencia crear(AccidenteYServicioEmergencia accidenteYServicioEmergencia) {
        return this.dao.save(accidenteYServicioEmergencia);
    }

    @Override
    @Transactional
    public void eliminar (AccidenteYServicioEmergencia accidenteYServicioEmergencia){
        this.dao.delete(accidenteYServicioEmergencia);
    }

    @Override
    @Transactional
    public void eliminarPorIdAccidente(Long id) {
        this.dao.deleteAllByAccidente_Id(id);
    }

    @Override
    @Transactional
    public void eliminarPorIdServicio(Long id) {
        this.dao.deleteAllByServicioEmergencia_Id(id);
    }

    @Override
    @Transactional
    public void eliminarPorIdServicioYAccidente(Long idServicio, Long idAccidente) {
        this.dao.deleteAllByServicioEmergencia_IdAndAccidente_Id(idServicio, idAccidente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccidenteYServicioEmergencia> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AccidenteYServicioEmergencia buscarPorId(Long id) {
        return this.dao.findAccidenteYServicioEmergenciaById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccidenteYServicioEmergencia> buscarPorIdAccidente(Long id) {
        return this.dao.findAllByAccidente_Id(id);
    }
}
