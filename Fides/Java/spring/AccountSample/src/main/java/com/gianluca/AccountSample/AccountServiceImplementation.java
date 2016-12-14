/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

public class AccountServiceImplementation implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
	this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
	
	Account sourceAccount = accountDao.find(sourceAccountId);
        Account targetAccount = accountDao.find(targetAccountId);
	
	sourceAccount.setBalance(sourceAccount.getBalance() - amount);
	targetAccount.setBalance(targetAccount.getBalance() + amount);

	accountDao.update(sourceAccount);
	accountDao.update(targetAccount);
    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
	
	Account account = accountDao.find(accountId);
	account.setBalance(account.getBalance() + amount);
	accountDao.update(account);
    }

    @Override
    public Account getAccount(long accountId) {
	
	return accountDao.find(accountId);
    }
}
