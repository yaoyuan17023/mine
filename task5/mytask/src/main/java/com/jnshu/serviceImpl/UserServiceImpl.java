package com.jnshu.serviceImpl;

import com.jnshu.dao.UserMapper;
import com.jnshu.entities.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by 姚远 on 2017/9/7.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean isRightUser(String user,String password){
        System.out.println("输入的账号:" + user + "输入的密码:" + password);
        if (userMapper.isRightUser(user,password)==null){
            return false;
        }return true;
    }
    public User selectByName(String user){
        return userMapper.selectByName(user);
    }
    public int insert(String user, String password){
        return  userMapper.insert(user,password);
    }
    public User select(int id){
        return userMapper.select(id);
    }
}

