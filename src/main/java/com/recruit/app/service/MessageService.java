package com.recruit.app.service;

import com.recruit.app.domain.model.Message;
import com.recruit.app.domain.model.MessageType;

import java.util.List;

/**
 * Created by jialiang.zoujl on 14-1-2.
 */
public interface MessageService {
    public long addMessage(Message message);
    public Message queryMessageById(Long id);
    public List<Message> queryMessageBySenderId(Long senderId);
    public List<Message> queryMessageByReceiverId(Long receiverId);
    public List<Message> queryMessageByReceiverIdType(Long receiverId,MessageType msgType);
}
