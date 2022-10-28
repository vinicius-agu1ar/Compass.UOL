package Questao2;

public class Filme {
    
    private int id;
    private String nome;
    private String descricao;
    private int ano;

    public Filme(Integer id, String nome, String descricao, int ano){
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("O produto é: %d, %s, %s, %d", this.id, this.nome, this.descricao, this.ano);
    }
}
