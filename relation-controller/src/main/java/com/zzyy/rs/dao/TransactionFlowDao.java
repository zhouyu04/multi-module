package com.zzyy.rs.dao;

import com.zzyy.rs.entities.TransactionFlow;

import java.util.List;
import java.util.Map;

/**
 * Created by smt6 on 2017/3/23.
 */
public interface TransactionFlowDao {
    Long getTotalTransactionElements(Map<String, Object> params);

    List<TransactionFlow> getTransactionFlows(Map<String, Object> params);

    Long getTransactionFlowsById(Integer rowID);
}
