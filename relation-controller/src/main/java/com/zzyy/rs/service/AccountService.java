package com.zzyy.rs.service;

import java.util.List;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.User;

public interface AccountService {
	
	Long getTotalElement(Integer userNumber, String userName, Integer page, Integer rows, String sortOrder, String sortField);

	List<Account> getAccountLists(Integer userNumber, String userName, Integer page, Integer rows, String sortOrder, String sortField);

    List<Account> batchInsert(List<Account> accounts);

	User findUserAccountByUsername(String username);
}
