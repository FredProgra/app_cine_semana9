package pe.edu.cibertec.appcinecibertectarde.controller.admi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appcinecibertectarde.repository.EstadoRepository;
import pe.edu.cibertec.appcinecibertectarde.service.EstadoService;

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
}
