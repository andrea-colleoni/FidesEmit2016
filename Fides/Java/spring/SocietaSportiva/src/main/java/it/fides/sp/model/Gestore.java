package it.fides.sp.model;

import java.io.Serializable;

public class Gestore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idGestore;
	private String username;
	private String password;
	
	public Gestore() {}
	
	public int getIdGestore() {
		return idGestore;
	}
	public void setIdGestore(int idGestore) {
		this.idGestore = idGestore;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s, %s", idGestore, username, password);
	}

}
