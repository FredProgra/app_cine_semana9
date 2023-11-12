package pe.edu.cibertec.appcinecibertectarde.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Estado;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Sala;
import pe.edu.cibertec.appcinecibertectarde.model.dto.SalaDto;
import pe.edu.cibertec.appcinecibertectarde.repository.SalaRepository;
import pe.edu.cibertec.appcinecibertectarde.response.ResultadoResponse;

import java.util.List;
@Repository
@Service
@AllArgsConstructor
public class SalaService {
    private SalaRepository salaRepository;
    public List<Sala> ListarSala(){
        return salaRepository.findAll();
    }
    public ResultadoResponse guardarActualizaeSala(SalaDto salaDto){
        String mensaje="Sala Registrada Correcto";
        boolean respuesta=true;
        try {
            Sala nuevsala=new Sala();
            if (salaDto.getIdsala()>0){  nuevsala.setIdsala(salaDto.getIdsala());}
            nuevsala.setDescsala(salaDto.getDescsala());
            nuevsala.setAsientos(salaDto.getAsientos());
            Estado estado=new Estado();
            estado.setIdestado(salaDto.getIdestado());
            salaRepository.save(nuevsala);

        }catch (Exception e){
            respuesta=false;
            mensaje="Estado NO registrado";
        }

        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
