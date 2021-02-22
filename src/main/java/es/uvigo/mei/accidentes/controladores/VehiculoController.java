package es.uvigo.mei.accidentes.controladores;


import es.uvigo.mei.accidentes.entidades.Conductor;
import es.uvigo.mei.accidentes.entidades.Vehiculo;
import es.uvigo.mei.accidentes.servicios.ConductorService;
import es.uvigo.mei.accidentes.servicios.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    ConductorService conductorService;

    @GetMapping("listado/{dni}")
    public String prepararListadoVehiculos (Model modelo, @PathVariable("dni") String dni){
        List<Vehiculo> vehiculos = vehiculoService.buscarTodosPorDniConductor(dni);
        Conductor conductor = conductorService.buscarPorDni(dni);
        modelo.addAttribute("vehiculos", vehiculos);
        modelo.addAttribute("conductor", conductor);
        return "vehiculos/listado_vehiculos";
    }

    @GetMapping("nuevo/{dni}")
    public ModelAndView prepararNuevoConductor(Model modelo, @PathVariable("dni") String dni) {
        Conductor conductor = conductorService.buscarPorDni(dni);
        Vehiculo vehiculo = new Vehiculo();
        ModelAndView result = new ModelAndView();
        result.addObject("vehiculo", vehiculo);
        result.addObject("conductor", conductor);
        result.setViewName("vehiculos/nuevo_vehiculo");
        return result;
    }

    @PostMapping("{dni}")
    public ModelAndView anadirArticuloAlmacen(@PathVariable("dni") String dni, @Valid @ModelAttribute Vehiculo vehiculo, BindingResult resultado) {
        Conductor conductor = conductorService.buscarPorDni(dni);
        if(!resultado.hasErrors()){
            vehiculo.setConductor(conductor);
            vehiculoService.crear(vehiculo);

            List<Vehiculo> vehiculos = vehiculoService.buscarTodosPorDniConductor(dni);

            ModelAndView result = new ModelAndView();
            result.addObject("vehiculos", vehiculos);
            result.addObject("conductor", conductor);
            result.setViewName("vehiculos/listado_vehiculos");
            return result;
        }
        else{
            ModelAndView result = new ModelAndView();
            result.addObject("vehiculo", vehiculo);
            result.addObject("conductor", conductor);
            result.setViewName("vehiculos/nuevo_vehiculo");
            result.setViewName("vehiculos/nuevo_vehiculo");
            return result;
        }
    }

    @GetMapping("{dni}/eliminar/{matricula}")
    public String borrarConductor (@PathVariable("dni") String dni, @PathVariable("matricula") String matricula, Model modelo) {
        Vehiculo vehiculo = vehiculoService.buscarPorMatricula(matricula);
        if (vehiculo != null) {
            vehiculoService.eliminar(vehiculo);

            Conductor conductor = conductorService.buscarPorDni(dni);
            List<Vehiculo> vehiculos = vehiculoService.buscarTodosPorDniConductor(dni);
            modelo.addAttribute("vehiculos", vehiculos);
            modelo.addAttribute("conductor", conductor);
            return "vehiculos/listado_vehiculos";
        } else {
            modelo.addAttribute("mensajeError", "Vehículo no encontrado");
            return "error";
        }
    }
}
