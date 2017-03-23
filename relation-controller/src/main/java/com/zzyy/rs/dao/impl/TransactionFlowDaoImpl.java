package com.zzyy.rs.dao.impl;

import com.zzyy.rs.dao.TransactionFlowDao;
import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.mapper.GridMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by smt6 on 2017/3/23.
 */
@Repository
public class TransactionFlowDaoImpl implements TransactionFlowDao {

    @Autowired
    GridMapper gridMapper;

    public Long getTotalTransactionElements(Map<String, Object> params) {

        return gridMapper.getTotalTransactionElements(params);
    }

    public List<TransactionFlow> getTransactionFlows(Map<String, Object> params) {
        return gridMapper.getTransactionFlows(params);
    }
}
