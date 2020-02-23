package com.chong.mcspcgoodsservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * 配置rediesTemplate和redis的缓存管理器
 *
 * @author michael.chong
 */
@Configuration
public class MyRedisConfig {
    /**
     * 配置redisTemplate
     *
     * @param factory 连接工厂
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 连接工厂设置给redisTemplate
        redisTemplate.setConnectionFactory(factory);
        // key,value的设置
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // value为hash时,其内部name,value的设置
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 配置缓存管理器
     *
     * @param factory
     * @return cacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration
                        .defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(60))
                        .disableCachingNullValues()
                        .serializeValuesWith(
                                RedisSerializationContext.SerializationPair.fromSerializer(
                                        new GenericJackson2JsonRedisSerializer()
                                )
                        );
        return RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration).build();
    }

    /**
     * redis缓存的key生成器（cache相关注解不适用keygenerator时，默认是方法的参数做为key）
     */
    @Bean("keyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... parames) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName())
                        .append(":")
                        .append(method.getName());
                if (parames != null && parames.length != 0) {
                    for (Object obj : parames) {
                        sb.append(":");
                        sb.append(obj.toString());
                    }
                } else {
                    sb.append(":EMPTY-KEY");
                }
                return sb.toString();
            }
        };
    }
}