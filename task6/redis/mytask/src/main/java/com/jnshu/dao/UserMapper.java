package com.jnshu.dao;

import com.jnshu.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insertSelective(User record);

    User selectByName(String user);

    String getUser(String user);

    String getPassword(String password);

    public User isRightUser(@Param("user") String user, @Param("password") String password);

    public int insert(@Param("user") String user, @Param("password") String password);

    public User select(int id);

    List<User> userAll();
}