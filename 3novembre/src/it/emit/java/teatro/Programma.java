package it.emit.java.teatro;

import java.util.ArrayList;
import java.util.List;

public class Programma {

	public static void main(String[] args) {
		// se non mi danno fastidio i duplicati nella lista uso List
		List<Spettacolo> locandina = new ArrayList<>();
		
		// se invece voglio che i duplicati vengano inseriti una sola
		// volta uso Set
		//Set<Spettacolo> locandina = new HashSet<>();
		
		Spettacolo s = new Spettacolo();
		s.setTitoloOpera("Cenerentola");
		locandina.add(s);
		locandina.add(s);
		locandina.add(s);
		locandina.add(s);
		locandina.add(s);
		s = new Spettacolo();
		s.setTitoloOpera("Biancaneve");
		locandina.add(s);
		s = new Spettacolo();
		s.setTitoloOpera("Dumbo");
		locandina.add(s);
		
		// get() funziona su List ma non su Set perché List ha un indice
		// per accedere agli oggetti, mentre Set non l'ha
		s = locandina.get(1);
		System.out.println(s.getTitoloOpera());
		
		System.out.println("-----------------------------------");
		System.out.println("La locandina contiene " + 
				locandina.size()  + " spettacoli.");
		for(Spettacolo s1 : locandina) {
			System.out.println(s1.getTitoloOpera());
		}
		
	}

}
