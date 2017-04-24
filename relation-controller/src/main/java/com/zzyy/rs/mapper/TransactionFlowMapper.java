package com.zzyy.rs.mapper;

import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.entities.TransactionFlowExample;
import java.util.List;

import com.zzyy.rs.entities.User;
import org.apache.ibatis.annotations.Param;

public interface TransactionFlowMapper {
    long countByExample(TransactionFlowExample example);

    int deleteByExample(TransactionFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransactionFlow record);

    int insertSelective(TransactionFlow record);

    List<TransactionFlow> selectByExample(TransactionFlowExample example);

    TransactionFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransactionFlow record, @Param("example") TransactionFlowExample example);

    int updateByExample(@Param("record") TransactionFlow record, @Param("example") TransactionFlowExample example);

    int updateByPrimaryKeySelective(TransactionFlow record);

    int updateByPrimaryKey(TransactionFlow record);

    int batchInsert(List<TransactionFlow> list);
}