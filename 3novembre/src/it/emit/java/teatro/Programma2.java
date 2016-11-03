package it.emit.java.teatro;

import java.util.HashMap;
import java.util.Map;

public class Programma2 {

	public static void main(String[] args) {
		// se voglio preservare l'ordine di inserimento uso LinkedHashMap
		//Map<String, Spettacolo> locandina = new LinkedHashMap<>();
		
		// se non m'importa dell'ordine basta una HashMap
		Map<String, Spettacolo> locandina = new HashMap<>();
		
		Spettacolo s = new Spettacolo();
		s.setTitoloOpera("Cenerentola");
		locandina.put("primo",  s);
		
		s = new Spettacolo();
		s.setTitoloOpera("Biancaneve");
		locandina.put("secondo",  s);
		
		s = new Spettacolo();
		s.setTitoloOpera("Dumbo");
		locandina.put("terzo",  s);
		
		System.out.println(locandina.get("secondo").getTitoloOpera());
		
		s = new Spettacolo();
		s.setTitoloOpera("Bambi");
		locandina.put("terzo",  s);
		System.out.println(locandina.get("terzo").getTitoloOpera());
		
		System.out.println("-----------------------------------");
		for(Spettacolo s1 : locandina.values()) {
			System.out.println(s1.getTitoloOpera());
		}
		
		for(String k: locandina.keySet()) {
			System.out.println(k + " => " + locandina.get(k).getTitoloOpera());
		}
		
	}

}
