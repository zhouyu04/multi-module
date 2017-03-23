package com.zzyy.rs.service;

import com.zzyy.rs.entities.TransactionFlow;

import java.util.List;

/**
 * Created by smt6 on 2017/3/23.
 */
public interface TransactionFlowService {
    Long getTotalElements(Integer userNumber, String userName, String describe, String status, Integer page, Integer rows, String sortOrder, String sortField);

    List<TransactionFlow> getTransactionFlows(Integer userNumber, String userName, String describe, String status, Integer page, Integer rows, String sortOrder, String sortField);
}
