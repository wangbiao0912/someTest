package com.shiro.core.shiro.listenter;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.shiro.core.shiro.session.ShiroSessionRepository;
/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：CustomSessionListener   
 * 类描述：   
 *		 shiro 回话 监听
 * 创建人：wangbiao  
 * 创建时间：2017年3月30日 下午3:38:27   
 * @version
 */
public class CustomSessionListener implements SessionListener {

    private ShiroSessionRepository shiroSessionRepository;

    /**
     * 一个回话的生命周期开始
     */
    @Override
    public void onStart(Session session) {
        //TODO
        System.out.println("生命周期 on start");
    }
    /**
     * 一个回话的生命周期结束
     */
    @Override
    public void onStop(Session session) {
        //TODO
        System.out.println("生命周期 on stop");
    }

    @Override
    public void onExpiration(Session session) {
        shiroSessionRepository.deleteSession(session.getId());
    }

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }

}

