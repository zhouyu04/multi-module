package com.zzyy.rs.controller;

import java.util.List;

import com.zzyy.rs.entities.TransactionFlow;
import com.zzyy.rs.entities.TransactionFlowExample;
import com.zzyy.rs.service.TransactionFlowService;
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

	@Autowired
	TransactionFlowService transactionFlowService;

	@RequestMapping(value = "account", method = RequestMethod.GET)
	@ResponseBody
	public GridData totalAccounts(@RequestParam(value = "userNumber", required = false) Integer userNumber,
								  @RequestParam(value = "userName", required = false) String userName,
								  @RequestParam(value = "page", required = false) Integer page,
								  @RequestParam(value = "rows", required = false) Integer rows,
								  @RequestParam(value = "sord") String sortOrder,
								  @RequestParam(value = "sidx") String sortField) {
		GridData result = new GridData();
		Long records = accountService.getTotalElement(userNumber,userName,page,rows,sortOrder,sortField);// 数据库查除总条数
		
		long totalPage = records % rows == 0 ? records / rows : records / rows + 1;// 总页数
		

		List<Account> accountList = accountService.getAccountLists(userNumber,userName,page,rows,sortOrder,sortField);// 实际数据
		
		result.setPage(page);
		result.setTotal((int) totalPage);
		result.setRecords(records);
		if (accountList != null) {
			result.getRows().addAll(accountList);
		}
		return result;
	}

	@RequestMapping(value = "transactionFlow", method = RequestMethod.GET)
	@ResponseBody
	public GridData transactionFlow(@RequestParam(value = "userNumber", required = false) Integer userNumber,
									@RequestParam(value = "userName", required = false) String userName,
									@RequestParam(value = "describe", required = false) String describe,
									@RequestParam(value = "status", required = false) String status,
									@RequestParam(value = "page", required = false) Integer page,
									@RequestParam(value = "rows", required = false) Integer rows,
									@RequestParam(value = "sord") String sortOrder,
									@RequestParam(value = "sidx") String sortField){
		GridData result = new GridData();

		Long records = transactionFlowService.getTotalElements(userNumber,userName,describe,status,page,rows,sortOrder,sortField);// 数据库查除总条数

		long totalPage = records % rows == 0 ? records / rows : records / rows + 1;// 总页数
		List<TransactionFlow> transactionFlowList = transactionFlowService.getTransactionFlows(userNumber,userName,describe,status,page,rows,sortOrder,sortField);// 实际数据
		result.setPage(page);
		result.setTotal((int) totalPage);
		result.setRecords(records);
		if (transactionFlowList != null) {
			result.getRows().addAll(transactionFlowList);
		}

		return result;
	}


	@RequestMapping(value = "detail/transactionFlow", method = RequestMethod.GET)
	@ResponseBody
	public GridData detailTransaction(@RequestParam(value = "rowId") Integer rowId,
									  @RequestParam(value = "rows", required = false) Integer rows,
									  @RequestParam(value = "page", required = false) Integer page,
									  @RequestParam(value = "sord") String sortOrder,
									  @RequestParam(value = "sidx") String sortField){
		GridData result = new GridData();
		Long records = transactionFlowService.getTotalElementsById(rowId);//
		long totalPage = records % rows == 0 ? records / rows : records / rows + 1;// 总页数

		List<TransactionFlow> transactionFlowList = transactionFlowService.getTransactionFlows(rowId,null,null,null,page,rows,sortOrder,sortField);// 实际数据
		result.setPage(page);
		result.setTotal((int) totalPage);
		result.setRecords(records);
		if (transactionFlowList != null) {
			result.getRows().addAll(transactionFlowList);
		}
		return result;
	}

	@RequestMapping(value = "empty", method = RequestMethod.GET)
	@ResponseBody
	public GridData empty(){
		return null;
	}
}
