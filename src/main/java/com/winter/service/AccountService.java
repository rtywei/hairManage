package com.winter.service;

import com.winter.model.Account;
import com.winter.model.DatagridResult;

public interface AccountService {

	/**
	 * 田间账户信息
	 * 
	 * @param account
	 * @return
	 */
	public int addAccount(Account account);

	/**
	 * 查询所有账户信息
	 * 
	 * @param account
	 * @return
	 */
	public DatagridResult<Account> findAllAccount(Account account);

	/**
	 * 查询该客户下的所有账户信息
	 * 
	 * @param userId
	 * @param page
	 * @param rows
	 * @return
	 */
	public DatagridResult<Account> findByUserId(Integer userId, Integer page, Integer rows);

	/**
	 * 根据条件查询账户信息
	 * 
	 * @param account
	 * @return
	 */
	public DatagridResult<Account> findByCondition(Account account);

	/**
	 * 查询账户金额
	 * 
	 * @param account
	 * @return
	 */
	public double findUserAccount(Account account);

	/**
	 * 根据客户修改账户信息
	 * 
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);

}
