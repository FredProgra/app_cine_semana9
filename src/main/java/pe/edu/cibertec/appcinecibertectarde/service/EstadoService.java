package pe.edu.cibertec.appcinecibertectarde.service;

import lombok.AllArgsConstructor;
import  java.util.List;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.appcinecibertectarde.model.bd.Estado;
import pe.edu.cibertec.appcinecibertectarde.repository.EstadoRepository;


@Service
@AllArgsConstructor
public class EstadoService {
    private EstadoRepository estadoRepository;
    public List<Estado> listarEstado(){
        return  estadoRepository.findAll();
    }
    public  boolean registrarEstado(Estado estado){
        return estadoRepository.save(estado)!=null;
    }
    public  void eliminar(Integer idestado){
        estadoRepository.deleteById(idestado);
    }

}
