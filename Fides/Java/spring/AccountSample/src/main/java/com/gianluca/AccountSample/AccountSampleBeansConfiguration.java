/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountSampleBeansConfiguration {

    @Bean
    public AccountService accountService() {
	
	AccountServiceImplementation bean = new AccountServiceImplementation();
        bean.setAccountDao(accountDao());
	return bean;
    }

    @Bean
    public AccountDao accountDao() {

	AccountDaoInMemoryImplementation bean = new AccountDaoInMemoryImplementation();
	// Le dipendenze del bean accountDao verranno iniettate qui...
	return bean;
    }
}
