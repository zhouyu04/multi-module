package com.zzyy.rs.controller;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.AppendService;
import com.zzyy.rs.utils.FtpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/add/")
public class AddController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AddController.class);

    @Autowired
    AppendService appendService;

    @Autowired
    AccountService accountService;

    @Autowired
    MultipartResolver multipartResolver;

    @RequestMapping(value = "input", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("AccountModel") AccountModel accountModel, Model model) {

        List<Account> params = new ArrayList<Account>();
        for (Account account : accountModel.getAccounts()) {
            if (StringUtils.isNotEmpty(account.getRsName()) && account.getOperateamount() != null) {
                params.add(account);
            }
        }
        List<Account> result = accountService.batchInsert(params);
        model.addAttribute("description", accountModel.getAccounts().get(0).getDescription());
        return "inputResult";
    }

    @RequestMapping(value = "again/input", method = RequestMethod.POST)
    public String twiceInput(@ModelAttribute("AccountModel") AccountModel accountModel, Model model, HttpServletRequest request) {
        AccountModel accountModel2 = new AccountModel();
        for (int i = 0; i < 10; i++) {
            accountModel2.add(new Account());
        }
        model.addAttribute("AccountModel", accountModel2);
        model.addAttribute("description", request.getParameter("describe"));
        return "input";
    }

    @RequestMapping(value = "inputEvent", method = RequestMethod.POST)
    public String inputEvent(Append append, Model model) {

        appendService.addAppend(append);
        AccountModel accountModel = new AccountModel();
        for (int i = 0; i < 10; i++) {
            accountModel.add(new Account());
        }

        model.addAttribute("AccountModel", accountModel);
        model.addAttribute("description", append.getDescription());
        return "input";
    }

    @RequestMapping(value = "repay", method = RequestMethod.GET)
    public String repayEvent(@RequestParam(value = "selectedId") Integer rsNum,
                             @RequestParam(value = "rsName") String rsName,
                             Model model) {
        AccountModel accountModel = new AccountModel();
        Account account = new Account();
        account.setId(rsNum);
        account.setRsName(rsName);
        accountModel.add(account);

        model.addAttribute("AccountModel", accountModel);
        return "input";
    }

    //上传
    @RequestMapping(value = "file",method = RequestMethod.POST)
    public String upload(HttpServletRequest request,Model model,@RequestParam("file")MultipartFile file){
        try {
//        multipartResolver.
        String fileName = file.getOriginalFilename();
        String path = "D:/temp/" + fileName;
        String filePath = "uploadFiles/court";
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
            file.transferTo(dir);
            FtpClientUtil fcu=new FtpClientUtil();
            fcu.setEncoding("GBK");
            fcu.connect("116.62.12.85", Integer.parseInt("21"),"huangkewei", "admin", false);//链接
            Boolean flag=fcu.setAndCreateWorkingDirectory(filePath);//创建文件夹
            InputStream in = new FileInputStream(path);
            fcu.putFile(fileName, in); //上传到ftp
            fcu.disconnect();//断开链接
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/测试一.txt";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
