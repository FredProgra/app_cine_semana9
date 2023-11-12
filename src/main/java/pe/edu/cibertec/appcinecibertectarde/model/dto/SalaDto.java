package pe.edu.cibertec.appcinecibertectarde.model.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class SalaDto {
    private Integer idsala;
    private  String descsala;
    private  Integer asientos;
    private Integer idestado;
}
