package com.jnshu.service;

import com.jnshu.entities.User;

/**
 * created by 姚远 on 2017/9/7.
 */
public interface UserService {
    public boolean isRightUser(String user, String password);
    User selectByName(String user);
    public int insert(String user,  String password);
    public User select(int id);
}
