package it.fides.sp.dao;

import java.math.BigDecimal;
import java.util.List;

import it.fides.sp.model.Biglietto;

public interface BigliettoDAO {
	
	// Metodi CRUD
	// Crea un biglietto
	public void create(Biglietto biglietto);
	
	// Cerca un biglietto
	public Biglietto read(int idBiglietto);
	
	// Aggiorna un biglietto
	public void update(Biglietto biglietto);
	
	// Elimina un biglietto
	public void delete(int idBiglietto);
	
	// Altri metodi
	// Ritorna tutti i biglietti come lista
	public List<Biglietto> selectAll();
	
	// Ritorna tutti i biglietti di un cliente come lista
	public List<Biglietto> listBigliettoByCliente(int idClienteBigliettoFK);
	
	//Visualizza l'incasso totale
	public BigDecimal showTotalIncome ();
	
	//Visualizza l'incasso totale per ogni stadio
	public BigDecimal showIncomeByStadio (int idStadio);
	
}

