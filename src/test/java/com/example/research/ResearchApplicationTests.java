package com.example.research;

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

	@Test
	public void testObj() throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("count",2000);
		List ladder = new ArrayList();
		ladder.add(1700);
		ladder.add(300);
		map.put("ladder",ladder);
		List amount = new ArrayList();
		amount.add(8.88);
		amount.add(18.88);
		map.put("amount",amount);
		redisTemplate.opsForHash().putAll("red_packet",map);
		Map maps = redisTemplate.opsForHash().entries("red_packet");
		System.out.println("完成！！！！"+maps);
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}

}
