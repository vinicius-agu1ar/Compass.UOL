package Questao1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {
        
        Scanner scanner = new Scanner(System.in);
        while (true){

        System.out.println("Escolha no menu a opção 1 para cadastrar produtos");
        System.out.println("Escolha no menu a opção 2 para atualizar o primeiro produto cadastrado");
        System.out.println("Escolha no menu a opção 3 para excluir o segundo produto cadastrado");
        System.out.println("Escolha no menu a opção 0 finalizar a aplicação");
        System.out.print("NUMERO: ");
        int menu = scanner.nextInt();
        
            if (menu == 0) {
                System.out.println("Até logo!");
            break;
            }
            switch (menu) {
            case 1:
                Produto produto1 = new Produto("banana", "banana prata", 8, 16.10);
                Produto produto2 = new Produto("uva", "uva rubi", 12, 8.99);
                Produto produto3 = new Produto("maçã", "maçã verde", 4, 13.60);
                try (Connection connection = new ConnectionFactory().criarConexao()) {
                    ProdutoDAO produtoDao = new ProdutoDAO(connection);
                    System.out.println("Cadastrando produtos...");
                    produtoDao.adicionar(produto1);
                    produtoDao.adicionar(produto2);
                    produtoDao.adicionar(produto3);
                    List<Produto> listaProdutos = produtoDao.listar();
                    listaProdutos.stream().forEach(lp -> System.out.println(lp));
                }
                break;
            case 2:
                try (Connection connection = new ConnectionFactory().criarConexao()) {
                    ProdutoDAO produtoDao = new ProdutoDAO(connection);
                    System.out.println("Atualizando produto...");
                    produtoDao.alterar("banana", "banana da terra", 6, 14.29, "banana");
                    List<Produto> listaProdutos = produtoDao.listar();
                    listaProdutos.stream().forEach(lp -> System.out.println(lp));
                }
                break;
            case 3:
                try (Connection connection = new ConnectionFactory().criarConexao()) {
                    ProdutoDAO produtoDao = new ProdutoDAO(connection);
                    System.out.println("Excluindo produto...");
                    produtoDao.apagar("uva");
                    List<Produto> listaProdutos = produtoDao.listar();
                    listaProdutos.stream().forEach(lp -> System.out.println(lp));
                }
                break;
            default:
                System.out.println("Opção invalida");
                break;
            }
        }
    scanner.close();
    }
}
