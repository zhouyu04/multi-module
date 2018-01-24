package com.zzyy.rs.mapper;

import com.zzyy.rs.entities.Contestants;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ContestantsMapper extends Mapper<Contestants> {
    void batchAddContestants(@Param("contestantLists") List<Contestants> contestantLists);
}