package it.fides.sp.dao;

import java.util.List;

import it.fides.sp.model.Partita;

public interface PartitaDAO {
	
	// Metodi CRUD
	// Crea una partita
	public void create (Partita partita);
	
	// Cerca una partita
	public Partita read(int idPartita);
	
	// Aggiorna una partita
	public void update(Partita partita);
	
	// Elimina una partita
	public void delete(int idPartita);
	
	// Altri metodi
	// Ritorna tutte le partite come lista
	public List<Partita> selectAll();

	// Ritorna tutte le partite di una determinata settimana
	public List<Partita> showPartitaByWeek(int week);
	
	// Ritorna tutte le partite di un determinato stadio
	public List<Partita> showPartitaByStadio (int idStadioPartitaFK);
	
	// Liste ordinamento partite
	public List<Partita> crono();
	public List<Partita> cresc();
	public List<Partita> idStadio();
	public List<Partita> cronoAll();
 
}
