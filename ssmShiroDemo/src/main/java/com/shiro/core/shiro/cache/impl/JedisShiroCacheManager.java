package com.shiro.core.shiro.cache.impl;

import org.apache.shiro.cache.Cache;

import com.shiro.core.shiro.cache.JedisManager;
import com.shiro.core.shiro.cache.JedisShiroCache;
import com.shiro.core.shiro.cache.ShiroCacheManager;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：JedisShiroCacheManager   
 * 类描述：   
 *		JRedis管理
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午3:46:01   
 * @version
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
