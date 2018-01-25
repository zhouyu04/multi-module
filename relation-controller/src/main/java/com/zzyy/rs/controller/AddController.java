package com.zzyy.rs.controller;

import com.zzyy.rs.entities.*;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.AppendService;
import com.zzyy.rs.service.AttachmentService;
import com.zzyy.rs.utils.FtpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
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
    AttachmentService attachmentService;

    //保存用户
    @RequestMapping("/contestants")
    @ResponseBody
    public String addContestants(HttpServletRequest request,
                                 HttpServletResponse response){
        try {
            String paramStr = request.getParameter("param"); // 获取参数Json
            JSONArray pList = JSONArray.fromObject(paramStr);
            List<Contestants> contestantLists = (List<Contestants>) JSONArray.toCollection(pList, Contestants.class);
            appendService.batchAddContestants(contestantLists);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

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
    public String upload(HttpServletRequest request,Model model,@RequestParam("file")MultipartFile[] file){
        try {
//        multipartResolver.
        String fileName =null;
        String path =null;
        String filePath = "uploadFiles/court";

        FtpClientUtil fcu=new FtpClientUtil();
        fcu.setEncoding("GBK");
        fcu.connect("116.62.12.85", Integer.parseInt("21"),"huangkewei", "admin", false);//链接
        Boolean flag=fcu.setAndCreateWorkingDirectory(filePath);//创建文件夹
            //多个文件批量遍历上传
            for (MultipartFile mul:file) {
                fileName = mul.getOriginalFilename();
                path = "D:/temp/" + fileName;
                File dir = new File(path);
                if(!dir.exists()){
                    dir.mkdirs();
                }

                mul.transferTo(dir);

                InputStream in = new FileInputStream(path);
                fcu.putFile(fileName, in); //上传到ftp
                //路径地址保存到数据库
                Long fileId = attachmentService.save(filePath,fileName);
                System.out.println("------------------------------"+fileId);
            }
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

    @ResponseBody
    @RequestMapping("fileUpload3")
    public String fileUpload3(@RequestParam(value="file",required= false) MultipartFile[] files, HttpSession session, User user) throws IOException{

        long  startTime=System.currentTimeMillis();
        System.out.println(files.length);
        System.out.println(user.getUsername()+"===="+user.getPassword());
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //这个方法最慢
                 /*FileUtils.writeByteArrayToFile(new File("E:\\"+file.getOriginalFilename()), file.getBytes());*/

                //这个方法最快
                file.transferTo(new File("E:\\"+file.getOriginalFilename()));

                //这个方法其次
                /*OutputStream os=new FileOutputStream("E:/"+file.getOriginalFilename());
                 //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
                 InputStream is=file.getInputStream();
                 byte[] bts = new byte[2048];
                 //一个一个字节的读取并写入
                 while(is.read(bts)!=-1)
                 {
                     os.write(bts);
                 }
                os.flush();
                os.close();
                is.close();*/
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法四的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success";
    }

    /**
     * 这里是获取上传文件状态信息的访问接口
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("getStatus")
    public UploadStatus getStatus(HttpSession session){
        return (UploadStatus)session.getAttribute("upload_status");
    }




}
