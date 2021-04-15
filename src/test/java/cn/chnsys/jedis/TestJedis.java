package cn.chnsys.jedis;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试jedis
 *
 * @author wangchao
 * @version 1.0
 */
public class TestJedis {

    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    @Test
    public void testString() {
        System.out.println(jedis.ping());
        jedis.flushDB();
        jedis.flushAll();
        String set = jedis.set("name", "paltryer");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        jedis.del("name");
        Boolean name1 = jedis.exists("name");
        System.out.println(name1);
        String name = jedis.type("name");
        System.out.println(name);
        jedis.rename("name", "username");

    }

    @Test
    public void testList() {
//        jedis.lpush("list", "1", "2", "3", "4");
//        jedis.lpush("list", "one");
//        jedis.lpush("list", "two");
//        jedis.lpush("list", "three");
//
//        List<String> list = jedis.lrange("list", 0, -1);
//        List<String> list = jedis.lrange("list", 0, 3);
//
//        jedis.lrem("list", 1, "1");
//        jedis.lpush("list", "four");
//        List<String> list = jedis.lrange("list", 0, -1);
//        System.out.println(list);
//
//        jedis.lpop("list");
//        List<String> list1 = jedis.lrange("list", 0, -1);
//        System.out.println(list1);
//        jedis.rpop("list");
//        List<String> list2 = jedis.lrange("list", 0, -1);
//        System.out.println(list2);
//
//        Long list = jedis.llen("list");
//        System.out.println(list);
//
//        jedis.lset("list", 1, "wangchao");
//        System.out.println(jedis.lrange("list", 0, -1));

        System.out.println(jedis.lindex("list", 2));
    }

    @Test
    public void testSet() {
        jedis.sadd("set", "s1", "s2", "s3", "s4");
//        System.out.println(jedis.smembers("set"));
//        jedis.srem("set","s1");
//        jedis.spop("set");
//        System.out.println(jedis.scard("set"));
//        System.out.println(jedis.sismember("set", "s55"));
    }

    @Test
    public void testHash() {
//        Map<String, String> hashMap = new HashMap<>();
//        hashMap.put("key1","value1");
//        hashMap.put("key2","value2");
//        hashMap.put("key3","value3");
//        hashMap.put("key4","value4");
//        jedis.hmset("hash",hashMap);

//        jedis.hset("hash","key5","value5");

//        System.out.println(jedis.hgetAll("hash"));

//        System.out.println(jedis.hkeys("hash"));
//
//        jedis.hdel("hash","key1");

//        System.out.println(jedis.hexists("hash", "key1"));

//        System.out.println(jedis.hmget("hash", "key1", "key2"));
    }

    @Test
    public void testTX() {
        Transaction multi = jedis.multi();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "paltryer");
        jsonObject.put("age", 18);
        try {
            multi.set("user1", jsonObject.toJSONString());
            multi.exec();
        } catch (Exception e) {
            //出现异常 放弃事务
            multi.discard();
        }
    }


}
