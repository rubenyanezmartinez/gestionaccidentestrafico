package es.uvigo.mei.accidentes.servicios;

import es.uvigo.mei.accidentes.daos.AccidenteDAO;
import es.uvigo.mei.accidentes.entidades.Accidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccidenteServiceImpl implements AccidenteService{

    @Autowired
    AccidenteDAO dao;

    @Override
    @Transactional
    public Accidente crear(Accidente accidente) {
        return this.dao.save(accidente);
    }

    @Override
    @Transactional
    public Accidente modificar(Accidente accidente) {
        return this.dao.save(accidente);
    }

    @Override
    @Transactional
    public void eliminar(Accidente accidente) {
        this.dao.delete(accidente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Accidente> buscarPorDNIConductor(String dni) {
        return this.dao.findAccidenteByConductor_Dni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Accidente> buscarTodos() {
        return this.dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Accidente buscarPorId(Long id) {
        return this.dao.findAccidenteById(id);
    }
}
