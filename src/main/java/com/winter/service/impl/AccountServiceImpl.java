package com.winter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.mapper.AccountMapper;
import com.winter.model.Account;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountMapper accountMapper;


	@Override
	public int addAccount(Account account) {
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
	public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Account> list = accountMapper.selectAccountByUserId(userId);
		PageInfo<Account> pageInfo = new PageInfo<>(list);
		DatagridResult<Account> result = new DatagridResult<Account>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
