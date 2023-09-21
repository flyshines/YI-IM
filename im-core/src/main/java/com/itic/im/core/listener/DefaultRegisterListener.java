package com.itic.im.core.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.itic.im.core.ImManager;
import com.itic.im.core.model.Online;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * 默认注册事件
 * 1. 缓存当前客户端
 * date: 2022/1/12 12:39
 * author: wanli.yang
 */
public class DefaultRegisterListener implements DataListener {
    private static final Logger logger = LoggerFactory.getLogger(DefaultRegisterListener.class);
    @Override
    public void onData(SocketIOClient client, Object data, AckRequest ackRequest) throws Exception {
        MDC.put("traceId", UUID.randomUUID() + "");
        logger.info("socket.io 连接注册开始 registed. sessionId:{}", client.getSessionId());

        Online online = null;
        if(null != data) {
            online = (Online) data;
        }

        // 标记当前客户端在线
        online.setState(Online.ONLINE);

        // 设置sessionid
        online.setSessionId(client.getSessionId());

        // 缓存当前用户, 根据businessId维护
        ImManager.getDao().setOnline(online.getUserId(), online);

        // 加入服务端的room
        client.joinRoom(online.getUserId());

        if (ackRequest.isAckRequested()) {
            Online o = ImManager.getDao().getOnline(online.getUserId());
            ackRequest.sendAckData(client.getSessionId(), o.getUserId());
        }
        logger.info("socket.io 连接注册成功 registed. sessionId:{} userId:{}", client.getSessionId(), online.getUserId());
    }


}
