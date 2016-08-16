package priv.zc.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("cacheService")
public class LocalMapCache implements CacheService{
	private static Map<String,Object> CACHE_MAP = new HashMap<String,Object>();

	@Override
	public Object get(String key) {
		return CACHE_MAP.get(key);
	}

	@Override
	public void set(String key, Object value) {
		CACHE_MAP.put(key, value);
	}

	@Override
	public void delete(String key) {
		CACHE_MAP.remove(key);
	}

}
