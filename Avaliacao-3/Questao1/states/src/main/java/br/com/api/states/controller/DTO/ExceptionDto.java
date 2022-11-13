package br.com.api.states.controller.DTO;

public class ExceptionDto {

    private String campo;
    private String erro;

    public ExceptionDto(String campo, String erro){

        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
