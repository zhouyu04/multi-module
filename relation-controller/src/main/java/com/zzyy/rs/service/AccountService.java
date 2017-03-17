package com.zzyy.rs.service;

import java.util.List;

import com.zzyy.rs.entities.Account;

public interface AccountService {
	
	Long getTotalElement();

	List<Account> getAccountLists();

    void batchInsert(List<Account> accounts);
}
