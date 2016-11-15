package it.emit.java.jdbc;

import java.io.Serializable;

public class Genere implements Serializable {
	
	String descrizione;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
