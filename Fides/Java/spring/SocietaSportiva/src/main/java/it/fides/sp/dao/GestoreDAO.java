package it.fides.sp.dao;

import java.util.List;
import it.fides.sp.model.Gestore;

public interface GestoreDAO {
	
	// Metodi CRUD
	// Crea un gestore
	public void create (Gestore gestore);
	
	// Cerca un gestore
	public Gestore read(int id);
	
	// Aggiorna un gestore
	public void update(Gestore gestore);
	
	// Elimina un gestore
	public void delete(int id);
	
	// Ritorna tutti i gestori
	public List<Gestore> selectAll();
	
	//Trova gestore da username
	public Gestore findGestoreByUsername(String username);

}
