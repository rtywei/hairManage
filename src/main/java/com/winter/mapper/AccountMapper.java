package com.winter.mapper;

import java.util.List;

import com.winter.model.Account;

public interface AccountMapper {

	/**
	 * 添加账户记录
	 * 
	 * @param account
	 * @return
	 */
	public int addAccount(Account account);

	/**
	 * 查询所有账户几乎
	 * 
	 * @return
	 */
	public List<Account> findAllAccount();

	/**
	 * 根据用户查询账户信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Account> selectAccountByUserId(Integer userId);

	/**
	 * 根据条件查询账户信息
	 * 
	 * @param account
	 * @return
	 */
	public List<Account> findByCondition(Account account);

	/**
	 * 查询账户金额
	 * 
	 * @param account
	 * @return
	 */
	public Double findUserAccount(Account account);

	/**
	 * 修改账户
	 * 
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);

}
