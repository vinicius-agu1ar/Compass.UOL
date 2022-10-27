package Questao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

    public void adicionar(Produto produto){
		try {
		    String sql = "INSERT INTO produto (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());
			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1));
				}
			}
		}
		} catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}
    
    public void alterar(String nome, String descricao, Integer quantidade, Double preco, String nome2){
		try (PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE produto p SET p.nome = ?, p.descricao = ?, p.quantidade = ?, p.preco = ? WHERE nome = ?")) {
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, quantidade);
            preparedStatement.setDouble(4, preco);
			preparedStatement.setString(5, nome2);
			preparedStatement.execute();
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

    public void apagar(String nome) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE nome = ?")){
			preparedStatement.setString(1, nome);
			preparedStatement.execute();
	    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	public List<Produto> listar() {
		try{
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT id, nome, descricao, quantidade, preco from produto";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Produto produto =
                            new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDouble(5));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    	} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}