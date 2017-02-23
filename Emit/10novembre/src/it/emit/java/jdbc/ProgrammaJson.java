package it.emit.java.jdbc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProgrammaJson {

	public static void main(String[] args) throws JsonProcessingException {
		Autore a = new Autore();
		a.setNome("Mario");
		a.setCognome("Rossi");
		a.setCodice(99);
		a.setNazionalita("Italia");
		Genere generePreferito = new Genere();
		generePreferito.setDescrizione("Giallo");
		a.setGenerePreferito(generePreferito );

		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(a));
		
	}

}
