package it.emit.java.jdbc;

import java.io.Serializable;
import java.util.List;

public class Autore implements Serializable {
	
	int codice;
	String nome;
	String cognome;
	int annoNascita;
	String nazionalita;
	Genere generePreferito;
	
	List<Libro> libri;
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public Genere getGenerePreferito() {
		return generePreferito;
	}
	public void setGenerePreferito(Genere generePreferito) {
		this.generePreferito = generePreferito;
	}
	public List<Libro> getLibri() {
		return libri;
	}
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

}
