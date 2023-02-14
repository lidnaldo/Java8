package br.com.lid;
// https://unibb.alura.com.br/course/java8-lambdas/task/42078
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparetorComparing {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		System.out.println("----------------- usando lampda  ----------------------------");
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		System.out.println(palavras);
		
		System.out.println("----------------- usando Method References ----------------------------");
		palavras.sort(Comparator.comparing(String::length));
		System.out.println(palavras + " << palavras.sort(Comparator.comparing(String::length));");
		
		// ou 
		
//		palavras.sort(comparing(String::length));
//		System.out.println(palavras + " << palavras.sort(comparing(String::length));");
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(palavras + " << palavras.sort(String.CASE_INSENSITIVE_ORDER);");
		
		
		palavras.forEach(System.out::println);
		System.out.println(palavras + " << palavras.forEach(System.out::println);");
	}
}
