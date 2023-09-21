package com.itic.im.core.listener;

import cn.hutool.json.JSONUtil;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.itic.im.core.ImManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 默认断开连接事件
 * date: 2022/1/12 12:39
 * author: wanli.yang
 */
public class DefaultDisConnectListener implements DisconnectListener {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDisConnectListener.class);

    @Override
    public void onDisconnect(SocketIOClient client) {
        //断开连接
        client.disconnect();
        logger.info("断开链接：token:{}", client.getHandshakeData().getSingleUrlParam("token"));
        logger.info("断开链接：urls:{}", JSONUtil.toJsonStr(client.getHandshakeData().getUrlParams()));
        String userId = client.getHandshakeData().getSingleUrlParam("clientId");
        if (StringUtils.isEmpty(userId)) {
            logger.error("断开连接-没有查到用户id sessionId:{}", client.getSessionId());
            return;
        }
        ImManager.getDao().removeOnline(userId);
        logger.warn("断开连接 userId:{}, sessionId:{}", userId, client.getSessionId());
    }
}
