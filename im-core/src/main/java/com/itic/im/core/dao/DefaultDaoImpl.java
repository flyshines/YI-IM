package com.itic.im.core.dao;

import com.itic.im.core.model.Online;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 持久层默认实现，内存模式
 *
 * @author wanli.yang
 * @version 1.0
 * @date 2022/1/13 11:55
 */
public class DefaultDaoImpl implements Dao {

    /**
     * 在线客户端集合
     */
    public Map<String, Online> onlineMap = new ConcurrentHashMap<>();

    @Override
    public void setOnline(String clientId, Online o) {
        onlineMap.put(clientId, o);
    }

    @Override
    public Online getOnline(String clientId) {
        return onlineMap.get(clientId);
    }

    @Override
    public void removeOnline(String userId) {
        onlineMap.remove(userId);
    }

}
