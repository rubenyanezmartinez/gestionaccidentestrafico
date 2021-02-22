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

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/accidentes")
public class AccidenteController {

    @Autowired
    AccidenteService accidenteService;

    @Autowired
    ConductorService conductorService;

    @Autowired
    CarreteraService carreteraService;

    @Autowired
    TipoFactorService tipoFactorService;

    @Autowired
    FactorService factorService;

    @Autowired
    AccidenteYFactorService accidenteYFactorService;

    @Autowired
    ServicioDeEmergenciaService servicioDeEmergenciaService;

    @Autowired
    AccidenteYServicioDeEmergenciaService accidenteYServicioDeEmergenciaService;

    @GetMapping
    public String prepararListarAccidentes (Model modelo){
        List<Accidente> accidentes = accidenteService.buscarTodos();
        modelo.addAttribute("accidentes", accidentes);
        return "accidentes/listado_accidentes";
    }

    @GetMapping("nuevo")
    public ModelAndView preparaNuevoAccidente(Model modelo) {
        List<Conductor> conductores = conductorService.buscarTodos();
        Accidente accidente = new Accidente();
        ModelAndView result = new ModelAndView();
        result.addObject("conductores", conductores);
        result.addObject("accidente", accidente);
        result.setViewName("accidentes/nuevo_accidente");
        return result;
    }

    @GetMapping("{id}/nuevoFactor")
    public ModelAndView preparaNuevoFactor (@PathVariable("id") Long id){
        List<TipoFactor> tiposFactores = tipoFactorService.buscarTodos();
        Accidente accidente = accidenteService.buscarPorId(id);
        Factor factor = new Factor();
        ModelAndView result = new ModelAndView();
        result.addObject("accidente", accidente);
        result.addObject("tiposFactores", tiposFactores);
        result.addObject("factor", factor);
        result.setViewName("accidentes/nuevo_factor");
        return result;
    }

    @GetMapping("{id}/eliminar")
    public String eliminarAccidente (@PathVariable("id") Long id, Model model){
        Accidente accidente = accidenteService.buscarPorId(id);
        if (accidente != null) {
            accidenteYFactorService.eliminarPorIdAccidente(accidente.getId());
            accidenteYServicioDeEmergenciaService.eliminarPorIdAccidente(accidente.getId());

            Carretera carretera = accidente.getCarretera();
            accidente.setCarretera(null);
            carreteraService.eliminar(carretera);

            accidenteService.modificar(accidente);
            accidenteService.eliminar(accidente);
            return "redirect:/accidentes";
        } else {
            model.addAttribute("mensajeError", "Accidente no encontrado");
            return "error";
        }
    }

    @GetMapping("{id}/editar")
    public ModelAndView prepararEditar (@PathVariable("id") Long id, Model model){
        ModelAndView result = new ModelAndView();

        Accidente accidente = accidenteService.buscarPorId(id);
        List<AccidenteYFactor> factores = accidenteYFactorService.buscarPorIdAccidente(accidente.getId());
        List<AccidenteYServicioEmergencia> servicios = accidenteYServicioDeEmergenciaService.buscarPorIdAccidente(accidente.getId());
        List<Conductor> conductores = conductorService.buscarTodos();

        result.addObject("conductores", conductores);
        result.addObject("accidente", accidente);
        result.addObject("factores", factores);
        result.addObject("servicios", servicios);
        result.setViewName("accidentes/editar_accidente");

        return result;
    }

    @GetMapping("{id}/detalle")
    public String preparaVistaDetalle (@PathVariable("id") Long id, Model model){
        Accidente accidente = accidenteService.buscarPorId(id);
        List<AccidenteYFactor> listaAccidenteYFactor = accidenteYFactorService.buscarTodos();
        List<Factor> factores = new ArrayList<>();
        for (AccidenteYFactor ayf : listaAccidenteYFactor){
            if(ayf.getAccidente().getId().equals(accidente.getId())){
                factores.add(ayf.getFactor());
            }
        }

        List<AccidenteYServicioEmergencia> listaAccidentesYServicios = accidenteYServicioDeEmergenciaService.buscarTodos();
        List<ServicioEmergencia> servicios = new ArrayList<>();
        for (AccidenteYServicioEmergencia ays : listaAccidentesYServicios){
            if(ays.getAccidente().getId().equals(accidente.getId())){
                servicios.add(ays.getServicioEmergencia());
            }
        }

        model.addAttribute("accidente", accidente);
        model.addAttribute("factores", factores);
        model.addAttribute("servicios", servicios);

        return "accidentes/ver_accidente";
    }

