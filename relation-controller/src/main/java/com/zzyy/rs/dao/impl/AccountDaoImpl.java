package com.zzyy.rs.dao.impl;

import com.zzyy.rs.dao.AccountDao;
import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.mapper.AccountMapper;
import com.zzyy.rs.mapper.GridMapper;
import com.zzyy.rs.mapper.TransactionFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    GridMapper gridmapper;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    TransactionFlowMapper transactionFlowMapper;


    public Long getTotalElement(Map<String, Object> params) {


        return gridmapper.getTotalElement(params);
    }


    public List<Account> getAccountLists(Map<String, Object> params) {
        List<Account> result = gridmapper.getAccountLists(params);
        return result;
    }

    public void batchInsert(List<Account> accounts) {

        accountMapper.batchInsert(accounts);
    }

    public Account findAccountByNameAndMark(Integer id, String rsName, String spell) {

        Map<String, Object> params = new HashMap();
        params.put("accountId", id);
        params.put("rsName", rsName);
        params.put("spell", spell);

        Account account = gridmapper.findAccountByNameAndMark(params);

        return account;
    }

    public void insertAccount(Account account) {
        accountMapper.insert(account);
    }

    public void updateAccount(Account account) {
        accountMapper.updateByPrimaryKey(account);

    }

    public Account findAccountById(Integer id) {

        Account result = accountMapper.selectByPrimaryKey(id);
        return result;
    }

    public void addTransactionFlow(TransactionFlow transactionFlow) {

        transactionFlowMapper.insert(transactionFlow);
    }

}
