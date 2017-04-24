package com.zzyy.rs.service.impl;

import com.zzyy.rs.dao.AccountDao;
import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.entities.User;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.baseService;
import com.zzyy.rs.utils.PinYingUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zzyy.rs.utils.PinYingUtils.getAlpha;
import static com.zzyy.rs.utils.PinYingUtils.getPingYin;

@Service
public class AccountServiceImpl extends baseService implements AccountService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountDao accountDao;

    @Autowired
    DozerBeanMapper dozerBeanMapper;


    public Long getTotalElement(Integer userNumber, String userName, Integer page, Integer rows, String sortOrder, String sortField) {

        Integer beginIndex = (page - 1) * rows;
        String nameSpell = null;
        if (StringUtils.isNotEmpty(userName)){
            nameSpell = PinYingUtils.getPingYin(userName);
        }

        Map<String, Object> params = new HashMap();
        params.put("userNumber", userNumber);
        params.put("userName", StringUtils.isEmpty(userName) ? null : userName);
        params.put("page", page);
        params.put("rows", rows);
        params.put("sortOrder", StringUtils.isEmpty(sortOrder) ? null : sortOrder);
        params.put("sortField", StringUtils.isEmpty(sortField) ? null : sortField);
        params.put("beginIndex", beginIndex);
        params.put("nameSpell",nameSpell);

        Long result = accountDao.getTotalElement(params);
        return result;
    }


    public List<Account> getAccountLists(Integer userNumber, String userName, Integer page, Integer rows, String sortOrder, String sortField) {

        Integer beginIndex = (page - 1) * rows;

        String nameSpell = null;
        if (StringUtils.isNotEmpty(userName)){
            nameSpell = PinYingUtils.getPingYin(userName);
        }

        Map<String, Object> params = new HashMap();
        params.put("userNumber", userNumber);
        params.put("userName", StringUtils.isEmpty(userName) ? null : userName);
        params.put("page", page);
        params.put("rows", rows);
        params.put("sortOrder", StringUtils.isEmpty(sortOrder) ? null : sortOrder);
        params.put("sortField", StringUtils.isEmpty(sortField) ? null : sortField);
        params.put("beginIndex",beginIndex);
        params.put("nameSpell",nameSpell);

        List<Account> result = accountDao.getAccountLists(params);
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
                account.setStatus(true);
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
                    if (account.getOperateamount().signum() > 0){
                        //收入
                        if (accountTemp.getAccumulatIncrease() == null){
                            accountTemp.setAccumulatIncrease(new BigDecimal(0));
                        }
                        accountTemp.setAccumulatIncrease(accountTemp.getAccumulatIncrease().add(account.getOperateamount()));
                        account.setDescription("[收入]"+account.getDescription());
                    }else{
                        //送出
                        if(accountTemp.getAccumulatDecrease() == null){
                            accountTemp.setAccumulatDecrease(new BigDecimal(0));
                        }
                        accountTemp.setAccumulatDecrease(accountTemp.getAccumulatDecrease().add(account.getOperateamount()));
                        account.setDescription("[送出]"+account.getDescription());
                    }
                    accountTemp.setLastBalance(accountTemp.getBalance());
                    accountTemp.setBalance(accountTemp.getBalance().add(account.getOperateamount()));
                    accountTemp.setModifyDate(new Date());
                    accountDao.updateAccount(accountTemp);
                    account.setStatus(true);
                    TransactionFlow transactionFlow = dozerBeanMapper.map(account, TransactionFlow.class);
                    accountDao.addTransactionFlow(transactionFlow);
                    account = accountTemp;
                }
            }
        }
        return accounts;
    }

    public User findUserAccountByUsername(String username) {


        return accountDao.findUserAccountByUsername(username);
    }

}
