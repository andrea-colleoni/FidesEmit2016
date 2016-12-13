package it.emit.java.esercizio;

import java.text.ParseException;
import java.util.Scanner;

public class Programma {

	public static void main(String[] args) throws ParseException {
		// punto 6
		Rubrica r = new Rubrica();
		r.inizializza();
		r.stampaElenco();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un cognome: ");
		String letturaTastiera = sc.nextLine();
		r.cercaPerCognome(letturaTastiera);
		sc.close();
	}

}
