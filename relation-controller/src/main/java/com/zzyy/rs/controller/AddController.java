package com.zzyy.rs.controller;

import com.zzyy.rs.entities.Append;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.AppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;

@Controller
@RequestMapping(value = "/add/")
public class AddController {

	@Autowired
	AppendService appendService;

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("AccountModel") AccountModel accountModel,Model model){
		System.out.println(accountModel);
		for (Account account : accountModel.getAccounts()) {
			System.out.println(account.toString());
		}
		accountService.batchInsert(accountModel.getAccounts());
		model.addAttribute("description",accountModel.getAccounts().get(2).getDescription());
		return "input";
	}

	@RequestMapping(value = "inputEvent", method = RequestMethod.POST)
	public String inputEvent(Append append,Model model){

		appendService.addAppend(append);
		AccountModel accountModel = new AccountModel();
		for (int i = 0; i < 10; i++) {
			accountModel.add(new Account());
		}

		model.addAttribute("AccountModel", accountModel);
		model.addAttribute("description",append.getDescription());
		return "input";
	}
	
}
