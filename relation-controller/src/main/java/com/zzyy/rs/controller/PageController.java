package com.zzyy.rs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;

@Controller
@RequestMapping(value = "/")
public class PageController {

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
