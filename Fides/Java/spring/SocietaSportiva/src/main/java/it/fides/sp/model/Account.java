package it.fides.sp.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String ROLE_CLIENTE = "CLIENTE";
	public static final String ROLE_GESTORE = "GESTORE";
	
	private String username;
	private String password;
	private boolean active;
	private String userRole;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserRole() {
		return userRole;
	}
	
	@Override
	public String toString() {
		return String.format("Account[%s, %s, %d, %s]", username, password, active, userRole);
	}

}
