package Questao2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Quantos filmes você deseja ver ");
            int numeroFilmes = scanner.nextInt();
            System.out.print("A partir de qual pagina? ");
            int numeroPaginas = scanner.nextInt();
            numeroPaginas--;

            try (Connection connection = new ConnectionFactory().criarConexao()) {
                FilmeDAO filmeDao = new FilmeDAO(connection);
                List<Filme> listaProdutos = filmeDao.paginacao(numeroPaginas, numeroFilmes);
                listaProdutos.stream().forEach(lp -> System.out.println(lp));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
