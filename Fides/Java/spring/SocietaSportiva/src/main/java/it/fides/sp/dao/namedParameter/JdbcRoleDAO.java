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
import it.fides.sp.dao.RoleDAO;
import it.fides.sp.model.Role;

@Component
public class JdbcRoleDAO implements RoleDAO{
	
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcRoleDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void create(Role role) {
		final String SQL = "INSERT INTO user_roles (role_id, username, user_role) " +
				   "VALUES (:roleId, :username, :userRole)";
		namedParameterJdbcTemplate.update(SQL,  new BeanPropertySqlParameterSource(role));
		System.out.println(String.format("Record creato " + role));
		return;		
	}

	@Override
	public Role read(String username) {
		final String SQL = "SELECT * FROM user_roles WHERE username = :username";
		return namedParameterJdbcTemplate.queryForObject(SQL, new MapSqlParameterSource("username", username), new RoleRowMapper());
	}

	@Override
	public void update(Role role) {
		String SQL = "UPDATE user_roles SET user:role = :userRole"
				+ " WHERE username = :username";
		namedParameterJdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(role));
		System.out.println("Aggiornato ruolo " + role);
		return;	
	}

	@Override
	public void delete(String username) {
		String SQL = "DELETE FROM user_roles WHERE username = :username";
		namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource("username", username));
		System.out.println("Eliminato ruolo con username: " + username);
		return;
	}

	@Override
	public List<Role> selectAll() {
		String SQL = "SELECT * FROM user_roles";
		return namedParameterJdbcTemplate.query(SQL, new RoleRowMapper());
	}
	
	private static final class RoleRowMapper implements RowMapper<Role>{
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setRoleId(rs.getInt("role_id"));
			role.setUsername(rs.getString("username"));
			role.setUserRole(rs.getString("user_role"));
			return role;
		}
	}
}
