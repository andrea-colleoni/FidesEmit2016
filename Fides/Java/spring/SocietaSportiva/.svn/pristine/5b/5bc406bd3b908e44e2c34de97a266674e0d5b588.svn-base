package it.fides.sp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Biglietto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idBiglietto;
	private int idClienteBigliettoFK;
	private int idPartitaBigliettoFK;
	private BigDecimal prezzoPagato;
	private int prenotato;
	private int pagato;
	
	public Biglietto(){}
	
	public void setIdBiglietto(int idBiglietto) {
		this.idBiglietto = idBiglietto;
	}
	
	public int getIdBiglietto() {
		return idBiglietto;
	}

	public void setIdClienteBigliettoFK(int idClienteBigliettoFK) {
		this.idClienteBigliettoFK = idClienteBigliettoFK;
	}

	public int getIdClienteBigliettoFK() {
		return idClienteBigliettoFK;
	}

	public void setIdPartitaBigliettoFK(int idPartitaBigliettoFK) {
		this.idPartitaBigliettoFK = idPartitaBigliettoFK;
	}

	public int getIdPartitaBigliettoFK() {
		return idPartitaBigliettoFK;
	}

	public void setPrezzoPagato(BigDecimal prezzoPagato) {
		this.prezzoPagato = prezzoPagato;
	}

	public BigDecimal getPrezzoPagato() {
		return prezzoPagato;
	}

	public void setPrenotato(int prenotato) {
		this.prenotato = prenotato;
	}

	public int getPrenotato() {
		return prenotato;
	}

	public void setPagato(int pagato) {
		this.pagato = pagato;
	}

	public int getPagato() {
		return pagato;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %d, %d, %f, %d, %d", idBiglietto, idClienteBigliettoFK, idPartitaBigliettoFK, 
													   prezzoPagato, prenotato, pagato);
	}

}