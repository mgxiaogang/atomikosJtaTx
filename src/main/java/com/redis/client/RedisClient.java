package com.redis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

public class RedisClient {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Jedis jedis = RedisUtil.getJedis();
        int i = 0;
        jedis.watch("b");
        Transaction transaction = jedis.multi();
        Response<String> a = transaction.set("a", "120");
//        System.out.println(a.get());
        Response<String> b = transaction.set("b", "2");
//        System.out.println(b.get());
        List<Object> results = transaction.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();

    }
}
