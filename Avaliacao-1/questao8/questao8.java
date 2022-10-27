package questao8;

import java.util.ArrayList;
import java.util.Scanner;

public class questao8 {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Quantos funcionarios serão cadastrados? ");
        String numeroFuncionarios = input.nextLine();
        int i = 0;
        ArrayList<String> nomes = new ArrayList<String>();
        ArrayList<String> salario = new ArrayList<String>();
        ArrayList<Double> bonus = new ArrayList<Double>();
        ArrayList<Double> salarioLiquido = new ArrayList<Double>();


        while(i < Integer.parseInt(numeroFuncionarios)){
            System.out.println("Qual o nome do funcionario? ");
            nomes.add(input.nextLine());
            System.out.println("Qual o salario do funcionario? ");
            salario.add(input.nextLine());
            
            if (Double.parseDouble(salario.get(i)) > 0.0 && Double.parseDouble(salario.get(i)) < 1000.0){
                bonus.add(Double.parseDouble(salario.get(i)) * 0.2);
                salarioLiquido.add(Double.parseDouble(salario.get(i)) + bonus.get(i));
            }   if (Double.parseDouble(salario.get(i)) >= 1000.0 && Double.parseDouble(salario.get(i)) < 2000.0){
                    bonus.add(Double.parseDouble(salario.get(i)) * 0.1);
                    salarioLiquido.add(Double.parseDouble(salario.get(i)) + bonus.get(i));
                }   if (Double.parseDouble(salario.get(i)) >= 2000.0){
                        bonus.add(Double.parseDouble(salario.get(i)) * 0.1);
                        salarioLiquido.add(Double.parseDouble(salario.get(i)) - bonus.get(i));
                    } 
                    
        i++;
        }
               

        for(int j = 0; j < Integer.parseInt(numeroFuncionarios); j++){
        System.out.println("");
        System.out.println("Funcionario: " + nomes.get(j));
        System.out.println("Salario: " + salario.get(j));
        if (Double.parseDouble(salario.get(j)) > 0.0 && Double.parseDouble(salario.get(j)) < 2000.0){
            System.out.println("Bonus: " + bonus.get(j));
            System.out.println("Salario Liquido: " + salarioLiquido.get(j));
            System.out.println("");
        }   else{
                if (Double.parseDouble(salario.get(j)) >= 2000.0){
                    System.out.println("Desconto: " + bonus.get(j));
                    System.out.println("Salario Liquido: " + salarioLiquido.get(j));
                    System.out.println("");
                }   
            }
        }
        input.close();
    }
}
