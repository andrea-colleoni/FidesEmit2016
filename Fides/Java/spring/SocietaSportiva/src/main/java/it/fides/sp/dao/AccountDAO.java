package it.fides.sp.dao;

import it.fides.sp.model.Account;

public interface AccountDAO {
	
	public Account read(String username);

}
