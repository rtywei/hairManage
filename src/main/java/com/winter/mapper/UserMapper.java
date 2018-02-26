package com.winter.mapper;

import com.winter.model.User;

import java.util.List;

public interface UserMapper {
	
	/**
	 * 根据主键删除客户信息
	 * 
	 * @param userId
	 * @return
	 */
    public int deleteByPrimaryKey(Integer userId);

    /**
     * 添加客户信息
     * 
     * @param record
     * @return
     */
    public int insert(User user);

    /**
     * 根据主键修改客户信息
     * 
     * @param user
     * @return
     */
    public int updateByPrimaryKey(User user);

    /**
     * 查询所有客户
     * 
     * @return
     */
    public List<User> selectAllUser();
    
    /**
     * 根据主键查询客户信息
     * @param id
     * @return
     */
    public User selectByPrimaryKey(Integer id);
    
    /**
     * 根据客户姓名查询客户信息
     * 
     * @param username
     * @return
     */
    public List<User> selectByUsername(String username);
    
    /**
     * 根据手机号查询客户信息
     * 
     * @param username
     * @return
     */
    public List<User> selectByPhone(String username);

	public List<User> findAllUsername();

	public User findByCondition(User user);
    
}