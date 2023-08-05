package com.nitesh.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.nitesh.springboot.entity.Persons;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {


	@Bean
	public JedisConnectionFactory getConnectionFactory() {


		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();

		configuration.setHostName("localhost");
		configuration.setPort(6379);

		return new JedisConnectionFactory(configuration);

	}


	@Bean
	public RedisTemplate<String, Persons> getRedisTemplate(){

		RedisTemplate<String, Persons> rt = new RedisTemplate<>();
		rt.setConnectionFactory(getConnectionFactory());
		rt.setKeySerializer(new StringRedisSerializer());

		//rt.setHashKeySerializer(new StringRedisSerializer());

		rt.setHashKeySerializer(new JdkSerializationRedisSerializer());
		rt.setHashValueSerializer(new JdkSerializationRedisSerializer());
		rt.setValueSerializer(new JdkSerializationRedisSerializer());
		rt.setEnableTransactionSupport(true);
		rt.afterPropertiesSet();

		return rt;

	}


}
