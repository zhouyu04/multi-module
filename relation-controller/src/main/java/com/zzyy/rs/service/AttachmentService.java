package com.zzyy.rs.service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public interface AttachmentService {


    Long save(String filePath, String fileName);

    List<String> findFileNames();
}
