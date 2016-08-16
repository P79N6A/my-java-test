package priv.zc.cache;

public interface CacheService {
	Object get(String key);
	void set(String key,Object value);
	void delete(String key);
}
