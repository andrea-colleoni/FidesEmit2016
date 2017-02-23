package it.fides.sp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Partita implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idPartita;
	private int idStadioPartitaFK;
	private String squadra;
	private Date data;
	private BigDecimal prezzo;
	private int bigliettiPrenotati;
	private int bigliettiComprati;
	private int bigliettiDisponibili;
	
	public Partita () {}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}
	
	public int getIdPartita() {
		return idPartita;
	}

	public int getIdStadioPartitaFK() {
		return idStadioPartitaFK;
	}

	public void setIdStadioPartitaFK(int idStadioPartitaFK) {
		this.idStadioPartitaFK = idStadioPartitaFK;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getSquadra() {
		return squadra;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setBigliettiPrenotati(int bigliettiPrenotati) {
		this.bigliettiPrenotati = bigliettiPrenotati;
	}

	public int getBigliettiPrenotati() {
		return bigliettiPrenotati;
	}

	public void setBigliettiComprati(int bigliettiComprati) {
		this.bigliettiComprati = bigliettiComprati;
	}

	public int getBigliettiComprati() {
		return bigliettiComprati;
	}

	public void setBigliettiDisponibili(int bigliettiDisponibili) {
		this.bigliettiDisponibili = bigliettiDisponibili;
	}

	public int getBigliettiDisponibili() {
		return bigliettiDisponibili;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %d, %s, %s, %f, %d, %d, %d", idPartita, idStadioPartitaFK, 
								 squadra, data, prezzo, bigliettiPrenotati, bigliettiComprati, bigliettiDisponibili );
	}
	

}
