package com.example.research;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResearchApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	/**
	 * 向缓存中初始化相关红包数据
	 * @throws Exception
	 */
	@Test
	public void testObj() throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("count",2000+"");
		Map<String,String> mapLadder = new HashMap<String,String>();
		mapLadder.put("ladder1","1700");
		mapLadder.put("ladder2","300");
		Map<String,String> mapAmount = new HashMap<String,String>();
		mapAmount.put("amount1","8.88");
		mapAmount.put("amount2","18.88");
		ObjectMapper objectMapper = new ObjectMapper();
		String ss = objectMapper.writeValueAsString(mapLadder);
		System.out.println(ss);
		String aa = objectMapper.writeValueAsString(mapAmount);
		System.out.println(aa);
		map.put("ladder",ss);
		map.put("amount",aa);
		redisTemplate.opsForHash().putAll("red_packet",map);
		Map maps = redisTemplate.opsForHash().entries("red_packet");
		System.out.println("完成！！！！"+maps);
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}

}
