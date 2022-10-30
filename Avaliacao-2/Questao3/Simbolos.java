package Questao3;

public class Simbolos {

    public String frase;
    public String emoticon;
    public int comparar;
    public int contador;

    public int contadorSimbolos(String frase, String emoticon) {
        int comparar = 0;
        int contador = 0;
        
        while (true) {
            comparar = frase.indexOf(emoticon, comparar);
            if (comparar != -1) {
                contador++;
                comparar += emoticon.length();
            } else {
                break;
            }
        }
        return contador;
    }
}