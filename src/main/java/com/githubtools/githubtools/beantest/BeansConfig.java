package com.githubtools.githubtools.beantest;


import com.crossoverjie.distributed.lock.redis.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class BeansConfig {
    @Autowired
    private RedisLock redisLock ;

    @PostConstruct
    public void use() {
        String key = "key";
        String request = UUID.randomUUID().toString();
        try {
            boolean locktest = redisLock.tryLock(key, request);
            if (!locktest) {
                System.out.println("locked error");
                return;
            }
            //do something
            System.out.println("get lock and wait!");

        } finally {
            redisLock.unlock(key,request) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<>(90));
        for (int i = 0; i <= 50; i++) {
            pool.execute(new Runnable(){
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        pool.shutdown();

        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("still ... ");
        }
        long end = System.currentTimeMillis();
        System.out.println("一共处理了【{}】" + (end - start));
    }


    @Bean
    public RedisLock build(){
        RedisLock redisLock = new RedisLock() ;
        // HostAndPort hostAndPort = new HostAndPort("127.0.0.1",6379) ;
        // JedisCluster jedisCluster = new JedisCluster(hostAndPort) ;
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // Jedis 或 JedisCluster 都可以
        // redisLock.setJedisCluster(jedisCluster) ;
        redisLock.setJedis(jedis);
        return redisLock ;
    }
}
