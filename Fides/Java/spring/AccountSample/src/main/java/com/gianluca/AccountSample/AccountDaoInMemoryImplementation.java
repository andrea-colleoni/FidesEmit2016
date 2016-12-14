/* vim:set ts=4 sw=4: */
/** 
 *
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository
public class AccountDaoInMemoryImplementation implements AccountDao {
    
    private Map<Long,Account> accountsMap = new HashMap<>();

    {
	    Account account1 = new Account();
	    account1.setId(1);
	    account1.setOwnerName("Gianluca");
	    account1.setBalance(10000.0);

        Account account2 = new Account();
	    account2.setId(2);
	    account2.setOwnerName("Gianluca");
	    account2.setBalance(10000.0);

		accountsMap.put(account1.getId(), account1);
		accountsMap.put(account2.getId(), account2);
    }

    @Override
    public void update(Account account) {
	accountsMap.put(account.getId(), account);
    }

    @Override
    public Account find(long accountId) {
	return accountsMap.get(accountId);
    }

	public void insert(Account account) {
		// TODO Auto-generated method stub
		
	}

	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long accountId) {
		// TODO Auto-generated method stub
		
	}

	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

}
