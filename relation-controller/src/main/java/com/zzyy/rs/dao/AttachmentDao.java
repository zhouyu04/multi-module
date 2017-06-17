package com.zzyy.rs.dao;

import com.zzyy.rs.entities.RelationAttachment;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public interface AttachmentDao {
    Integer save(RelationAttachment params);

    List<String> findNames();
}
