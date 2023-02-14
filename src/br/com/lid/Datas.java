package br.com.lid;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		System.out.println("-----------------------------------------------------------");
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		

		System.out.println("-----------------------------------------------------------");
		// formatar data dia mes ano com /
		DateTimeFormatter ddMMyyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    System.out.println(hoje.format(ddMMyyyy));
		
	    DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	    LocalDateTime agora = LocalDateTime.now();
	    System.out.println(agora.format(formatadorComHoras));

		// Incrementando e decrementando suas datas 
	    System.out.println("----------- Incrementando e decrementando suas datas");
	    System.out.println(hoje.minusYears(1));
	    System.out.println(hoje.minusMonths(4));
	    System.out.println(hoje.minusDays(2));

	    System.out.println(hoje.plusYears(1));
	    System.out.println(hoje.plusMonths(4));
	    System.out.println(hoje.plusDays(2));
	    
	    
	    
		System.out.println("-----------------------------------------------------------");
		// guardar data do carnaval 2024
		LocalDate carnaval = LocalDate.of(2023, Month.FEBRUARY, 20);
		int dias = carnaval.getDayOfYear() - hoje.getDayOfYear();
		System.out.println("Faltam " + dias + " dias para o carnaval");

		System.out.println("-----------------------------------------------------------");
		// calcula 
		Period periodo = Period.between(hoje, carnaval);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());

		System.out.println("-----------------------------------------------------------");
		YearMonth anoMesAgora = YearMonth.now();
		System.out.println(anoMesAgora);

		System.out.println("-----------------------------------------------------------");
		LocalTime horaIntervalo = LocalTime.of(15, 30);
		System.out.println(horaIntervalo);

		System.out.println("-----------------------------------------------------------");
		LocalDate dataFutura = LocalDate.of(2100, Month.JANUARY, 01);
		Period proximoSeculo = Period.between(hoje, dataFutura);
		System.out.println(proximoSeculo);
		System.out.println(proximoSeculo.getYears()+ " anos");
		System.out.println(proximoSeculo.getMonths()+ " meses");
		System.out.println(proximoSeculo.getDays()+ " dias");

		
	}

}
