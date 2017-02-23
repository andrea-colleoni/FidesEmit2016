package it.fides.sp.dao;

import java.util.List;

import it.fides.sp.model.Cliente;

public interface ClienteDAO {
	
	// Metodi CRUD
	// Crea un cliente
	public void create(Cliente cliente);
	
	// Cerca un cliente
	public Cliente read(int idCliente);
	
	// Aggiorna un cliente
	public void update(Cliente cliente);
	
	// Elimina un cliente
	public void delete(int idCliente);
	
	// Altri metodi
	// Ritorna tutti i clienti come lista
	public List<Cliente> selectAll();
	
	//Trova cliente dallo username
	public Cliente getClienteByUsername(String username);


}
