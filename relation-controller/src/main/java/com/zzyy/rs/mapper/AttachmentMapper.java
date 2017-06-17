package com.zzyy.rs.mapper;

import com.zzyy.rs.entities.RelationAttachment;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public interface AttachmentMapper {
    Integer save(RelationAttachment params);

    List<String> findNames();
}
