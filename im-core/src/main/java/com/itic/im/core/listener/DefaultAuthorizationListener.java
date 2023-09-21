package com.itic.im.core.listener;

import cn.hutool.json.JSONUtil;
import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 默认的认证监听， 可以继承实现认证
 *
 * @author wanli.yang
 * @version 1.0
 * @date 2022/1/13 9:48
 */
public class DefaultAuthorizationListener implements AuthorizationListener {

    private static final Logger log = LoggerFactory.getLogger(DefaultAuthorizationListener.class);
    public static final String LOGIN_TOKEN_STR = "token";


    @Override
    public boolean isAuthorized(HandshakeData data) {
        // 实现自己得监听逻辑
        log.debug(JSONUtil.toJsonStr(data));
        String token = data.getSingleUrlParam(LOGIN_TOKEN_STR);
        if (StringUtils.isEmpty(token)) {
            log.error("socket.io 权限认证失败，token为空");
            return false;
        }
        // TODO token
        Integer userId = 1;
        if(Objects.isNull(userId)) {
            log.error("socket.io 权限认证失败，token验证失败, token:{}", token);
            return false;
        }
        log.info("socket.io 权限认证成功, userId:{}", userId);
        return true;
    }
}
