package com.zzyy.rs.dao.impl;

import com.zzyy.rs.dao.AppendDao;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.mapper.AppendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by smt6 on 2017/3/16.
 */
@Repository
public class AppendDaoImpl implements AppendDao {



    @Autowired
    AppendMapper appendMapper;

    public void addAppend(Append append) {
        appendMapper.insert(append);
    }
}
