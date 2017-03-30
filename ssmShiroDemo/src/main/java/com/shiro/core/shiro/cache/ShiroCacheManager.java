package com.shiro.core.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：ShiroCacheManager   
 * 类描述：   
 *		shiro cache manager 接口
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午3:50:14   
 * @version
 */
public interface ShiroCacheManager {

    <K, V> Cache<K, V> getCache(String name);

    void destroy();

}
