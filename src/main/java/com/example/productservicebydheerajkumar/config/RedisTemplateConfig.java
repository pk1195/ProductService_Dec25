package com.example.productservicebydheerajkumar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
@Configuration
public class RedisTemplateConfig {

    //1. create object of jedis connection factory, it manages connection to redis server
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    //2.create object of redis template with k and v
    @Bean
   public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //3.set connection factory to redis template
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;

    }
}
