package com.jnshu.service;

import com.jnshu.entities.User;

import java.util.List;

/**
 * created by 姚远 on 2017/9/7.
 */
public interface UserService {
    public boolean isRightUser(String user, String password);
    User selectByName(String user);
    public int insert(User user);
    public User select(int id);
    public List<User> userAll();
    public boolean sendEmail(String email);
//    public void sendPicture();
    public void qingniu(String file);
//    public void sendMessage(String mobile,String number);
}
