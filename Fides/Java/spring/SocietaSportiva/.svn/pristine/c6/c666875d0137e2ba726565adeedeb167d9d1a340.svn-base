package it.fides.sp.dao.namedParameter;

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

import it.fides.sp.dao.StadioDAO;
import it.fides.sp.model.Stadio;

@Component
public class JdbcStadioDAO implements StadioDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcStadioDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// Metodi CRUD
	@Override
	public void create(Stadio stadio) {
		final String SQL = "INSERT INTO Stadio " + 
						   "(id_stadio, id_gestore, nome, indirizzo, citta, capienza) VALUES" +
						   "(:idStadio, :idGestoreStadioFK, :nome, :indirizzo, :citta, :capienza)";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(stadio);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		
		System.out.println("Record creato: " + stadio);
	}

	// Cerca un cliente
	@Override
	public Stadio read(int idStadio) {
		final String SQL = "SELECT * FROM stadio WHERE id_stadio = :idStadio";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idStadio", idStadio);
		
		return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new StadioRowMapper());
	}

	// Aggiorna un cliente
	@Override
	public void update(Stadio stadio) {
		final String SQL = "UPDATE stadio SET " +
						   "id_gestore = :idGestoreStadioFK, " +
						   "nome = :nome, indirizzo = :indirizzo, citta = :citta, capienza = :capienza " +
						   "WHERE id_stadio = :idStadio";
		
		namedParameterJdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(stadio));
		System.out.println("Record aggiornato: " + stadio);
	}

	// Elimina uno stadio
	@Override
	public void delete(int idStadio) {
		final String SQL = "DELETE FROM stadio WHERE id_stadio = :idStadio";
		
		namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource("idStadio", idStadio));
		
		System.out.println(String.format("Record ID=%d eliminato", idStadio));
	}
	
	// Altri metodi
	// Ritorna tutti gli stadi come lista
	@Override
	public List<Stadio> selectAll() {
		final String SQL = "SELECT * FROM stadio";
		
		List<Stadio> stadi = namedParameterJdbcTemplate.query(SQL, new StadioRowMapper());
		
		return stadi;
	}
	
	//Trova gli stadi di un gestore
	@Override
	public List<Stadio> getStadiGestore(int idGestore) {
		System.out.println(idGestore);
		final String SQL = "SELECT * FROM stadio WHERE id_gestore = :idGestore";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idGestore", idGestore);
		
		List<Stadio> stadiGestore = namedParameterJdbcTemplate.query(SQL, namedParameters, new StadioRowMapper());
			
		return stadiGestore;
	}

	// StadioRowMapper
	private static final class StadioRowMapper implements RowMapper<Stadio> {
		
		public Stadio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Stadio stadio = new Stadio();
			stadio.setIdStadio(rs.getInt("id_stadio"));
			stadio.setIdGestoreStadioFK(rs.getInt("id_gestore"));
			stadio.setNome(rs.getString("nome"));
			stadio.setIndirizzo(rs.getString("indirizzo"));
			stadio.setCitta(rs.getString("citta"));
			stadio.setCapienza(rs.getInt("capienza"));
			
			return stadio;
		}
	}
}
