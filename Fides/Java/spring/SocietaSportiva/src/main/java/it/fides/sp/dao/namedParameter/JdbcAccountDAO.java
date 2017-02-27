package it.fides.sp.dao.namedParameter;

import java.sql.SQLException;

import java.sql.ResultSet;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import it.fides.sp.dao.AccountDAO;
import it.fides.sp.model.Account;

@Component
public class JdbcAccountDAO implements AccountDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcAccountDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// Metodi CRUD
	// Cerca un utente
	@Override
	public Account read(String username) {
		final String SQL = "SELECT * FROM account WHERE username = :username";
		
		SqlParameterSource namedParams = new MapSqlParameterSource("username", username);
		
		return namedParameterJdbcTemplate.queryForObject(SQL, namedParams, new AccountRowMapper());
	}
	
	// AccountRowMapper
	private static final class AccountRowMapper implements RowMapper<Account> {
		
		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setUsername(rs.getString("username"));
			account.setPassword(rs.getString("password"));
			account.setActive(rs.getBoolean("active"));
			account.setUserRole(rs.getString("user_role"));
			
			return account;
		}
	}
	

}
