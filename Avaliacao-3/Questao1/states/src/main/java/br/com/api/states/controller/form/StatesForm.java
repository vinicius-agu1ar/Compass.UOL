package br.com.api.states.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.states.model.States;
import br.com.api.states.repository.StatesRepository;
import br.com.api.states.validator.Region;

public class StatesForm {
    @NotNull @NotEmpty
    private String nome;
    @Region @NotEmpty
    private String regiao;
    @NotNull
    private Double populacao;
    @NotNull @NotEmpty
    private String capital;
    @NotNull
    private Double area;

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public States converter(StatesRepository statesRepository) {
        return new States(nome, regiao, populacao, capital, area);
    }

    public States atualizar(Long id, StatesRepository statesRepository) {
        States states = statesRepository.getReferenceById(id);
        states.setArea(this.area);
        states.setCapital(this.capital);
        states.setNome(this.nome);
        states.setPopulacao(this.populacao);
        states.setRegiao(this.regiao);
        return states;
    }
}
