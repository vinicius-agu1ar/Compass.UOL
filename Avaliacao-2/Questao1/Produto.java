package Questao1;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private double preco;

    public Produto(Integer id, String nome, String descricao, Integer quantidade, Double preco){
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(String nome, String descricao, Integer quantidade, Double preco){
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("O produto é: %d, %s, %s, %d, %.2f", this.id, this.nome, this.descricao, this.quantidade, this.preco);
    }
}   