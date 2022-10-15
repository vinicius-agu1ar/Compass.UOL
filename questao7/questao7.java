package questao7;

import java.time.LocalTime;
import java.util.Scanner;

public class questao7 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String[] login = {"fabiane.maciel", "diego.scacinate", "thais.nicodemus", "luara.oliveira", "guilherme.paiva", "alvaro.oliveira", "juliane.maran", "mateus.silveira", "andrey.coradin", "tulio.maia", "bruno.seixas", "jonatas.bezerra", "lucas.peixoto", "nalbert.santos", "rafael.queiroz", "david.gieseler", "giovani.lima", "joao.petter", "lenya.ferreira", "luis.gustavo", "michael.santos", "solano.kruger", "theodoro.ferreira", "tiago.dornelles", "vinicius.fuhrmann", "vinicius.aguiar"};
        int senha = 12345678;
        int hora = LocalTime.now().getHour();
        boolean respostaLogin = false;
        System.out.print("Insira o seu login: ");
        String loginUsuario = input.nextLine();
        System.out.print("Insira a sua senha: ");
        String senhaUsuario = input.nextLine();
        
        for(int i = 0; i < login.length; i++){

            if (login[i].equals(loginUsuario) && Integer.parseInt(senhaUsuario) == senha){
                if (6 <= hora && hora <= 11){
                    System.out.println("Bom dia, você se logou ao nosso sistema.");
                    respostaLogin = true;
                    break;
                } if (12 <= hora && hora <= 17){
                    System.out.println("Boa tarde, você se logou ao nosso sistema.");
                    respostaLogin = true;
                    break;
                } if (18 <= hora && hora <= 23){
                    System.out.println("Boa noite, você se logou ao nosso sistema.");
                    respostaLogin = true;
                    break;
                } if (0 <= hora && hora <= 5){
                    System.out.println("Boa madrugada, você se logou ao nosso sistema.");
                    respostaLogin = true;
                    break;
                }
            } 
        }
        if (respostaLogin == false){
            System.out.println("Usuário e/ou senha incorretos.");
        }
        input.close();

    }
}