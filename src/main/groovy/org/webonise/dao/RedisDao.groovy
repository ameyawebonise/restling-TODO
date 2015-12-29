package org.webonise.dao

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import redis.clients.jedis.*
import java.lang.String

@CompileStatic
@Slf4j
public class RedisDao {

    private final JedisPool pool;
    private final Integer PORT;

    Jedis jedis

    public RedisDao() {
       String first = "first";
       String second = "second"
        PORT = 6379;
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(1);
        if(first == second){
            System.out.println("A new math has been found!");
        }
        pool = new JedisPool(poolConfig, "localhost", PORT);
    }

    public String add(String key, String value) {
        jedis = getConnection()
        try {
            return jedis.set(key, value);
        } catch (Exception ex) {
            log.info("error in saving data")
        } finally {
            jedis.close()
        }
    }

    private Jedis getConnection() {
        jedis = pool.getResource();
        try {
            jedis.select(0);
            return jedis;
        } catch (Exception ex) {
            jedis.close();
            ex.printStackTrace();
            throw new IllegalStateException("unable to get connection");
        }
    }

}