package com.recruit.app.dao;

import com.recruit.app.db.dataobject.MessageDO;

import java.util.List;

public interface MessageDAO {
    public long addMessage(MessageDO message);
    public MessageDO queryMessageById(Long id);
    public List<MessageDO> queryMessageBySenderId(Long senderId);
    public List<MessageDO> queryMessageByReceiverId(Long receiverId);
    public List<MessageDO> queryMessageByReceiverIdType(Long receiverId,String type);
}
