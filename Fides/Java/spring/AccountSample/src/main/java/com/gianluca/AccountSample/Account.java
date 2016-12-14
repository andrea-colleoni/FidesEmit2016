/* vim:set ts=4 sw=4: */

/**
 * 
 * @author aculnaig
 *
 */

package com.gianluca.AccountSample;

import java.util.Date;

public class Account {

    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;

    // Getter e setter
    public void setId(long id) {
	this.id = id;
    }

    public long getId() {
    	return id;
    }

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	
	public Date getAccessTime() {
		return accessTime;
	}
}
