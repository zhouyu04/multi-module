package com.zzyy.rs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzyy.rs.dao.AccountDao;
import com.zzyy.rs.entities.Account;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.baseService;

import static com.zzyy.rs.utils.PinYingUtils.getAlpha;
import static com.zzyy.rs.utils.PinYingUtils.getPingYin;

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
		//构造完整的Account对象
		for (Account account:accounts) {
			String spell = getPingYin(account.getRsName());
			String firstSpell = getAlpha(account.getRsName());

			account.setSpell(spell);
			account.setFirstSpell(firstSpell);
			//获取对象，根据姓名
			Account accountTemp = accountDao.findAccountByNameAndMark(account.getRsName(),account.getPersonmark());
			if (accountTemp == null){
				//添加
				account.setAccumulatIncrease(account.getOperateamount());
				account.setBalance(account.getOperateamount());
				accountDao.insertAccount(account);
			}else{
				//修改
				accountTemp.setAccumulatIncrease(accountTemp.getAccumulatIncrease().add(account.getOperateamount()));
				accountTemp.setLastBalance(accountTemp.getBalance());
				accountTemp.setBalance(accountTemp.getBalance().add(account.getOperateamount()));
				accountTemp.setModifyDate(new Date());
				accountDao.updateAccount(accountTemp);
			}
		}
	}

}
