//package com.bridzelabz.fundoonotes.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//public class RedisConfiguration {
//	   @Bean
//	    JedisConnectionFactory jedisConnectionFactory() {
//		  // redisStandaloneConfiguration.setPassword(RedisPassword.of("password"));
//			return  new JedisConnectionFactory(); 
//	   }
//	   @Bean
//	    public RedisTemplate<String, Object> redisTemplate() {
//	        RedisTemplate<String,Object> template = new RedisTemplate<>();
//	        template.setConnectionFactory(jedisConnectionFactory());
//	        template.setEnableTransactionSupport(true);
//	        return template;
//	    }
//	   
//}
