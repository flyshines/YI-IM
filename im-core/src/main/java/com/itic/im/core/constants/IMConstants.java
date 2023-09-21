package com.itic.im.core.constants;

public class IMConstants {
    //  默认命名空间
    public static final String IM_DEFAULT_NAMESPACE = "/im";
    //  默认房间
    public static final String IM_DEFAULT_ROOM = "default";
    //  默认频道  频道=房间  一个房间一个频道
    public static final String IM_DEFAULT_CHANNEL = IMConstants.IM_DEFAULT_ROOM;

    // 注册事件
    public static final String REGISTER_EVENT = "REGISTER";
    // 加入房间事件
    public static final String JOIN_ROOM_EVENT = "JOIN_ROOM";
    // 离开room事件
    public static final String LEAVE_ROOM_EVENT = "LEAVE_ROOM";
    // 发送消息事件
    public static final String SEND_MSG_EVENT = "SEND_MSG";

    //  在线用户redis key
    public static final String REDIS_IM_ONLINE_USER_PREFIX = "IM:ONLINE:USER";
}
