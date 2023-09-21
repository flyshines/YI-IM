package com.itic.im.redis.config;

import com.itic.im.redis.dao.RedisDaoImpl;
import com.itic.im.redis.template.RedisImTemplateImpl;
import com.itic.im.redis.util.RedisTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author wanli.yang
 * @version 1.0
 * @date 2022/1/13 14:26
 */
public class ImRedisConfig {
	private static final Logger logger = LoggerFactory.getLogger(ImRedisConfig.class);
	@Autowired
	private RedisTemplateUtil redisTemplateUtil;

    @Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory factory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(factory);
		return container;
	}

	@Bean
	public RedisTemplateUtil redisTemplateUtil() {
		return new RedisTemplateUtil();
	}

	@Bean
	public RedisImTemplateImpl redisImTemplateImpl() {
    	return new RedisImTemplateImpl();
	}

	@Bean
	public RedisDaoImpl redisDaoImpl() {
		return new RedisDaoImpl();
	}
}
