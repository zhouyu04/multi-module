package com.zzyy.rs.entities;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {

	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	
	public AccountModel() {
		this.accounts = new ArrayList<Account>();
	}

	public AccountModel(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public void add(Account account) {
        this.accounts.add(account);
    }
}
