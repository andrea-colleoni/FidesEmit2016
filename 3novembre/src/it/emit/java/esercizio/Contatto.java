package it.emit.java.esercizio;

import java.util.Date;

// punto 1
public class Contatto {

	String nome, cognome, email, numeroTelefono;
	Date dataNascita;
	
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public void stampaContatto() {
		System.out.println("------------------------\n"
				+ this.getCognome() + ", " + this.getNome() + "\n" +
				"mail: " + this.getEmail() + "\n" + 
				"tel: " + this.getNumeroTelefono() + "\n" +
				"------------------------");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "------------------------\n"
				+ this.getCognome() + ", " + this.getNome() + "\n" +
				"mail: " + this.getEmail() + "\n" + 
				"tel: " + this.getNumeroTelefono() + "\n" +
				"------------------------";
	}
	
	
}
