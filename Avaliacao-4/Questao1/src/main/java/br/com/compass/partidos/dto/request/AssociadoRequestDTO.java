package br.com.compass.partidos.dto.request;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociadoRequestDTO {
    
    @NotBlank
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;

    @NotBlank @NotNull
    @JsonFormat (shape = Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;
    
    @NotBlank @NotNull
    private Sexo sexo;
}
