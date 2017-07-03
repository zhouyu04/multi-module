package com.zzyy.rs.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zzyy.rs.service.AttachmentService;
import com.zzyy.rs.utils.Doc2Pdf;
import com.zzyy.rs.utils.FtpClientUtil;
import com.zzyy.rs.utils.WordGenerator;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class PageController {
	FtpClientUtil fcu=new FtpClientUtil();

	@Autowired
	AttachmentService attachmentService;


	@RequestMapping
	public String index(){

		return "index";
	}

	@RequestMapping(value = "rs/coming",method = RequestMethod.GET)
	public String coming(){
		
		return "success";
	}

	@RequestMapping(value = "rs/list/transactionFlow")
	public String toTransactionFlow(){

		return "transactionFlow";
	}

	@RequestMapping(value = "rs/list/upload")
	public String toUpload(){

		return "upload";
	}

	@RequestMapping(value = "rs/list/show")
	public String toShow(Model model){
		List<String> lists = null;
		try {
			fcu.connect("116.62.12.85", Integer.parseInt("21"),"huangkewei", "admin", false);//链接
			lists = fcu.list("uploadFiles/court");
			fcu.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		List<String> lists = attachmentService.findFileNames();
//		for (String s:lists) {
//			System.out.println(s);
//		}
		model.addAttribute("lists",lists);

		return "show";
	}

	@RequestMapping(value = "rs/list/word")
	public String word(HttpServletRequest request, HttpServletResponse response){
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			request.setCharacterEncoding("utf-8");
			String name = "测试被告用户02";
			map.put("name",name);

			File file = null;
			InputStream fin = null;
			ServletOutputStream out = null;

			file = WordGenerator.createDoc(map, "resume");
			fin = new FileInputStream(file);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			response.addHeader("Content-Disposition", "attachment;filename="+new String(("湖南省攸县人民法院.doc").getBytes("GB2312"),"iso8859-1"));

			out = response.getOutputStream();
			byte[] buffer = new byte[512];  // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	@RequestMapping(value = "rs/list/pdf")
	public String pdf(HttpServletRequest request, HttpServletResponse response){
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			request.setCharacterEncoding("utf-8");
			String name = "测试被告用户";
			map.put("name",name);

			File file = null;
			InputStream fin = null;
			ServletOutputStream out = null;


			file = WordGenerator.createDoc(map, "resume");
			fin = new FileInputStream(file);


			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			response.addHeader("Content-Disposition", "attachment;filename="+new String(("湖南省攸县人民法院.pdf").getBytes("GB2312"),"iso8859-1"));
			response.setContentType("application/pdf");

			out = response.getOutputStream();
			byte[] buffer = new byte[512];  // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	@RequestMapping(value = "add/addEvent")
	public String addEvent(){
		
		return "inputEvent";
	}

	@RequestMapping(value = "add/input", method = RequestMethod.GET)
	public String add(Model model){
		AccountModel accountModel = new AccountModel();
		accountModel.add(new Account());
		accountModel.add(new Account());

		model.addAttribute("AccountModel", accountModel);
		return "input";
	}
}
