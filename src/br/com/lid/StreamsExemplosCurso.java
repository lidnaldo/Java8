package br.com.lid;
//  https://unibb.alura.com.br/course/java8-lambdas/task/5228
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class StreamsExemplosCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// equivalentes
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));  // com lampda
		cursos.sort(Comparator.comparingInt(Curso::getAlunos)); // com method reference
		
		System.out.println("------------- cursos com mais de 100 alunos-------");
		cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.forEach(c -> System.out.println(c.getNome()));

		System.out.println("------------- quantos alunos tem cada curso-------");
		cursos.stream()
				.map(c -> c.getAlunos())
				.forEach(qtdeAlunos -> System.out.println(qtdeAlunos));

		System.out.println("------------- quantos alunos tem cada curso com method reference -------");
		cursos.stream()
				.map(Curso::getAlunos)
				.forEach(System.out::println);

		System.out.println("------------- somar qdte alunos nas turmas com mais de 100 alunos -------");
		int soma = cursos.stream()
				.filter(c -> c.getAlunos() > 100) // filtrar por cursos com mais de 100 alunos
				.mapToInt(Curso::getAlunos)
				.sum();
		System.out.println(soma);

		
	}
}


