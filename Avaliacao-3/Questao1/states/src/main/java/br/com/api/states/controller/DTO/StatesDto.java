package br.com.api.states.controller.DTO;

import org.springframework.data.domain.Page;

import br.com.api.states.model.States;

public class StatesDto {
    
    private Long id;
    private String nome;
    private String regiao;
    private Double populacao;
    private String capital;
    private Double area;

    public StatesDto(States states){
        this.id = states.getId();
        this.nome = states.getNome();
        this.regiao = states.getRegiao();
        this.populacao = states.getPopulacao();
        this.capital = states.getCapital();
        this.area = states.getArea();
    }

    public Double getArea() {
        return area;
    }
    
    public String getCapital() {
        return capital;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public String getRegiao() {
        return regiao;
    }

    public static Page<StatesDto> converter(Page<States> states) {
        return states.map(StatesDto:: new);
    }
}
