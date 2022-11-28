package br.com.compass.partidos.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociadoResponseParameters {
    
    private Integer numberOfElements;

    private Long totalElements;

    private Integer totalPages;

    private List<AssociadoResponseDTO> associado;
}
