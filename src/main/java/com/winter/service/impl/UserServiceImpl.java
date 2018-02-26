package com.winter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.mapper.UserMapper;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
    
    @Override
    public int deleteUser(User user) {
        return userMapper.deleteByPrimaryKey(user.getId());
    }

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public DatagridResult<User> selectAll(User user) {
		PageHelper.startPage(user.getPage(),user.getRows());
		List<User> list = userMapper.selectAllUser();
		PageInfo<User> pageInfo = new PageInfo<>(list);
		DatagridResult<User> result = new DatagridResult<User>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public DatagridResult<User> selectByUsername(User user) {
		PageHelper.startPage(user.getPage(),user.getRows());
		List<User> list = userMapper.selectByUsername(user.getUsername());
		PageInfo<User> pageInfo = new PageInfo<>(list);
		DatagridResult<User> result = new DatagridResult<User>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public DatagridResult<User> selectByPhone(User user) {
		PageHelper.startPage(user.getPage(),user.getRows());
		List<User> list = userMapper.selectByPhone(user.getPhone());
		PageInfo<User> pageInfo = new PageInfo<>(list);
		DatagridResult<User> result = new DatagridResult<User>();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Object selectById(User user) {
		return userMapper.selectByPrimaryKey(user.getId());
	}

	@Override
	public List<User> findAllUsername() {
		return userMapper.findAllUsername();
	}
    
    
    
/*
    
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * 
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }*/
}
