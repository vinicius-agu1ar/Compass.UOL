package br.com.compass.partidos.dto.response;

import java.time.LocalDateTime;

import br.com.compass.partidos.enums.Ideologia;
import lombok.Data;

@Data
public class PartidoResponseDTO {

    private Long id;

    private String nome;

    private String sigla;

    private Ideologia ideologia;

    private LocalDateTime dataFundacao;
}
