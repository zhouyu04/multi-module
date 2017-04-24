package com.zzyy.rs.dao;

import java.util.List;
import java.util.Map;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.entities.User;

public interface AccountDao {

	Long getTotalElement(Map<String, Object> params);

	List<Account> getAccountLists(Map<String, Object> params);

    void batchInsert(List<Account> accounts);

    Account findAccountByNameAndMark(Integer id, String rsName, String spell);

    void insertAccount(Account account);

    void updateAccount(Account account);

    Account findAccountById(Integer id);

    void addTransactionFlow(TransactionFlow transactionFlow);

    User findUserAccountByUsername(String username);
}
