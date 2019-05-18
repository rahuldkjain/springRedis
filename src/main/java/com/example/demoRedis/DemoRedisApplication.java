package com.example.demoRedis;

import com.example.demoRedis.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@Configuration
public class DemoRedisApplication {

	private String redisHost = "localhost";

	private int redisPort = 6379;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName(redisHost);
		jedisConFactory.setPort(redisPort);
		return jedisConFactory;
	}

	@Bean
	public RedisTemplate<String, Employee> redisTemplate() {
		RedisTemplate<String, Employee> template = new RedisTemplate<String, Employee>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
	}
}
