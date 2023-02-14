package br.com.lid;
//  https://unibb.alura.com.br/course/java8-lambdas/task/5228
//  https://unibb.alura.com.br/course/java8-lambdas/task/5236
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class StreamsComOptional {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		System.out.println("------------- somar qdte alunos nas turmas com mais de 100 alunos -------");
		int soma = cursos.stream()
				.filter(c -> c.getAlunos() > 100) // filtrar por cursos com mais de 100 alunos
				.mapToInt(Curso::getAlunos)
				.sum();
				
		System.out.println(soma);

		System.out.println("------------- media de alunos por turma -------");
		OptionalDouble media = cursos.stream()
				.mapToInt(Curso::getAlunos)
				.average();
		
		System.out.println(media);
		
		
		System.out.println("------------- Collectors - guardar resultado em um Map list -------");
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));   // um map tem sempre uma chave (1º parm) e valor (2º parm)  
		System.out.println(mapa);
		
		System.out.println("------------- quantidade de alunos por turma -------");
		cursos.stream() 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos")); 
		
		
		System.out.println("------------- Collectors - guardar resultado em uma List -------");
		List<Curso> lista = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		lista.forEach(L -> System.out.println(L.getNome()));

		System.out.println("------------- Para listas ENORMES use o parallelStrem por é mais performatico, ele quebra em treds -------");
		cursos.parallelStream() 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos")); 

	}
}


