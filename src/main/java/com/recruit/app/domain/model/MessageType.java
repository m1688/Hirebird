package com.recruit.app.domain.model;

/**
 * 消息类型
 *
 * jyu - 12/24/13.
 */
public enum MessageType {

    MESSAGE,

    APPLY;

    public static MessageType parse(String type) {
        for (MessageType msgType : MessageType.values())
            if (msgType.name().equals(type)) {
                return msgType;
            }
        return null;
    }

}
