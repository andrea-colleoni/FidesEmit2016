package it.fides.sp.dao.namedParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import it.fides.sp.dao.ClienteDAO;
import it.fides.sp.model.Cliente;

@Component
public class JdbcClienteDAO implements ClienteDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcClienteDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(dataSource);

	}
	
	// Metodi CRUD
	// Crea un cliente
	@Override
	public void create(Cliente cliente) {
		final String SQL = "INSERT INTO Cliente (id_cliente, nome, cognome, username) VALUES (:idCliente, :nome, :cognome, :username)";
		
		namedParameterJdbcTemplate.update(SQL,  new BeanPropertySqlParameterSource(cliente));
		
		System.out.println("Record creato: " + cliente);
	}
	
	// Cerca un cliente
	@Override
	public Cliente read(int idCliente) {
		final String SQL = "SELECT * FROM cliente WHERE id_cliente = :idCliente";
		
		return namedParameterJdbcTemplate.queryForObject(SQL, new MapSqlParameterSource("idCliente", idCliente), new ClienteRowMapper());
	}
	
	// Aggiorna un cliente
	@Override
	public void update(Cliente cliente) {
			final String SQL = "UPDATE cliente SET nome = :nome, cognome = :cognome, username = :username WHERE id_cliente = :idCliente";
			
			namedParameterJdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(cliente));
			System.out.print("Record aggiornato: " + cliente);
	}
	
	// Elimina un cliente
	@Override
	public void delete(int idCliente) {
		final String SQL = "DELETE FROM cliente WHERE id_cliente = :idCliente";
		
		namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource("idCliente", idCliente));
		
		System.out.println(String.format("Record ID=%d eliminato", idCliente));
	}

	// Ritorna tutti i clienti come lista
	@Override
	public List<Cliente> selectAll() {
		final String SQL = "SELECT * FROM cliente";

		return namedParameterJdbcTemplate.query(SQL, new ClienteRowMapper());
	}
	
	//Trova un cliente dallo username
	public Cliente getClienteByUsername(String username){
		String SQL = "SELECT * FROM cliente WHERE username = :username";
		return namedParameterJdbcTemplate.queryForObject(SQL, new MapSqlParameterSource("username", username), new ClienteRowMapper());
	}	
	
	// ClienteRowMapper
	private static final class ClienteRowMapper implements RowMapper<Cliente> {
		
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getInt("id_cliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCognome(rs.getString("cognome"));
			cliente.setUsername(rs.getString("username"));

			return cliente;
		}
	}

}
