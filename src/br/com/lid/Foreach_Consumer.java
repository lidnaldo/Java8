package br.com.lid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Foreach_Consumer {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		


		//		imprima cada uma dessas Strings com o novo método default, o forEach
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		
		// Ordenando essa lista utilizando o tamanho da String como critério de comparação
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		palavras.sort(comparador);  		// usando o default method sort, existente na própria lista.
		System.out.println(palavras);
		
	}
	

}
