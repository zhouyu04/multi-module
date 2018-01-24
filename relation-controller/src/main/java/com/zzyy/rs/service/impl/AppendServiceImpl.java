package com.zzyy.rs.service.impl;

import com.zzyy.rs.dao.AppendDao;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.entities.Contestants;
import com.zzyy.rs.service.AppendService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by smt6 on 2017/3/16.
 */
@Service
public class AppendServiceImpl implements AppendService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AppendServiceImpl.class);

    @Autowired
    AppendDao appendDao;

    public void addAppend(Append append) {
        appendDao.addAppend(append);
    }

    public void batchAddContestants(List<Contestants> contestantLists) {
        appendDao.batchAddContestants(contestantLists);
    }
}
