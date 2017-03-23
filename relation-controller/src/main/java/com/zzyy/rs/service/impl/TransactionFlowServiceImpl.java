package com.zzyy.rs.service.impl;

import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.entities.TransactionFlowExample;
import com.zzyy.rs.mapper.GridMapper;
import com.zzyy.rs.mapper.TransactionFlowMapper;
import com.zzyy.rs.service.TransactionFlowService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smt6 on 2017/3/23.
 */
@Service
public class TransactionFlowServiceImpl implements TransactionFlowService {

    @Autowired
    TransactionFlowMapper transactionFlowMapper;

    @Autowired
    GridMapper gridMapper;

    public Long getTotalElements(Integer userNumber, String userName, String describe, String status, Integer page,
                                 Integer rows, String sortOrder, String sortField) {

        Integer beginIndex = (page - 1) * rows;

        Map<String, Object> params = new HashMap();
        params.put("userNumber", userNumber);
        params.put("userName", StringUtils.isEmpty(userName) ? null : userName);
        params.put("describe", StringUtils.isEmpty(describe) ? null : describe);
        params.put("status", StringUtils.isEmpty(status) ? null : status);
        params.put("page", page);
        params.put("rows", rows);
        params.put("sortOrder", StringUtils.isEmpty(sortOrder) ? null : sortOrder);
        params.put("sortField", StringUtils.isEmpty(sortField) ? null : sortField);
        params.put("beginIndex", beginIndex);

        Long result = gridMapper.getTotalTransactionElements(params);
        return result;
    }

    public List<TransactionFlow> getTransactionFlows(Integer userNumber, String userName, String describe, String status, Integer page, Integer rows, String sortOrder, String sortField) {
        Integer beginIndex = (page - 1) * rows;

        Map<String, Object> params = new HashMap();
        params.put("userNumber", userNumber);
        params.put("userName", StringUtils.isEmpty(userName) ? null : userName);
        params.put("describe", StringUtils.isEmpty(describe) ? null : describe);
        params.put("status", StringUtils.isEmpty(status) ? null : status);
        params.put("page", page);
        params.put("rows", rows);
        params.put("sortOrder", StringUtils.isEmpty(sortOrder) ? null : sortOrder);
        params.put("sortField", StringUtils.isEmpty(sortField) ? null : sortField);
        params.put("beginIndex", beginIndex);

        List<TransactionFlow> result = gridMapper.getTransactionFlows(params);
        return result;
    }
}
