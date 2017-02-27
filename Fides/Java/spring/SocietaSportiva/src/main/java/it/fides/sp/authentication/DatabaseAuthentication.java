package it.fides.sp.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.fides.sp.dao.AccountDAO;
import it.fides.sp.model.Account;

@Service
public class DatabaseAuthentication implements UserDetailsService {
	
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDAO.read(username);
		if (account == null) {
			throw new UsernameNotFoundException(String.format("User %d non trovato!", username));
		} else {
			System.out.print(account);
		}
		
		// Role (CLIENTE, GESTORE)
		String role = account.getUserRole();
		
		// ROLE_CLIENTE, ROLE_GESTORE
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		grantedList.add(authority);
		
		boolean enabled = account.isActive();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		UserDetails userDetails = (UserDetails) new User(account.getUsername(),
														 account.getPassword(),
														 enabled, accountNonExpired,
														 credentialsNonExpired, accountNonLocked,
														 grantedList);
		
		return userDetails;
	}


}
