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

import it.fides.sp.dao.LoginDAO;
import it.fides.sp.model.Login;

@Component
public class JdbcLoginDAO implements LoginDAO{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	public JdbcLoginDAO(DataSource dataSource){
		this.namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(dataSource);
	}
	
	//METODI CRUD
	//crea
	@Override
	public void create(Login login) {
		final String SQL = "INSERT INTO users (username, password) " +
				   "VALUES (:username, :password)";

		namedParameterJdbcTemplate.update(SQL,  new BeanPropertySqlParameterSource(login));
		System.out.println(String.format("Record creato " + login));
		return;		
	}
	
	//cerca
	@Override
	public Login read(String username) {
		final String SQL = "SELECT * FROM users WHERE username = :username";
		return namedParameterJdbcTemplate.queryForObject(SQL, new MapSqlParameterSource("username", username), new LoginRowMapper());

	}

	//Aggiorna
	@Override
	public void update(Login login) {
		String SQL = "UPDATE users SET password = :password"
				+ " WHERE username = :username";
		
		namedParameterJdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(login));
		System.out.println("Aggiornato login " + login);
		return;		
	}

	//Elimina
	@Override
	public void delete(String username) {
		String SQL = "DELETE FROM users WHERE username = :username";
		
		namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource("username", username));
		System.out.println("Eliminato login con username: " + username);
		return;
	}

	//Ritorna tutti i login
	@Override
	public List<Login> selectAll() {
		String SQL = "SELECT * FROM users";
		return namedParameterJdbcTemplate.query(SQL, new LoginRowMapper());

	}
	
	public boolean isValidLogin(Login login){
		String SQL = "SELECT * FROM users WHERE username = :username AND password = :password";
		List<Login> count = namedParameterJdbcTemplate.query(SQL, new BeanPropertySqlParameterSource(login), new LoginRowMapper());

		boolean isValid;
		if (count.isEmpty()) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}
	
	
	private static final class LoginRowMapper implements RowMapper<Login>{
		public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			Login login = new Login();
			login.setUsername(rs.getString("username"));
			login.setPassword(rs.getString("password"));
			
			return login;
		}
	}

	
}
