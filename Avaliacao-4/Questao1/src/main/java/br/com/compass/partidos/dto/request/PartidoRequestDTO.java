package br.com.compass.partidos.dto.request;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.compass.partidos.enums.Ideologia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String sigla;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    @NotNull
    @JsonFormat (shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataFundacao;
}
