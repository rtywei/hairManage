package com.winter.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.winter.model.Account;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.AccountService;
import com.winter.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
    private AccountService accountService;
	@Autowired
    private UserService userService;

	/**
	 * 添加账单
	 * 
	 * @param account
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addAccount(Account account){
    	User user = account.getUser();
    	if(user == null || StringUtils.isNullOrEmpty(user.getPhone())) {
    		return 0;
    	}
        return accountService.addAccount(account);
    }
    
    /**
     * 修改账户
     * 
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public int updateAccount(Account account){
        int i = accountService.updateAccount(account);
        return i;
    }
    
    /**
     * 默认界面查询所有数据
     * 
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAll" , produces = {"application/json;charset=UTF-8"})
    public DatagridResult<Account> findAllAccount(Account account) {
    	DatagridResult<Account> result = accountService.findAllAccount(account);
    	return result;
    }
    
    /**
     * 根据用户编号查询该用户所有账单
     * 
     * @param userId
     * @param page
     * @param rows
     * @return
     */
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
    
    /**
     * 账单条件查询
     * 
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findByCondition" , produces = {"application/json;charset=UTF-8"})
    public DatagridResult<Account> findByCondition(Account account) {
    	DatagridResult<Account> result = accountService.findByCondition(account);
    	return result;
    }
 
    /**
     * 通过用户编号查询用户的余额
     * 
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findUserBalance" , produces = {"application/json;charset=UTF-8"})
    public String findUserBalance(Account account) {
    	double result = accountService.findUserBalance(account);
        DecimalFormat df=new DecimalFormat("0.00");
        return df.format(result);
    }
    
    /**
     * 通过手机号查询账户余额
     * 
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findAccountByPhone")
    public String findAccountByPhone(String phone) {
    	User user = userService.findByPhone(phone);
    	Account account = new Account();
    	account.setUserId(user.getId());
		double result = accountService.findUserBalance(account );
		DecimalFormat df=new DecimalFormat("0.00");
	    return df.format(result);
    }
    
}
