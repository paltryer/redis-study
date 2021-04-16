package com.chnsys;

import com.chnsys.pojo.User;
import com.chnsys.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisBootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
//        redisTemplate.opsForList();
//        redisTemplate.opsForValue();
        // 获取redis 连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        redisTemplate.opsForValue().set("name", "wangchao");
        System.out.println(redisTemplate.opsForValue().get("name"));

    }


    @Test
    public void test() throws JsonProcessingException {
//        System.out.println(redisUtil.set("wangchao", "superhero!"));
        System.out.println(redisUtil.get("wangchao"));
    }
}
