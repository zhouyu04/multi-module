package com.zzyy.rs.dao;

import java.util.List;

import com.zzyy.rs.entities.Account;

public interface AccountDao {

	Long getTotalElement();

	List<Account> getAccountLists();

    void batchInsert(List<Account> accounts);
}
