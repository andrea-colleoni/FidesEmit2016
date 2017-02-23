package it.fides.sp.dao;

import java.util.List;

import it.fides.sp.model.Stadio;


public interface StadioDAO {
	
	// Metodi CRUD
	// Crea uno stadio
	public void create(Stadio stadio);
	
	// Cerca uno stadio
	public Stadio read(int idStadio);
	
	// Aggiorna uno stadio
	public void update(Stadio stadio);
	
	// Elimina uno stadio
	public void delete(int idStadio);
	
	// Altri metodi
	// Ritorna tutti gli stadi come lista
	public List<Stadio> selectAll();	
	
	//Trova tutti gli stadi di un gestore
	public List<Stadio> getStadiGestore(int idGestore);


}
