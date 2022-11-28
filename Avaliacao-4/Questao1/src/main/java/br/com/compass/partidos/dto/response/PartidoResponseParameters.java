package br.com.compass.partidos.dto.response;

import java.util.List;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoResponseParameters {

    private Integer numberOfElements;

    private Long totalElements;

    private Integer totalPages;

    private List<PartidoResponseDTO> partido;
}
