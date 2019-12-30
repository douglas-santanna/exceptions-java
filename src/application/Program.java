package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Quarto ");
			int numeroDoQuarto = sc.nextInt();
			
			System.out.print("Data de entrada: ");
			Date dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			Date dataCheckOut = sdf.parse(sc.next());
			Reserva reserva = new Reserva(numeroDoQuarto, dataCheckIn, dataCheckOut);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println(" ");
			System.out.println("Entre com as novas datas");
			System.out.print("Data de entrada: ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			dataCheckOut = sdf.parse(sc.next());
			reserva.alterarData(dataCheckIn, dataCheckOut);
			System.out.println("Reserva: "+ reserva);
			
		}catch (ParseException e) {
			System.out.println("Formato da data inválido");
		}catch (DomainException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Ocorreu algo inesperado, tente novamente por favor.");
		}
		
		sc.close();

	}

}
