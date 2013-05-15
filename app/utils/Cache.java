package utils;

import play.Play;

public class Cache {

    public static interface CacheFactory {
        public Object create();
    }

    /**
     * 简化Cache方法，不需要判断对象是否在Cache中存在
     * 
     * @param key
     *            缓存的key
     * @param period
     *            缓存时间
     * @param factory
     *            生成缓存对象的工厂方法
     * @return 缓存后的对象
     */
    public static Object cache(String key, String period, CacheFactory factory) {
        String usecache = (String) Play.configuration.get("usecache");
        if (usecache != null && "true".equals(usecache)) {
            Object cachedObject = play.cache.Cache.get(key);
            if (cachedObject == null) {
                play.cache.Cache.set(key, cachedObject, period);
                cachedObject = factory.create();
            }
            return cachedObject;
        } else {
            // 不使用缓存
            play.cache.Cache.set(key, null, period);
            return factory.create();
        }
    }
}
