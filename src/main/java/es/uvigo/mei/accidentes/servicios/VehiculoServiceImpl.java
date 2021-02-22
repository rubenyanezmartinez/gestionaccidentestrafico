package es.uvigo.mei.accidentes.servicios;


import es.uvigo.mei.accidentes.daos.VehiculoDAO;
import es.uvigo.mei.accidentes.entidades.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiculoServiceImpl  implements VehiculoService{

    @Autowired
    VehiculoDAO dao;

    @Override
    @Transactional
    public Vehiculo crear(Vehiculo vehiculo) {
        return this.dao.save(vehiculo);
    }

    @Override
    @Transactional
    public void eliminar(Vehiculo vehiculo) {
        this.dao.delete(vehiculo);
    }

    @Override
    @Transactional
    public void eliminarVehiculosDeConductor(String dni) {
        this.dao.deleteAllByConductor_Dni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> buscarTodosPorDniConductor(String dni) {
        return this.dao.findAllByConductorDni(dni);
    }

    @Override
    public Vehiculo buscarPorMatricula(String matricula) {
        return this.dao.findVehiculoByMatricula(matricula);
    }
}
