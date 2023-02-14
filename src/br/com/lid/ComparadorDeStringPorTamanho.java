package br.com.lid;

import java.util.Comparator;

public class ComparadorDeStringPorTamanho implements Comparator<String> {
	// se verificar o Javadoc da Interface verá que diz que 
	// devemos devolver um número negativo se o primeiro objeto for menor que o segundo, 
	// um número positivo caso contrário e zero se forem equivalentes.
	
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }
}
