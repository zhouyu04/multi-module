package com.zzyy.rs.controller;

import com.zzyy.rs.service.AttachmentService;
import com.zzyy.rs.utils.FtpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
@Controller
@RequestMapping(value = "/show/")
public class ShowController {

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "name")
    public String showName(@RequestParam(value = "fileName" ) String fileName, HttpServletResponse response, HttpServletRequest request){

        FtpClientUtil fcu=new FtpClientUtil();
        try {
            fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
            System.out.println("uploadFiles/court/"+fileName);
            OutputStream out = response.getOutputStream();
            fcu.connect("116.62.12.85", Integer.parseInt("21"),"huangkewei", "admin", false);//链接
            fcu.cd("uploadFiles/court");
            fcu.getFile(fileName,out);
            fcu.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "show";
    }

}
