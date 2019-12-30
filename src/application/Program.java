package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Quarto ");
		int numeroDoQuarto = sc.nextInt();
		
		System.out.print("Data de entrada: ");
		Date dataCheckIn = sdf.parse(sc.next());
		
		System.out.print("Data de saída: ");
		Date dataCheckOut = sdf.parse(sc.next());
		
		if(!dataCheckOut.after(dataCheckIn)) {
			System.out.println("Erro na reserva. Data de saída é maior que data de entrada.");
		}else {
			Reserva reserva = new Reserva(numeroDoQuarto, dataCheckIn, dataCheckOut);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println(" ");
			System.out.println("Entre com as novas datas");
			System.out.print("Data de entrada: ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			dataCheckOut = sdf.parse(sc.next());
			
			String erro = reserva.alterarData(dataCheckIn, dataCheckOut);
			if(erro != null) {
				System.out.println(erro);
			}else {
				System.out.println("Reserva: "+ reserva);
			}
			
		}
		
		sc.close();

	}

}
