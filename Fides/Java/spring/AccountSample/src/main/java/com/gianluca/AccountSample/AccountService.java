/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

public interface AccountService {
	
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount);
    public void depositMoney(long accountId, double amount) throws Exception;
    public Account getAccount(long accountId);
}
