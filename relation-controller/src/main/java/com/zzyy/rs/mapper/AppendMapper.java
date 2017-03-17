package com.zzyy.rs.mapper;

import com.zzyy.rs.entities.Append;
import com.zzyy.rs.entities.AppendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppendMapper {
    long countByExample(AppendExample example);

    int deleteByExample(AppendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Append record);

    int insertSelective(Append record);

    List<Append> selectByExample(AppendExample example);

    Append selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Append record, @Param("example") AppendExample example);

    int updateByExample(@Param("record") Append record, @Param("example") AppendExample example);

    int updateByPrimaryKeySelective(Append record);

    int updateByPrimaryKey(Append record);

    int batchInsert(List<Append> list);
}