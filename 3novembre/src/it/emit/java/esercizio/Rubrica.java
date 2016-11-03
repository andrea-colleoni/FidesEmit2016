package it.emit.java.esercizio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {

	// punto 2
	List<Contatto> elenco;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// punto 3
	public void inizializza() throws ParseException {
		elenco = new ArrayList<>();
		
		Contatto c = new Contatto();
		c.setNome("Mario");
		c.setCognome("Rossi");
		c.setEmail("mario@email.it");
		c.setNumeroTelefono("02 2345678765");
		c.setDataNascita(sdf.parse("1970-02-20"));
		
		elenco.add(c);
		
		c = new Contatto();
		c.setNome("Anna");
		c.setCognome("Verdi");
		c.setEmail("anna@email.it");
		c.setNumeroTelefono("02 23434535");
		c.setDataNascita(sdf.parse("1970-01-20"));
		
		elenco.add(c);
		
		c = new Contatto();
		c.setNome("Gigi");
		c.setCognome("Rossi");
		c.setEmail("gigi@email.it");
		c.setNumeroTelefono("02 233333765");
		c.setDataNascita(sdf.parse("1975-02-20"));
		
		elenco.add(c);
		
		c = new Contatto();
		c.setNome("Paola");
		c.setCognome("Bianchi");
		c.setEmail("paola@email.it");
		c.setNumeroTelefono("02 23456789999");
		c.setDataNascita(sdf.parse("1970-02-20"));
		
		elenco.add(c);
		
		c = new Contatto();
		c.setNome("Marisa");
		c.setCognome("Neri");
		c.setEmail("marisa@email.it");
		c.setNumeroTelefono("02 234765");
		c.setDataNascita(sdf.parse("1980-05-10"));
		
		elenco.add(c);
	}
	
	// punto 4
	public void stampaElenco() {
		for(Contatto c : elenco) {
			System.out.println(c);
		}
	}

	// ulteriore opzione per stampare un contatto
	private void stampaContatto(Contatto c) {
		System.out.println("------------------------\n"
				+ c.getCognome() + ", " + c.getNome() + "\n" +
				"mail: " + c.getEmail() + "\n" + 
				"tel: " + c.getNumeroTelefono() + "\n" +
				"------------------------");
	}
	
	// punto 5
	public void cercaPerCognome(String cognome) {
		boolean trovato = false;
		for(Contatto c : elenco) {
			if (cognome.equals(c.getCognome())) {
				c.stampaContatto();
				trovato = true;
			}
		}
		if (!trovato)
			System.out.println("Contatto non trovato");
	}
}
