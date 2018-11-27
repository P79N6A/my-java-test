package priv.zc.example.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *  on 17/1/17.
 */
//@Service
public class RedisCacheService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public long simpleBusiness(String key) {
        long nowTime = System.currentTimeMillis();
        logger.info("nowTime:" + nowTime);
        redisTemplate.opsForValue().set(key, nowTime);
        return nowTime;
    }

    public void deleteKey(String key) {

    }
}
