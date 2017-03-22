package com.zzyy.rs.dao;

import java.util.List;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;

public interface AccountDao {

	Long getTotalElement();

	List<Account> getAccountLists();

    void batchInsert(List<Account> accounts);

    Account findAccountByNameAndMark(Integer id, String rsName, String spell);

    void insertAccount(Account account);

    void updateAccount(Account account);

    Account findAccountById(Integer id);

    void addTransactionFlow(TransactionFlow transactionFlow);
}
