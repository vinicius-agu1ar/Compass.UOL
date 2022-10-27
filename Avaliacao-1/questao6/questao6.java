import java.util.Scanner;

public class questao6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] perguntas = {"Qual é o valor do fatorial de 5 (5!)", "Em que tempo verbal está a palavra incumbi?", "Em qual desses países fica a cidade de Dusseldorf?", "Qual o numero atômico do elemento quimico Bismuto?", "Em que ano aconteceu a revolta dos Malês?"};
        int[] respostas = {4, 1, 3, 3, 5};
        int i = 0;
        int certo = 0;
        int errado = 0;

        System.out.print("Insira o nome do seu usuario: ");
        String nome = input.nextLine();
        System.out.println("Responda as questões abaixo com um numero de 1 a 5 que corresponde a alternativa correta");
        while(i < perguntas.length){
            System.out.println(perguntas[0]);
            System.out.println("[1]  50");
            System.out.println("[2]  25");
            System.out.println("[3]  125");
            System.out.println("[4]  120");
            System.out.println("[5]  100");
            System.out.print("Resposta: ");
            int alternativa = input.nextInt();
            if (alternativa == respostas[0]){
                System.out.println("Você acertou!"); 
                i++;
                certo++;
            } else {
                System.out.println("Você errou! "); 
                i++;
                errado++;
                }
            System.out.println(perguntas[1]);
            System.out.println("[1]  Pretérito perfeito");
            System.out.println("[2]  Pretérito mais-que-perfeito");
            System.out.println("[3]  Pretérito imperfeito");
            System.out.println("[4]  Futuro do pretérito");
            System.out.println("[5]  Infinitivo");
            System.out.print("Resposta: ");
            alternativa = input.nextInt();
            if (alternativa == respostas[1]){
                System.out.println("Você acertou!"); 
                i++;
                certo++;
            } else {
                System.out.println("Você errou! "); 
                i++;
                errado++;
                }
            System.out.println(perguntas[2]);
            System.out.println("[1]  Bélgica");
            System.out.println("[2]  Holanda");
            System.out.println("[3]  Alemanha");
            System.out.println("[4]  Suiça");
            System.out.println("[5]  Russia");
            System.out.print("Resposta: ");
                alternativa = input.nextInt();
                if (alternativa == respostas[2]){
                    System.out.println("Você acertou!"); 
                    i++;
                    certo++;
                } else {
                    System.out.println("Você errou! "); 
                    i++;
                    errado++;
                    }
            System.out.println(perguntas[3]);
            System.out.println("[1]  38");
            System.out.println("[2]  208");
            System.out.println("[3]  83");
            System.out.println("[4]  218");
            System.out.println("[5]  118");
            System.out.print("Resposta: ");
            alternativa = input.nextInt();
            if (alternativa == respostas[3]){
                System.out.println("Você acertou!"); 
                i++;
                certo++;
            } else {
                System.out.println("Você errou! "); 
                i++;
                errado++;
                }
            System.out.println(perguntas[4]);
            System.out.println("[1]  1838");
            System.out.println("[2]  2018");
            System.out.println("[3]  1883");
            System.out.println("[4]  1815");
            System.out.println("[5]  1835");
            System.out.print("Resposta: ");
                alternativa = input.nextInt();
                if (alternativa == respostas[4]){
                    System.out.println("Você acertou!"); 
                    i++;
                    certo++;
                } else {
                    System.out.println("Você errou! "); 
                    i++;
                    errado++;
                    }                
        
        }
        System.out.println(" ");
        System.out.println("Usuario: " + nome);
        System.out.println("Acertos: " + certo);
        System.out.println("Erros: " + errado);
        input.close();

    }
}
