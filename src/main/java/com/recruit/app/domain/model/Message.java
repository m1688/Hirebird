package com.recruit.app.domain.model;

import java.util.Date;

/**
 * 消息模型
 * <p/>
 * jyu - 12/24/13.
 */
public class Message {

    private Long id;

    private String title;
    private String content;
    private Long senderId;
    private String senderName;
    private Long receiverId;
    private String receiverName;
    private MessageType type;
    private Date createdDate;
}
