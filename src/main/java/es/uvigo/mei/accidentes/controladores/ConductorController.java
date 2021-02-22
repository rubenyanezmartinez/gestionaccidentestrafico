package es.uvigo.mei.accidentes.controladores;

import es.uvigo.mei.accidentes.entidades.*;
import es.uvigo.mei.accidentes.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/conductores")
public class ConductorController {

    @Autowired
    ConductorService conductorService;

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    AccidenteService accidenteService;

    @Autowired
    CarreteraService carreteraService;

    @Autowired
    AccidenteYFactorService accidenteYFactorService;

    @Autowired
    AccidenteYServicioDeEmergenciaService accidenteYServicioDeEmergenciaService;

    @GetMapping
    public String prepararListarConductores (Model modelo){
        List<Conductor> conductores = conductorService.buscarTodos();
        modelo.addAttribute("conductores", conductores);
        return "conductores/listado_conductores";
    }

    @GetMapping("nuevo")
    public ModelAndView prepararNuevoConductor() {
        Conductor conductor = new Conductor();
        ModelAndView result = new ModelAndView();
        result.addObject("conductor", conductor);
        result.setViewName("conductores/nuevo_conductor");
        return result;
    }

    @GetMapping("{dni}/editar")
    public ModelAndView  prepararEditarServicio(@PathVariable("dni") String dni, Model modelo) {
        try {
            Conductor conductor = conductorService.buscarPorDni(dni);
            ModelAndView result = new ModelAndView();
            result.addObject("conductor", conductor);
            result.setViewName("conductores/editar_conductor");
            return result;
        } catch (EntityNotFoundException e) {
            ModelAndView result = new ModelAndView();
            result.addObject("error", "Conductor no encontrado");
            result.setViewName("error");
            return result;
        }
    }

    @PostMapping
    public String anadirArticuloAlmacen(@Valid @ModelAttribute Conductor conductor, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            conductorService.crear(conductor);
            return "redirect:/conductores";
        }
        else {
            return "conductores/nuevo_conductor";
        }
    }

    @GetMapping("{dni}/eliminar")
    public String borrarConductor (@PathVariable("dni") String dni, Model modelo) {
        Conductor conductor = conductorService.buscarPorDni(dni);
        if (conductor != null) {
            vehiculoService.eliminarVehiculosDeConductor(dni);

            List<Accidente> accidentes = accidenteService.buscarPorDNIConductor(dni);
            for(Accidente accidente : accidentes){

                accidenteYFactorService.eliminarPorIdAccidente(accidente.getId());
                accidenteYServicioDeEmergenciaService.eliminarPorIdAccidente(accidente.getId());

                Carretera carretera = accidente.getCarretera();
                accidente.setCarretera(null);
                carreteraService.eliminar(carretera);

                accidenteService.modificar(accidente);
                accidenteService.eliminar(accidente);
            }

            conductorService.eliminar(conductor);
            return "redirect:/conductores";
        } else {
            modelo.addAttribute("mensajeError", "Conductor no encontrado");
            return "error";
        }
    }

    @PostMapping("editar/{dni}")
    public ModelAndView editarConductor (@Valid @ModelAttribute Conductor conductor, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            conductorService.modificar(conductor);
            ModelAndView result = new ModelAndView();
            result.setViewName("redirect:/conductores");
            return result;
        } else {
            ModelAndView result = new ModelAndView();
            result.addObject("conductor", conductor);
            result.setViewName("conductores/editar_conductor");
            List<FieldError> listaDeErrores = resultado.getFieldErrors();
            for (FieldError error : listaDeErrores){
                resultado.addError(error);
            }
            return result;
        }
    }
}
