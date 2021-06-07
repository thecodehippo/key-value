package com.javalearning.keyvalue;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;

@Repository
public class KeyValueRepository {

    URI redisUri;

    {
        try {
            redisUri = new URI(System.getenv("REDISCLOUD_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    JedisPool pool = new JedisPool(new JedisPoolConfig(),
            redisUri.getHost(),
            redisUri.getPort(),
            Protocol.DEFAULT_TIMEOUT,
            redisUri.getUserInfo().split(":",2)[1]);

    Jedis jedis = pool.getResource();

    void addKeyValue(String key, String value) {
        jedis.set(key, value);
    }

    String getValue(String key) {
        return jedis.get(key);
    }


}
