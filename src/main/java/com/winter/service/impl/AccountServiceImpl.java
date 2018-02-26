package com.winter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.mapper.AccountMapper;
import com.winter.mapper.UserMapper;
import com.winter.model.Account;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addAccount(Account account) {
		String phone = account.getUser().getPhone();
		User user = new User();
		user.setPhone(phone);
		user = userMapper.findByCondition(user);
		account.setUserId(user.getId());
		// 如果是消费，查询余额
		if(account.getFlag() == 1) {
			double result = getAccountResult(account);
			if(result - account.getMoney() < 0) {
				return -1;
			}
		} 
		return accountMapper.addAccount(account);
	}

	@Override
	public DatagridResult<Account> findAllAccount(Account account) {
		PageHelper.startPage(account.getPage(), account.getRows());
		List<Account> list = accountMapper.findAllAccount();
		PageInfo<Account> pageInfo = new PageInfo<>(list);
		DatagridResult<Account> result = new DatagridResult<Account>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DatagridResult<Account> findByCondition(Account account) {
		PageHelper.startPage(account.getPage(), account.getRows());
		List<Account> list = accountMapper.findByCondition(account);
		PageInfo<Account> pageInfo = new PageInfo<>(list);
		DatagridResult<Account> result = new DatagridResult<Account>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Account> list = accountMapper.selectAccountByUserId(userId);
		PageInfo<Account> pageInfo = new PageInfo<>(list);
		DatagridResult<Account> result = new DatagridResult<Account>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public double findUserAccount(Account account) {
		double result = getAccountResult(account);
		return result;
	}

	private double getAccountResult(Account account) {
		double zheng = 0;
		try {
			account.setFlag(0);
			zheng = accountMapper.findUserAccount(account);
		} catch (NullPointerException e) {
			zheng = 0;
		}
		double fu = 0;
		try {
			account.setFlag(1);
			fu = accountMapper.findUserAccount(account);
		} catch (NullPointerException e) {
			fu = 0;
		}
		double result = zheng - fu;
		return result;
	}

	@Override
	public int updateAccount(Account account) {
		return accountMapper.updateAccount(account);
	}

}
