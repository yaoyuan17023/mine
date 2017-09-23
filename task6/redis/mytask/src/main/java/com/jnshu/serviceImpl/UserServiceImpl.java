package com.jnshu.serviceImpl;

import com.jnshu.dao.UserMapper;
import com.jnshu.entities.User;
import com.jnshu.service.UserService;
import com.jnshu.utils.MemcachedUtil;
import com.jnshu.utils.RedisUtil;
import com.jnshu.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * created by 姚远 on 2017/9/7.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean isRightUser(String user,String password){
        System.out.println("输入的账号:" + user + "输入的密码:" + password);
        if (MemcachedUtil.get("users") == null){
            System.out.println("查数据库了");
            User user1=userMapper.isRightUser(user,password);
            if (user1 != null){
                return true;
            }
        }
        System.out.println("查缓存");
        return true;
//    if (userMapper.isRightUser(user,password) == null){
//        return false;
//    }return true;
    }

    public List<User> userAll(){
//        List<User> users=userMapper.userAll();
//        MemcachedUtil.set("users",users);
//        System.out.println(MemcachedUtil.get("users"));
//        return userMapper.userAll();
//        Jedis redis = new Jedis("127.0.0.1",6379);
        Jedis redis=RedisUtil.getJedis();
        if(redis.get("users")==null) {
            List user = userMapper.userAll();
            redis.set("users".getBytes(), SerializeUtil. serialize(user));
            System.out.println("这是数据库");
            return user;
        }else{
            System.out.println("这是缓存");
            byte[] value = redis.get("users".getBytes());
            redis.close();
            return (List)SerializeUtil. unserialize(value);
        }
    }
    public User selectByName(String user){
        return userMapper.selectByName(user);
    }
    public int insert(String user, String password) {
        Integer i=userMapper.insert(user,password);
        User user1=userMapper.selectByName(user);
        System.out.println(user1);
        MemcachedUtil.set("users",user1);
        System.out.println(MemcachedUtil.get("users"));
        return i;
    }
    public User select(int id){
        return userMapper.select(id);
    }
}

