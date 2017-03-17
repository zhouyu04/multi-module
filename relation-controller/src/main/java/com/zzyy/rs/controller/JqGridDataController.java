package com.zzyy.rs.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzyy.rs.entities.Account;
import com.zzyy.rs.entities.GridData;
import com.zzyy.rs.service.AccountService;

@Controller
@RequestMapping(value = "/rs/")
public class JqGridDataController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JqGridDataController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "account", method = RequestMethod.GET)
	@ResponseBody
	public GridData totalTransactionFlow(
			@RequestParam(value = "businessRole", required = false, defaultValue = "") String businessRole,
			@RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String afterTime,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sord") String sortOrder, @RequestParam(value = "sidx") String sortField,
			@RequestParam(value = "globalId", required = false) String globalId,
			@RequestParam(value = "orderNo", required = false) String orderNo,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "idCardNo", required = false) String idCardNo) {
		GridData result = new GridData();
		Long records = accountService.getTotalElement();// 数据库查除总条数
		
		long totalPage = records % rows == 0 ? records / rows : records / rows + 1;// 总页数
		

		List<Account> accountList = accountService.getAccountLists();// 实际数据
		
		result.setPage(page);
		result.setTotal((int) totalPage);
		result.setRecords(records);
		if (accountList != null) {
			result.getRows().addAll(accountList);
		}
		return result;
	}

}
