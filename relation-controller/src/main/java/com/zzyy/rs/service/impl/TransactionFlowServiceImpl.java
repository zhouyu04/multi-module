package com.zzyy.rs.service.impl;

import com.zzyy.rs.entities.TransactionFlowExample;
import com.zzyy.rs.mapper.TransactionFlowMapper;
import com.zzyy.rs.service.TransactionFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smt6 on 2017/3/23.
 */
@Service
public class TransactionFlowServiceImpl implements TransactionFlowService {

    @Autowired
    TransactionFlowMapper transactionFlowMapper;

    public Long getTotalElements() {

        Long result = transactionFlowMapper.countByExample(new TransactionFlowExample());
        return result;
    }
}
