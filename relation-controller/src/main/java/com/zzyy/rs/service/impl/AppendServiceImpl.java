package com.zzyy.rs.service.impl;

import com.zzyy.rs.dao.AppendDao;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.service.AppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smt6 on 2017/3/16.
 */
@Service
public class AppendServiceImpl implements AppendService {

    @Autowired
    AppendDao appendDao;

    public void addAppend(Append append) {
        appendDao.addAppend(append);
    }
}
