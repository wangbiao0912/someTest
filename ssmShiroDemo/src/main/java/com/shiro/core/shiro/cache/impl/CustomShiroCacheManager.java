package com.shiro.core.shiro.cache.impl;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import com.shiro.core.shiro.cache.ShiroCacheManager;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：CustomShiroCacheManager   
 * 类描述：   
 *		shiro Custom Cache
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午3:45:49   
 * @version
 */
public class CustomShiroCacheManager implements CacheManager, Destroyable {

    private ShiroCacheManager shiroCacheManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return getShiroCacheManager().getCache(name);
    }

    @Override
    public void destroy() throws Exception {
        shiroCacheManager.destroy();
    }

    public ShiroCacheManager getShiroCacheManager() {
        return shiroCacheManager;
    }

    public void setShiroCacheManager(ShiroCacheManager shiroCacheManager) {
        this.shiroCacheManager = shiroCacheManager;
    }

}
