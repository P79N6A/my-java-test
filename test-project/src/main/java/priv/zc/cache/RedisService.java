package priv.zc.cache;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisService {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
}
