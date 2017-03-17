package com.zzyy.rs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzyy.rs.dao.AccountDao;
import com.zzyy.rs.entities.Account;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.baseService;

@Service
public class AccountServiceImpl extends baseService implements AccountService{

	@Autowired
	AccountDao accountDao;
	

	public Long getTotalElement() {
		Long result = accountDao.getTotalElement();
		return result;
	}



	public List<Account> getAccountLists() {
		List<Account> result = accountDao.getAccountLists();
		return result;
	}

	public void batchInsert(List<Account> accounts) {
		accountDao.batchInsert(accounts);
	}

}
