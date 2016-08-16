package service;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisServiceTest {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void keys() {
		Set<String> keys = redisTemplate.keys("*");
		for (String key : keys) {
			System.out.println(key);
		}
	}

	@Test
	public void add() {
		String key = "TEST" + System.currentTimeMillis();
		redisTemplate.opsForValue().set(key, key);
		System.out.println(redisTemplate.opsForValue().get(key));
		redisTemplate.delete(key);
	}

}
