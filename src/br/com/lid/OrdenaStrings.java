package br.com.lid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//ordenar lista com collections.sort
		System.out.println("----------------- ordem aufabetica ----------------------------");
		Collections.sort(palavras);
		System.out.println(palavras + "\n");
		
		// ordem pelo tamanho das palavras : (Nesse caso, utilizaremos um Comparator)
		System.out.println("----------------- ordem pelo tamanho das palavras ----------------------------");
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);
		
		// ou
		Comparator<String> comparador2 = new ComparadorDeStringPorTamanho();
		palavras.sort(comparador2);
		System.out.println(palavras);
		
		System.out.println("----------------- usando lampda  ----------------------------");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));  //antes
		System.out.println(palavras + " << palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));");

		palavras.sort(Comparator.comparing(s -> s.length())); 					//depois
		System.out.println(palavras + " << palavras.sort(Comparator.comparing(s -> s.length()));");

		// palavras.sort(Comparator.comparing(s -> s.length())); É EQUIVALENTE AO CODIGO ABAIXO SEM LAMPDAS
		System.out.println("----------------- Sem usar lampda ----------------------------");

		Function<String, Integer> funcao = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
			
		};
		Comparator<String> comparar = Comparator.comparing(funcao);
		palavras.sort(comparar);
		System.out.println(palavras);
		
		// ---------------------------------------------------------------------------------

		
		System.out.println("----------------- usando Method References ----------------------------");
		palavras.sort(Comparator.comparing(String::length));    
		System.out.println(palavras + " << palavras.sort(Comparator.comparing(String::length)); \n");

		palavras.forEach(System.out::println);
//		System.out.println(palavras + " << palavras.forEach(System.out::println);");
	}
}
