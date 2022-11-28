package br.com.compass.partidos.dto.response;

import java.time.LocalDate;

import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.enums.Sexo;
import lombok.Data;

@Data
public class AssociadoResponseDTO {
    
    private Long id;

    private String nome;

    private CargoPolitico cargoPolitico;

    private LocalDate dataNascimento;
    
    private Sexo sexo;
}
