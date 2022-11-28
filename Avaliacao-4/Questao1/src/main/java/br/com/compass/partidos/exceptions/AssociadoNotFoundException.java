package br.com.compass.partidos.exceptions;

import org.springframework.http.HttpStatus;

import br.com.compass.partidos.enums.ErrorCode;
import lombok.Getter;

@Getter
public class AssociadoNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    private final String details;
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public AssociadoNotFoundException() {
        super(ErrorCode.ASSOCIADO_NOT_FOUND.name());
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.errorCode = ErrorCode.ASSOCIADO_NOT_FOUND;
        this.details = ErrorCode.ASSOCIADO_NOT_FOUND.getMessage();
    }
}
