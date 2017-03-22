package com.zzyy.rs.controller;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.AppendService;
import com.zzyy.rs.service.impl.AccountServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "input", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("AccountModel") AccountModel accountModel, Model model) {

        List<Account> params = new ArrayList<Account>();
        for (Account account : accountModel.getAccounts()) {
            if (StringUtils.isNotEmpty(account.getRsName()) && account.getOperateamount() != null){
                params.add(account);
            }
        }
        List<Account> result = accountService.batchInsert(params);
        model.addAttribute("description", accountModel.getAccounts().get(0).getDescription());
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

}
