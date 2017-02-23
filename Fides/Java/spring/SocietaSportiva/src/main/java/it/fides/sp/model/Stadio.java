package it.fides.sp.model;

import java.io.Serializable;

public class Stadio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idStadio;
	private int idGestoreStadioFK;
	private String nome;
	private String indirizzo;
	private String citta;
	private int capienza;
	
	public Stadio() {}
	
	public int getIdStadio() {
		return idStadio;
	}
	public void setIdStadio(int idStadio) {
		this.idStadio = idStadio;
	}
	public int getIdGestoreStadioFK() {
		return idGestoreStadioFK;
	}
	public void setIdGestoreStadioFK(int idGestoreStadioFK) {
		this.idGestoreStadioFK = idGestoreStadioFK;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	
	@Override
	public String toString() {
		return String.format("Stadio[%d, %d, %s, %s, %s, %d]", idStadio, idGestoreStadioFK, nome, indirizzo, citta, capienza);
	}
	
	
}
