package it.fides.sp.dao;

import java.util.List;
import it.fides.sp.model.Role;

public interface RoleDAO {
	
	public void create (Role role);
	public Role read(String username);
	public void update(Role role);
	public void delete(String username);
	public List<Role> selectAll();

}
