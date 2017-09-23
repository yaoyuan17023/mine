package com.jnshu.test;

import com.jnshu.utils.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * created by 姚远 on 2017/9/20.
 */
public class RedisTest {
    @Test
    public void test(){
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.set("google输入法","真尼玛好用");
        System.out.println(jedis.get("google输入法"));
        RedisUtil.closeJedisPool(jedis);
        System.out.println(jedis.isConnected());
        System.out.println(jedis.get("google输入法"));
        System.out.println(jedis.isConnected());
    }
    @Test
    public void test2(){
        Jedis jedis =  RedisUtil.getJedis();
        jedis.set("google输入法","真尼玛好用");
        System.out.println(jedis.get("google输入法"));
        jedis.close();
        System.out.println(jedis.isConnected());
        jedis.disconnect();

    }
}

