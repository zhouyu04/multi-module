package com.zzyy.rs.dao;

import java.util.List;

import com.zzyy.rs.entities.Account;

public interface AccountDao {

	Long getTotalElement();

	List<Account> getAccountLists();

    void batchInsert(List<Account> accounts);

    Account findAccountByNameAndMark(String rsName, String personMark);

    void insertAccount(Account account);

    void updateAccount(Account account);
}
