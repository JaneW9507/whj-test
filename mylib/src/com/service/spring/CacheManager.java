package com.service.spring;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

public class CacheManager {

	private static Log logger = LogFactory.getLog(CacheManager.class);

	private static Map<String, Object> allCacheMap = new HashMap(0);

	private Map<String, Object> cacheMap = new HashMap(0);
	private String cacheName;
	private Object lockObject = new Object();

	private CacheManager(String cacheName) {
		this.cacheName = cacheName;
	}

	public static void main(String[] args) {
	}

	public static CacheManager getIntance(String cacheName) {
		if (allCacheMap.containsKey(cacheName)) {
			return (CacheManager) allCacheMap.get(cacheName);
		}
		CacheManager cacheManager = new CacheManager(cacheName);
		allCacheMap.put(cacheName, cacheManager);
		if (logger.isDebugEnabled()) {
			logger.debug("Create cacheManager " + cacheName);
		}
		return cacheManager;
	}

	public static String[] getAllCacheName() {
		Object[] keyArray = allCacheMap.keySet().toArray();
		String[] nameArray = new String[keyArray.length];
		for (int i = 0; i < keyArray.length; i++) {
			nameArray[i] = ((String) keyArray[i]);
		}
		return nameArray;
	}

	public static synchronized void clearAllCacheManager() {
		String[] cacheNameArray = getAllCacheName();
		for (int i = 0; i < cacheNameArray.length; i++)
			getIntance(cacheNameArray[i]).clearCache(new Object[0]);
	}

	public Object getCache(String key) {
		Object value = this.cacheMap.get(key);
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieve data key=" + key + ",value=" + value);
		}
		return value;
	}

	public void putCache(String key, Object value) {
		synchronized (this.lockObject) {
			this.cacheMap.put(key, value);
			if (logger.isDebugEnabled()){
				logger.debug("Put cache key=" + key + ",value=" + value);
			}
		}
	}

	public synchronized void clearCache(Object[] arguments) {
		if ((arguments == null) || (arguments.length == 0)) {
			int size = this.cacheMap.size();
			this.cacheMap.clear();
			if (logger.isWarnEnabled()) {
				logger.warn("Clear " + this.cacheName + " total " + size + " item(s).");
			}
			return;
		}

		String keyPrefix = generateKey(arguments);
		String keyName = "";
		Object[] keys = this.cacheMap.keySet().toArray();
		int size = 0;
		for (int i = 0; i < keys.length; i++) {
			keyName = (String) keys[i];
			if (keyName != null) {
				if (keyName.startsWith(keyPrefix)) {
					this.cacheMap.remove(keyName);
					size++;
				}
			}
		}
		if (logger.isWarnEnabled())
			logger.warn("Clear " + this.cacheName + " " + size	+ " item(s).prefix=" + keyPrefix);
	}

	public boolean containsKey(String key) {
		return this.cacheMap.containsKey(key);
	}

	public boolean containsValue(String value) {
		return this.cacheMap.containsValue(value);
	}

	public String generateCacheKey(Object[] arguments) {
		Assert.isTrue(arguments != null);
		Assert.isTrue(arguments.length > 0);
		return generateKey(arguments);
	}

	private String generateKey(Object[] arguments) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arguments.length; i++) {
			sb.append(".").append(arguments[i]);
		}
		return sb.toString();
	}
}