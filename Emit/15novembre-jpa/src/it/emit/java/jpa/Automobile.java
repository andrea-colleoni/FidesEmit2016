package it.emit.java.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Automobile {

	@Id
	String targa;
	String marca;
	String modello;
	int velocitaMax;
	
	@Temporal(TemporalType.DATE)
	Date dataImmatricolazione;
	int cilindrata;
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getVelocitaMax() {
		return velocitaMax;
	}
	public void setVelocitaMax(int velocitaMax) {
		this.velocitaMax = velocitaMax;
	}
	public Date getDataImmatricolazione() {
		return dataImmatricolazione;
	}
	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	
}
