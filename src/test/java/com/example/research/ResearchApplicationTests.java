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

import static com.example.research.TestMain.keyChanceMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResearchApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;
	ObjectMapper objectMapper = new ObjectMapper();

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
		mapAmount.put("ladder1","8.88");
		mapAmount.put("ladder2","18.88");
		ObjectMapper objectMapper = new ObjectMapper();
		String ss = objectMapper.writeValueAsString(mapLadder);
		System.out.println(ss);
		String aa = objectMapper.writeValueAsString(mapAmount);
		Map<String,String> ll =objectMapper.readValue(aa,Map.class);
		System.out.println(aa);
		System.out.println(ll+"--"+ll.get("ladder1"));
		map.put("ladder",ss);
		map.put("amount",aa);
		redisTemplate.opsForHash().putAll("red_packet",map);
		Map maps = redisTemplate.opsForHash().entries("red_packet");
		System.out.println("完成！！！！"+maps);
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
				/*Iterator iter = maps.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
		}*/
	}

	/**
	 * 发红包测试
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		for (int i = 0; i <10000 ; i++) {
			//获得红包缓存及相关信息
			Map maps = redisTemplate.opsForHash().entries("red_packet");
			Integer count = Integer.parseInt((String)maps.get("count"));
			if(count==0){
				System.out.println("发奖结束！！！！！");
				break;
			}
			Map ladderMap = objectMapper.readValue((String)maps.get("ladder"),Map.class);
			Map amountMap = objectMapper.readValue((String)maps.get("amount"),Map.class);
			redPacket(count,ladderMap,amountMap,maps);
		}
	}

	public void redPacket(int counts,Map<String,String> ladder,Map<String,String> amount,Map<String,String> maps){
		try {
			Long time = System.currentTimeMillis();
			Map<String, Integer> count = new HashMap<String, Integer>();
			List<String> list = new ArrayList<>();
			String item = null;
			for (int i = 0; i < counts; i++) {
				item = chanceSelect(ladder);
				list.add(item);
				if (count.containsKey(item)) {
					count.put(item, count.get(item) + 1);
				} else {
					count.put(item, 1);
				}
			}
			for (String id : count.keySet()) {
				System.out.println(id + "\t出现了 " + count.get(id) + " 次");
			}
			Random rand = new Random();
			int num = rand.nextInt(counts);
			//数目-1
			Integer ladders = Integer.parseInt(ladder.get(list.get(num)));
			ladders--;
			ladder.put(list.get(num),ladders+"");
			counts--;
			maps.put("ladder",objectMapper.writeValueAsString(ladder));
			maps.put("count",counts+"");
			System.err.println("最终发放的金额为："+amount.get(list.get(num))+" 耗时："+(System.currentTimeMillis()-time));
			//存入缓存
			redisTemplate.opsForHash().putAll("red_packet",maps);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public  String chanceSelect(Map<String, String> ladder) {
		if (ladder == null || ladder.size() == 0)
			return null;
		//总数量
		Integer sum = 0;
		for (String value : ladder.values()) {
			sum += Integer.parseInt(value);
		}
		// 从1开始
		Integer rand = new Random().nextInt(sum) + 1;
		for (Map.Entry<String, String> entry : ladder.entrySet()) {
			rand -= Integer.parseInt(entry.getValue());
			// 选中
			if (rand <= 0) {
				String item = entry.getKey();
				return item;
			}
		}
		return null;
	}
}
