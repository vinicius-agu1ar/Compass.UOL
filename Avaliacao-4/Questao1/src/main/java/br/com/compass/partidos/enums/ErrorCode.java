package br.com.compass.partidos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    
    PARTIDO_NOT_FOUND("Partido not found"),
    ASSOCIADO_NOT_FOUND("Associado not found"),
    BAD_REQUEST("Request invalid"),
    INVALID_PARAMETER("Invalid request parameter"),
    INTERNAL_SERVER_ERROR("Internal error has occurred.");

    private final String message;
}
