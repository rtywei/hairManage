package com.winter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.winter.model.DatagridResult;
import com.winter.model.User;
import com.winter.service.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addUser(User user,HttpServletResponse response) throws IOException{
    	int result = userService.addUser(user);
    	if(result > 0) {
    		response.sendRedirect("/");
    		return null;
    	}else {
    		return "system/error";
    	}
    }
    
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public int deleteUser(User user){
        return userService.deleteUser(user);
    }
    
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public Integer updateUser(User user,HttpServletResponse response) throws IOException{
    	return  userService.update(user);
    }
    
    @RequestMapping(value = "/findAll", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public DatagridResult<User> selectAll(User user,ModelAndView model){
    	DatagridResult<User> result =  userService.selectAll(user);
    	return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findByCondition", produces = {"application/json;charset=UTF-8"})
    public DatagridResult<User> findById(User user,ModelAndView model){
    	DatagridResult<User> users = null;
    	if(!StringUtils.isEmpty(user.getUsername())) {
    		users = userService.selectByUsername(user);
    	}else if (!StringUtils.isEmpty(user.getPhone())) {
    		users = userService.selectByPhone(user);
    	}else {
    		users = userService.selectAll(user);
    	}
        return users;
    }
    
  /*  @ResponseBody
    @RequestMapping(value = "/findByUsername", produces = {"application/json;charset=UTF-8"})
    public ModelAndView findByUsername(User user,ModelAndView model){
    	model.addObject("users", userService.selectByUsername(user));
        return model;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findByPhone", produces = {"application/json;charset=UTF-8"})
    public ModelAndView selectByPhone(User user,ModelAndView model){
    	model.addObject("user", userService.selectByPhone(user));
        return model;
    }*/
    
    @ResponseBody
    @RequestMapping(value = "/findAllUsername", produces = {"application/json;charset=UTF-8"})
    public List<User> findAllUsername() {
    	return userService.findAllUsername();
    }
    
    
}
