package com.winter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.winter.model.Account;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.AccountService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addAccount(Account account){
    	User user = account.getUser();
    	if(user == null || StringUtils.isNullOrEmpty(user.getPhone())) {
    		return 0;
    	}
        return accountService.addAccount(account);
    }
    
    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public int updateAccount(Account account){
        int i = accountService.updateAccount(account);
        return i;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findAll" , produces = {"application/json;charset=UTF-8"})
    public DatagridResult<Account> findAllAcoount(Account account) {
    	DatagridResult<Account> result = accountService.findAllAccount(account);
    	return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findByUserId" , produces = {"application/json;charset=UTF-8"})
    public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows) {
    	if(page == null) {
    		page = 1;
    	}
    	if(rows == null) {
    		rows = 10;
    	}
    	DatagridResult<Account> result = accountService.findByUserId(userId, page, rows);
    	return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findByCondition" , produces = {"application/json;charset=UTF-8"})
    public DatagridResult<Account> findByCondition(Account account) {
    	DatagridResult<Account> result = accountService.findByCondition(account);
    	return result;
    }
 
    @ResponseBody
    @RequestMapping(value = "/findUserAccount" , produces = {"application/json;charset=UTF-8"})
    public Double findUserAccount(Account account) {
    	Double result = accountService.findUserAccount(account);
    	return result;
    }
}
