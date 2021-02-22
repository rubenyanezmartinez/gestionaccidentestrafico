package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.daos.ServicioDeEmergenciaDAO;
import es.uvigo.mei.accidentes.entidades.ServicioEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioDeEmergenciaServiceImpl implements ServicioDeEmergenciaService{

    @Autowired
    ServicioDeEmergenciaDAO dao;

    @Override
    @Transactional
    public ServicioEmergencia crear(ServicioEmergencia servicioEmergencia) {
        return this.dao.save(servicioEmergencia);
    }

    @Override
    @Transactional
    public ServicioEmergencia modificar(ServicioEmergencia servicioEmergencia) {
        return this.dao.save(servicioEmergencia);
    }

    @Override
    @Transactional
    public void eliminar(ServicioEmergencia servicioEmergencia) {
        this.dao.delete(servicioEmergencia);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServicioEmergencia> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ServicioEmergencia buscarPorId(Long id) {
        return this.dao.findServicioEmergenciaById(id);
    }
}
