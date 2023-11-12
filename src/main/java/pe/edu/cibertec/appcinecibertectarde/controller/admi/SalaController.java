package pe.edu.cibertec.appcinecibertectarde.controller.admi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Sala;
import pe.edu.cibertec.appcinecibertectarde.model.dto.SalaDto;
import pe.edu.cibertec.appcinecibertectarde.response.ResultadoResponse;
import pe.edu.cibertec.appcinecibertectarde.service.SalaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admi/sala")
public class SalaController {
    private SalaService salaService;
    @GetMapping("/frmsala")
    public String frmsala(Model model){
        model.addAttribute("list",salaService.ListarSala());
        return "admi/frmsala";
    }
    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarSala(@RequestBody SalaDto salaDto){
        return salaService.guardarActualizaeSala(salaDto);
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Sala> listarSala(){
        return salaService.ListarSala();
    }
}
