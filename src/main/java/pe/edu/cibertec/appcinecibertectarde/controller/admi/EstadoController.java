package pe.edu.cibertec.appcinecibertectarde.controller.admi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Estado;
import pe.edu.cibertec.appcinecibertectarde.repository.EstadoRepository;
import pe.edu.cibertec.appcinecibertectarde.response.ResultadoResponse;
import pe.edu.cibertec.appcinecibertectarde.service.EstadoService;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admi/estado")
public class EstadoController {
    private EstadoService estadoService;
    @GetMapping("/frmestado")

    public String frmestado(Model  model){
model.addAttribute("listaestados",estadoService.listarEstado());
        return "admi/frmestado";
    }
    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarEstado(@RequestBody Estado objestado){
        return estadoService.registrarEstado(objestado);
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Estado> listarEstados(){
        return estadoService.listarEstado();
    }
    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarEstado(@RequestBody Estado objEstado){
        return estadoService.eliminarEstado(objEstado.getIdestado());
    }
}
