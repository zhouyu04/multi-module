package com.zzyy.rs.mapper;

import java.util.List;

import com.zzyy.rs.entities.Account;

public interface GridMapper {

	Long getTotalElement();

	List<Account> getAccountLists();

}
