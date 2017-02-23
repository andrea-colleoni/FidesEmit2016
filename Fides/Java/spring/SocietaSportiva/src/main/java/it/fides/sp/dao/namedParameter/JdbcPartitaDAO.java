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

import it.fides.sp.dao.PartitaDAO;
import it.fides.sp.model.Partita;

@Component
public class JdbcPartitaDAO implements PartitaDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcPartitaDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// Metodi CRUD
	// Crea una partita
	@Override
	public void create(Partita partita) {
		final String SQL = "INSERT INTO partita " +
						   "(id_partita, id_stadio, squadra, data, prezzo, biglietti_prenotati, biglietti_comprati, biglietti_disponibili) " +
						   "VALUES " +
						   "(:idPartita, :idStadioPartitaFK, " +
						   ":squadra, :data, :prezzo, :bigliettiPrenotati, :bigliettiComprati, :bigliettiDisponibili)";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(partita);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		
		System.out.println("Record creato: " + partita);
	}

	// Cerca una partita
	@Override
	public Partita read(int idPartita) {
		final String SQL = "SELECT * FROM partita WHERE id_partita = :idPartita";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idPartita", idPartita);
		
		return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new PartitaRowMapper());
	}

	// Aggiorna una partita
	@Override
	public void update(Partita partita) {
		final String SQL = "UPDATE partita SET " +
						   "id_stadio = :idStadioPartitaFK, " +
						   "squadra = :squadra, data = :data, prezzo = :prezzo, " +
						   "biglietti_prenotati = :bigliettiPrenotati, " +
						   "biglietti_comprati = :bigliettiComprati, " +
						   "biglietti_disponibili = :bigliettiDisponibili " +
						   "WHERE id_partita = :idPartita";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(partita);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	// Elimina una partita
	@Override
	public void delete(int idPartita) {
		final String SQL = "DELETE FROM partita WHERE id_partita = :idPartita";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idPartita", idPartita);
		
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		
		System.out.println(String.format("Record ID=%d eliminato", idPartita));
	}

	// Ritorna tutte le partita come lista
	@Override
	public List<Partita> selectAll() {
		final String SQL = "SELECT * FROM partita";
		
		return namedParameterJdbcTemplate.query(SQL,  new PartitaRowMapper());
	}

	@Override
	public List<Partita> showPartitaByWeek(int week) {
		final String SQL = "SELECT * FROM partita p WHERE WEEKOFYEAR(p.data) = :week";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("week", week);
		
		return namedParameterJdbcTemplate.query(SQL, namedParameters, new PartitaRowMapper());
	}

	@Override
	public List<Partita> showPartitaByStadio(int idStadio) {
		final String SQL = "SELECT * FROM partita WHERE id_stadio = :idStadio";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("idStadio", idStadio);
		
		return namedParameterJdbcTemplate.query(SQL, namedParameters, new PartitaRowMapper());
	}
	
	@Override
	public List<Partita> crono() {
		String SQL = "SELECT * FROM partita WHERE data >= CURDATE() ORDER BY data";
	
		return namedParameterJdbcTemplate.query(SQL, new PartitaRowMapper());
	}

	// Altri metodi - Daniele
	@Override
	public List<Partita> cresc() {
		String SQL = "SELECT * FROM partita WHERE data >= CURDATE() ORDER BY squadra";
		
		return namedParameterJdbcTemplate.query(SQL, new PartitaRowMapper());
	}

	@Override
	public List<Partita> idStadio() {
		String SQL = "SELECT * FROM partita WHERE data >= CURDATE() ORDER BY id_stadio";
		
		return namedParameterJdbcTemplate.query(SQL, new PartitaRowMapper());
	}
	
	// PartitaRowMapper
	private static final class PartitaRowMapper implements RowMapper<Partita> {
		
		public Partita mapRow(ResultSet rs, int rowNum) throws SQLException {
			Partita partita = new Partita();
			partita.setIdPartita(rs.getInt("id_partita"));
			partita.setIdStadioPartitaFK(rs.getInt("id_stadio"));
			partita.setSquadra(rs.getString("squadra"));
			partita.setData(rs.getDate("data"));
			partita.setPrezzo(rs.getBigDecimal("prezzo"));
			partita.setBigliettiPrenotati(rs.getInt("biglietti_prenotati"));
			partita.setBigliettiComprati(rs.getInt("biglietti_comprati"));
			partita.setBigliettiDisponibili(rs.getInt("biglietti_disponibili"));
			
			return partita;
		}
	}

}
