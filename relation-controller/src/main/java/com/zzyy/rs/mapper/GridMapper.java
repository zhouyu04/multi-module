package com.zzyy.rs.mapper;

import java.util.List;
import java.util.Map;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;

public interface GridMapper {

    Long getTotalElement();

    List<Account> getAccountLists();

    Account findAccountByNameAndMark(Map<String, Object> params);

    Long getTotalTransactionElements(Map<String, Object> params);

    List<TransactionFlow> getTransactionFlows(Map<String, Object> params);
}