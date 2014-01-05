package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.MessageDO;
import com.recruit.app.domain.model.Message;
import com.recruit.app.domain.model.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialiang.zoujl on 14-1-3.
 */
public class MessageMapper {

    public static MessageDO convertToDO(Message message) {
        if (message == null) {
            return null;
        }

        MessageDO messageDO = new MessageDO();
        messageDO.setSenderName(message.getSenderName());
        if (message.getType() != null) {
            messageDO.setType(message.getType().name());
        }
        messageDO.setTitle(message.getTitle());
        messageDO.setSenderId(message.getSenderId());
        messageDO.setContent(message.getContent());
        messageDO.setCreatedDate(message.getCreatedDate());
        messageDO.setId(message.getId());
        messageDO.setReceiverId(message.getReceiverId());
        messageDO.setReceiverName(message.getReceiverName());
        return messageDO;
    }

    public static Message convertToModel(MessageDO messageDO) {
        if (messageDO == null) {
            return null;
        }

        Message message = new Message();
        message.setSenderName(messageDO.getSenderName());
        message.setType(MessageType.parse(messageDO.getType()));
        message.setTitle(messageDO.getTitle());
        message.setSenderId(messageDO.getSenderId());
        message.setContent(messageDO.getContent());
        message.setCreatedDate(messageDO.getCreatedDate());
        message.setId(messageDO.getId());
        message.setReceiverId(messageDO.getReceiverId());
        message.setReceiverName(messageDO.getReceiverName());
        return message;
    }

    public static List<Message> convertToModelList(List<MessageDO> messageDOList) {
        if (messageDOList == null || messageDOList.isEmpty()) {
            return null;
        }

        List<Message> messageList = new ArrayList<Message>();
        for (MessageDO messageDO : messageDOList) {
            Message message = MessageMapper.convertToModel(messageDO);
            messageList.add(message);
        }

        return messageList;
    }
}
