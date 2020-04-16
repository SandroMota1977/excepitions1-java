package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Nº do Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (! checkOut.after(checkIn)) {
			System.out.println("Erro na reserva! A data de check-out antecede a data de check-in.");
		}
		else {
			Reservation reservation = new Reservation(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.println();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva! A reserva precisa ser em datas futuras.");
			}
			else if (! checkOut.after(checkIn)) {
				System.out.println("Erro na reserva! A data de check-out antecede a data de check-in.");
			}
			else { reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			}
		}
		sc.close();
	}
}