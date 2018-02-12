package com.winter.mapper;

import java.util.List;

import com.winter.model.Account;

public interface AccountMapper {

	public int addAccount(Account account);

	public List<Account> findAllAccount();

	public List<Account> selectAccountByUserId(String userId);

	public List<Account> selectAccountByUserId(Integer userId);

}
