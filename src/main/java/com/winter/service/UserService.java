package com.winter.service;

import com.winter.model.DatagridResult;
import com.winter.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    public int addUser(User user);
    
    public int deleteUser(User user);

	public int update(User user);
	
	public DatagridResult<User> selectUsersByPhone(User phone);
	
	public DatagridResult<User> selectByUsername(User username);

	public DatagridResult<User> selectAll(User user);

	public Object selectById(User user);

	public List<User> findAllUsername();

	public User findByPhone(String phone);
	

}
