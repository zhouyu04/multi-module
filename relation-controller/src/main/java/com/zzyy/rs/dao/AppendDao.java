package com.zzyy.rs.dao;

import com.zzyy.rs.entities.Append;
import com.zzyy.rs.entities.Contestants;

import java.util.List;

/**
 * Created by smt6 on 2017/3/16.
 */
public interface AppendDao {

    void addAppend(Append append);

    void batchAddContestants(List<Contestants> contestantLists);
}
