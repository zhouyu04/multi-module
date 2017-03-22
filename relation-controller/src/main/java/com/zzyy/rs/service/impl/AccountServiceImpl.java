package com.zzyy.rs.service.impl;

import com.zzyy.rs.dao.AccountDao;
import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.baseService;
import org.dozer.DozerBeanMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.zzyy.rs.utils.PinYingUtils.getAlpha;
import static com.zzyy.rs.utils.PinYingUtils.getPingYin;
import static jdk.nashorn.internal.objects.NativeDebug.map;

@Service
public class AccountServiceImpl extends baseService implements AccountService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountDao accountDao;

    @Autowired
    DozerBeanMapper dozerBeanMapper;


    public Long getTotalElement() {
        Long result = accountDao.getTotalElement();
        return result;
    }


    public List<Account> getAccountLists() {
        List<Account> result = accountDao.getAccountLists();
        return result;
    }

    @Transactional
    public List<Account> batchInsert(List<Account> accounts) {
        //构造完整的Account对象
        for (Account account : accounts) {
            String spell = getPingYin(account.getRsName());
            String firstSpell = getAlpha(account.getRsName());

            account.setSpell(spell);
            account.setFirstSpell(firstSpell);
            //ID是否存在
            Account acountById = accountDao.findAccountById(account.getId());
            if (acountById == null) {
                //添加
                account.setAccumulatIncrease(account.getOperateamount());
                account.setBalance(account.getOperateamount());
                accountDao.insertAccount(account);

                TransactionFlow transactionFlow = dozerBeanMapper.map(account, TransactionFlow.class);
                accountDao.addTransactionFlow(transactionFlow);
            } else {
                //获取对象，根据 ID 姓名
                Account accountTemp = accountDao.findAccountByNameAndMark(account.getId(), account.getRsName(), spell);
                if (accountTemp == null) {
                    //重新验证
                    account.setStatus(false);
                    TransactionFlow transactionFlow = dozerBeanMapper.map(account, TransactionFlow.class);
                } else {
                    //修改
                    accountTemp.setAccumulatIncrease(accountTemp.getAccumulatIncrease().add(account.getOperateamount()));
                    accountTemp.setLastBalance(accountTemp.getBalance());
                    accountTemp.setBalance(accountTemp.getBalance().add(account.getOperateamount()));
                    accountTemp.setModifyDate(new Date());
                    accountDao.updateAccount(accountTemp);
                    accountTemp.setStatus(true);
                    TransactionFlow transactionFlow = dozerBeanMapper.map(account, TransactionFlow.class);
                    transactionFlow.setStatus(true);
                    accountDao.addTransactionFlow(transactionFlow);
                    account = accountTemp;
                }
            }
        }
        return accounts;
    }

}
