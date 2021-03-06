package it.fides.sp.dao.namedParameter;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import it.fides.sp.dao.BigliettoDAO;
import it.fides.sp.model.Biglietto;

@Component
public class JdbcBigliettoDAO implements BigliettoDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcBigliettoDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// Metodi CRUD
	// Crea un biglietto
	@Override
	public void create(Biglietto biglietto) {
		final String SQL = "INSERT INTO biglietto " +
						   "(id_biglietto, id_cliente, id_partita, prezzo_pagato, prenotato, pagato) " +
						   "VALUES " +
						   "(:idBiglietto, :idClienteBigliettoFK, :idPartitaBigliettoFK, :prezzoPagato, :prenotato, :pagato)";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(biglietto);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		
		System.out.println("Record creato: " + biglietto);
	}

	// Cerca un biglietto
	@Override
	public Biglietto read(int idBiglietto) {
		final String SQL = "SELECT * FROM biglietto WHERE id_biglietto = :idBiglietto";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idBiglietto", idBiglietto);
		
		return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new BigliettoRowMapper());
	}

	@Override
	public void update(Biglietto biglietto) {
		final String SQL = "UPDATE biglietto SET " + 
						   "id_cliente = :idClienteBigliettoFK, id_partita = :idPartitaBigliettoFK, " +
						   "prezzo_pagato = :prezzoPagato, prenotato = :prenotato, pagato = :pagato " +
						   "WHERE id_biglietto = :idBiglietto";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(biglietto);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	@Override
	public void delete(int idBiglietto) {
		final String SQL = "DELETE FROM biglietto WHERE id_biglietto = :idBiglietto";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idBiglietto", idBiglietto);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		
		System.out.println(String.format("Record ID=%d eliminato", idBiglietto));
	}

	@Override
	public List<Biglietto> selectAll() {
		final String SQL = "SELECT * FROM biglietto";
		
		List<Biglietto> biglietti = namedParameterJdbcTemplate.query(SQL, new BigliettoRowMapper());
		
		return biglietti;
	}

	@Override
	public List<Biglietto> listBigliettoByCliente(int idClienteBigliettoFK) {
		final String SQL = "SELECT * FROM biglietto WHERE id_cliente = :idClienteBigliettoFK";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idClienteBigliettoFK", idClienteBigliettoFK);
		
		return namedParameterJdbcTemplate.query(SQL, namedParameters, new BigliettoRowMapper());
	}
	
	@Override
	public List<Biglietto> listBigliettoByPartita(int idPartitaBigliettoFK) {
		final String SQL = "SELECT * FROM biglietto WHERE id_partita = :idPartitaBigliettoFK";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idPartitaBigliettoFK", idPartitaBigliettoFK);
		
		return namedParameterJdbcTemplate.query(SQL, namedParameters, new BigliettoRowMapper());
	}
	
	// BigliettoRowMapper
	private static final class BigliettoRowMapper implements RowMapper<Biglietto> {
		
		public Biglietto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Biglietto biglietto = new Biglietto();
			biglietto.setIdBiglietto(rs.getInt("id_biglietto"));
			biglietto.setIdClienteBigliettoFK(rs.getInt("id_cliente"));
			biglietto.setIdPartitaBigliettoFK(rs.getInt("id_partita"));
			biglietto.setPrezzoPagato(rs.getBigDecimal("prezzo_pagato"));
			biglietto.setPrenotato(rs.getInt("prenotato"));
			biglietto.setPagato(rs.getInt("pagato"));
			
			return biglietto;
		}
	}

	@Override
	public BigDecimal showTotalIncome() {
			final String SQL = "SELECT"
						  	  +"	   SUM(b.prezzo_pagato) "
							  +"FROM"
							  +"	   biglietto b INNER JOIN partita p "
							  +"	   ON b.id_partita = p.id_partita "
							  +"	   INNER JOIN stadio s "
							  +"	   ON p.id_stadio = s.id_stadio "
							  +"WHERE"
							  +"	   b.pagato = 1";
			
			SqlParameterSource namedParameters = new MapSqlParameterSource("null", null);
			return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, BigDecimal.class);
	}

	@Override
	public BigDecimal showIncomeByStadio(int idStadio) {
			final String SQL = "SELECT"
						  	  +"	   SUM(b.prezzo_pagato) "
							  +"FROM"
							  +"	   biglietto b INNER JOIN partita p "
							  +"	   ON b.id_partita = p.id_partita "
							  +"	   INNER JOIN stadio s "
							  +"	   ON p.id_stadio = s.id_stadio "
							  +"WHERE"
							  +"	   b.pagato = 1 && s.id_stadio = :idStadio";
			
			SqlParameterSource namedParameters = new MapSqlParameterSource("idStadio", idStadio);
			return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, BigDecimal.class);
		
	}

}
