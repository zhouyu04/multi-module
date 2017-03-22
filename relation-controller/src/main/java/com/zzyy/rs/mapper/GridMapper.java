package com.zzyy.rs.mapper;

import java.util.List;
import java.util.Map;

import com.zzyy.rs.entities.Account;

public interface GridMapper {

    Long getTotalElement();

    List<Account> getAccountLists();

    Account findAccountByNameAndMark(Map<String, Object> params);
}