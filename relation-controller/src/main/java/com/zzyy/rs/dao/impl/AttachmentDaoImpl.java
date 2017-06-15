package com.zzyy.rs.dao.impl;

import com.zzyy.rs.dao.AttachmentDao;
import com.zzyy.rs.entities.RelationAttachment;
import com.zzyy.rs.mapper.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
@Repository
public class AttachmentDaoImpl implements AttachmentDao {

    @Autowired
    AttachmentMapper attachmentMapper;

    public Integer save(RelationAttachment params) {
        return attachmentMapper.save(params);
    }
}
