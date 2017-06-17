package com.zzyy.rs.service.impl;

import com.zzyy.rs.dao.AttachmentDao;
import com.zzyy.rs.entities.RelationAttachment;
import com.zzyy.rs.service.AttachmentService;
import com.zzyy.rs.service.baseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

@Service
public class AttachmentServiceImp extends baseService implements AttachmentService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AttachmentServiceImp.class);
    @Autowired
    AttachmentDao attachmentDao;

    public Long save(String filePath, String fileName) {

        RelationAttachment relationAttachment = new RelationAttachment();
        relationAttachment.setFilename(fileName);
        relationAttachment.setFilepath(filePath);

         attachmentDao.save(relationAttachment);

        return relationAttachment.getFileid();
    }

    public List<String> findFileNames() {


        return attachmentDao.findNames();
    }
}
