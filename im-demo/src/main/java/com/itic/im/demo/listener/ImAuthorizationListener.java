package com.itic.im.demo.listener;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 认证监听
 * @author wanli.yang
 * @version 1.0
 * @date 2022/1/13 9:55
 */
@Component
public class ImAuthorizationListener implements AuthorizationListener {
    private static final Logger logger = LoggerFactory.getLogger(ImAuthorizationListener.class);

    @Override
    public boolean isAuthorized(HandshakeData data) {
        // 实现自己得监听逻辑
        logger.info(data.toString());
        return true;
    }
}
