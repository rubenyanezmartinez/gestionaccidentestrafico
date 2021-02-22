package es.uvigo.mei.accidentes.controladores;


import es.uvigo.mei.accidentes.entidades.AccidenteYServicioEmergencia;
import es.uvigo.mei.accidentes.entidades.ServicioEmergencia;
import es.uvigo.mei.accidentes.entidades.TipoServicioEmergencia;
import es.uvigo.mei.accidentes.servicios.AccidenteYServicioDeEmergenciaService;
import es.uvigo.mei.accidentes.servicios.ServicioDeEmergenciaService;
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
@RequestMapping("/serviciosemergencia")
public class ServicioDeEmergenciaController {

    @Autowired
    ServicioDeEmergenciaService servicioDeEmergenciaService;

    @Autowired
    AccidenteYServicioDeEmergenciaService accidenteYServicioDeEmergenciaService;


    @GetMapping
    public String prepararListarServiciosEmergencia (Model modelo){
        List<ServicioEmergencia> servicios = servicioDeEmergenciaService.buscarTodos();
        modelo.addAttribute("serviciosemergencia", servicios);
        return "serviciosemergencia/listado_servicios_emergencia";
    }

    @GetMapping("{id}/eliminar")
    public String borrarServicio(@PathVariable("id") Long id, Model modelo) {
        ServicioEmergencia servicio = servicioDeEmergenciaService.buscarPorId(id);
        if (servicio != null) {
            accidenteYServicioDeEmergenciaService.eliminarPorIdServicio(servicio.getId());
            
            servicioDeEmergenciaService.eliminar(servicio);
            return "redirect:/serviciosemergencia";
        } else {
            modelo.addAttribute("mensajeError", "Servicio de emergencia no encontrado");
            return "error";
        }
    }

    @GetMapping("nuevo")
    public ModelAndView prepararNuevoServicio() {
        ServicioEmergencia servicioEmergencia = new ServicioEmergencia();
        ModelAndView result = new ModelAndView();
        result.addObject("servicioEmergencia", servicioEmergencia);
        result.setViewName("serviciosemergencia/nuevo_servicio");
        return result;
    }

    @GetMapping("{id}/editar")
    public ModelAndView prepararEditarServicio(@PathVariable("id") Long id, Model modelo) {
        try {
            ServicioEmergencia servicio = servicioDeEmergenciaService.buscarPorId(id);
            ModelAndView result = new ModelAndView();
            result.addObject("servicioEmergencia", servicio);
            result.setViewName("serviciosemergencia/editar_servicio");
            return result;
        } catch (EntityNotFoundException e) {
            ModelAndView result = new ModelAndView();
            result.addObject("error", "Servicio de emergencia no encontrado");
            return result;
        }
    }

    @PostMapping
    public String anadirServicioEmergencia(@Valid @ModelAttribute ServicioEmergencia servicioEmergencia, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            servicioDeEmergenciaService.crear(servicioEmergencia);
            return "redirect:/serviciosemergencia";
        }
        else {
            return "serviciosemergencia/nuevo_servicio";
        }

    }

    @PostMapping("{id}/editar")
    public ModelAndView editarServicio(@Valid @ModelAttribute ServicioEmergencia servicioEmergencia, BindingResult resultado, @PathVariable("id") Long id) {
        if (!resultado.hasErrors()) {
            servicioDeEmergenciaService.modificar(servicioEmergencia);
            ModelAndView result = new ModelAndView();
            result.setViewName("redirect:/serviciosemergencia");
            return result;
        } else {
            ModelAndView result = new ModelAndView();
            result.addObject("servicioEmergencia", servicioEmergencia);
            result.setViewName("serviciosemergencia/editar_servicio");
            resultado.addError(new FieldError("servicio", "localidad", "Longitud incorrecta (de 2 a 50 caracteres)"));
            return result;
        }
    }
}
