package com.winter.service;

import com.winter.model.Account;
import com.winter.model.DatagridResult;

public interface AccountService {

	public int addAccount(Account account);

	public DatagridResult<Account> findAllAccount(Account account);

	public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows);

	public DatagridResult<Account> findByCondition(Account account);

	public Double findUserAccount(Account account);

	public int updateAccount(Account account);

}
