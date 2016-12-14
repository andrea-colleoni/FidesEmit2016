/* vim:set ts=4 sw=4: */

/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

import java.util.List;

public interface AccountDao {
   
    public void insert(Account account);
    public void update(Account account);
    public void update(List<Account> accounts);
    public void delete(long accountId);
    public Account find(long accountId);
    public List<Account> find(List<Long> accountIds);
    public List<Account> find(String ownerName);
    public List<Account> find(boolean locked);
}
