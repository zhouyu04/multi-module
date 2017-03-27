package com.zzyy.rs.controller;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.AccountModel;
import com.zzyy.rs.entities.Append;
import com.zzyy.rs.service.AccountService;
import com.zzyy.rs.service.AppendService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

}
