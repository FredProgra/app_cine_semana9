package pe.edu.cibertec.appcinecibertectarde.service;

import lombok.AllArgsConstructor;
import  java.util.List;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Estado;
import pe.edu.cibertec.appcinecibertectarde.repository.EstadoRepository;
import pe.edu.cibertec.appcinecibertectarde.response.ResultadoResponse;


@Service
@AllArgsConstructor
public class EstadoService {
    private EstadoRepository estadoRepository;
    public List<Estado> listarEstado(){
        return  estadoRepository.findAll();
    }
    public ResultadoResponse registrarEstado(Estado estado){
        String mensaje="Estado Registrado correctamente";
        Boolean respuesta=true;
        if (estado.getIdestado().equals(0)){estado.setIdestado(null);}
        try {
            estadoRepository.save(estado);
        }catch (Exception e){
            respuesta=false;
            mensaje="Estado NO registrado";
        }

        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
    public ResultadoResponse eliminarEstado(Integer idestado){
        String mensaje="Estado Eliminado Correctamente";
        Boolean respuesta=true;

        try {
            estadoRepository.deleteById(idestado);
        }catch (Exception e){
            respuesta=false;
            mensaje="Estado NO registrado";
        }

        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
