package Questao3;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Simbolos simbolos = new Simbolos();
            System.out.print("Descreva aqui seu sentimento: ");
            String frase = scanner.nextLine();
                if(simbolos.contadorSimbolos(frase, ":-)") > simbolos.contadorSimbolos(frase, ":-(")){
                    System.out.println("Divertido.");
                } else if (simbolos.contadorSimbolos(frase, ":-(") > simbolos.contadorSimbolos(frase, ":-)")){
                    System.out.println("Chateado.");
                } else if (simbolos.contadorSimbolos(frase, ":-(") == simbolos.contadorSimbolos(frase, ":-)")){
                    System.out.println("Neutro.");
                }
        }
    }
}