    @GetMapping("{id}/nuevoServicio")
    public String preparaNuevoServicio (@PathVariable("id") Long id, Model model){
        List<ServicioEmergencia> servicioEmergencias = servicioDeEmergenciaService.buscarTodos();
        Accidente accidente = accidenteService.buscarPorId(id);
        model.addAttribute("accidente", accidente);
        model.addAttribute("servicioEmergencias", servicioEmergencias);
        return "accidentes/nuevo_servicio";
    }

    @GetMapping("{idAccidente}/eliminarServicio/{idServicio}")
    public String eliminarServicioAccidente (@PathVariable("idAccidente") Long idAccidente, @PathVariable("idServicio") Long idServicio, Model model){

        accidenteYServicioDeEmergenciaService.eliminarPorIdServicioYAccidente(idServicio, idAccidente);

        return "redirect:/accidentes/"+Long.toString(idAccidente)+"/editar";
    }

    @GetMapping("{idAccidente}/eliminarFactor/{idFactor}")
    public String eliminarFactorAccidente (@PathVariable("idAccidente") Long idAccidente, @PathVariable("idFactor") Long idFactor, Model model){

        accidenteYFactorService.eliminarPorIdFactorYAccidente(idFactor, idAccidente);

        return "redirect:/accidentes/"+Long.toString(idAccidente)+"/editar";
    }

   @PostMapping
   public ModelAndView anadirAccidente(@Valid Accidente accidente, BindingResult resultado, @RequestParam Date fecha) {

        ModelAndView result = new ModelAndView();

        if (accidente.getCarretera().getNombre().length() < 1 || accidente.getCarretera().getNombre().length() > 50) {
            resultado.addError(new FieldError("accidente", "carretera.nombre", "La longitud del campo debe ser entre 1 y 50 caracteres"));
            result.setViewName("accidentes/nuevo_accidente");
            return result;
        }

        if (accidente.getCarretera().getKilometro() < 1 || accidente.getCarretera().getKilometro() > 9999) {
           resultado.addError(new FieldError("accidente", "carretera.kilometro", "El valor del campo debe estar entre 1 y 9999"));
           result.setViewName("accidentes/nuevo_accidente");
           return result;
        }


        Carretera carretera = new Carretera(null, accidente.getCarretera().getNombre(), accidente.getCarretera().getKilometro());
        carreteraService.crear(carretera);

        List<Carretera> listaCarreteras = carreteraService.buscarPorNombreYKm(accidente.getCarretera().getNombre(), accidente.getCarretera().getKilometro());
        accidente.setCarretera(listaCarreteras.get(listaCarreteras.size() - 1));
        accidente.setFecha(fecha);
        accidenteService.crear(accidente);

        result.setViewName("redirect:/accidentes");
        return result;
   }



    @PostMapping("{id}/editar")
    public String editarAccidente(@PathVariable("id") Long id, @Valid Accidente accidente) {

        Accidente a = accidenteService.buscarPorId(id);

        a.setGravedad(accidente.getGravedad());
        a.setManiobra(accidente.getManiobra());

        accidenteService.modificar(a);

        return "redirect:/accidentes";
    }

    @PostMapping("{id}/nuevoFactor")
    public ModelAndView anadirFactor (@PathVariable("id") Long id, @Valid @ModelAttribute Factor factor, BindingResult resultado){
        if(!resultado.hasErrors()){
            factorService.crear(factor);
            Accidente accidente = accidenteService.buscarPorId(id);
            AccidenteYFactor accidenteYFactor = new AccidenteYFactor(null, accidente, factor);
            accidenteYFactorService.crear(accidenteYFactor);
            ModelAndView result = new ModelAndView();
            result.setViewName("redirect:/accidentes");
            return result;
        }
        else{
            List<TipoFactor> tiposFactores = tipoFactorService.buscarTodos();
            Accidente accidente = accidenteService.buscarPorId(id);
            ModelAndView result = new ModelAndView();
            result.addObject("accidente", accidente);
            result.addObject("tiposFactores", tiposFactores);
            result.addObject("factor", factor);
            result.setViewName("accidentes/nuevo_factor");
            return result;
        }
    }

    @PostMapping("{id}/nuevoServicio")
    public String anadirServicio (@PathVariable("id") Long id, @RequestParam Long servicio, Model modelo){

        Accidente accidente = accidenteService.buscarPorId(id);
        ServicioEmergencia servicioEmergencia = servicioDeEmergenciaService.buscarPorId(servicio);

        AccidenteYServicioEmergencia accidenteYServicioEmergencia = new AccidenteYServicioEmergencia(null, accidente, servicioEmergencia);

        accidenteYServicioDeEmergenciaService.crear(accidenteYServicioEmergencia);

        return "redirect:/accidentes";
    }

}
