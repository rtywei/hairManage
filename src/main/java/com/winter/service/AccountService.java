package com.winter.service;

import java.util.List;

import com.winter.model.Account;
import com.winter.model.DatagridResult;

public interface AccountService {

	public int addAccount(Account account);

	public DatagridResult<Account> findAllAccount(Account account);

	public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows);

}
