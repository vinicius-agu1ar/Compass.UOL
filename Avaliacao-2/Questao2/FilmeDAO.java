package Questao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private Connection connection;

	public FilmeDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Filme> paginacao(Integer pagina, Integer quantidade) {
		try{
			List<Filme> filme = new ArrayList<Filme>();

			try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from filme LIMIT ?, ?")){
				preparedStatement.setInt(1, pagina);
				preparedStatement.setInt(2, quantidade);
				preparedStatement.execute();

				try(ResultSet resultSet = preparedStatement.executeQuery();){
					while(resultSet.next()){
						Filme filmes =
								new Filme(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
						filme.add(filmes);
					}
				}
			}
		return filme;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}