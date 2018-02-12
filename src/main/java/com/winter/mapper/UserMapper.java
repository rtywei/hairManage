package com.winter.mapper;

import com.winter.model.User;

import java.util.List;

public interface UserMapper {
    public int deleteByPrimaryKey(Integer userId);

    public int insert(User record);

    public int updateByPrimaryKey(User record);

    public List<User> selectAllUser();
    
    public User selectByPrimaryKey(Integer id);
    
    public List<User> selectByUsername(String username);
    
    public List<User> selectByPhone(String username);
}