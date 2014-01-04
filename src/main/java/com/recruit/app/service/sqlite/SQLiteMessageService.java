package com.recruit.app.service.sqlite;

import com.recruit.app.dao.MessageDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.MessageDO;
import com.recruit.app.domain.model.Message;
import com.recruit.app.domain.model.MessageType;
import com.recruit.app.service.MessageService;
import com.recruit.app.service.mapper.MessageMapper;

import java.util.List;

/**
 * Created by jialiang.zoujl on 14-1-3.
 */
public class SQLiteMessageService implements MessageService{
    private MessageDAO messageDAO =  DAOFactory.getInstance().getMessageDAO();

    public long addMessage(Message message){
        MessageDO messageDO = MessageMapper.convertToDO(message);
        return messageDAO.addMessage(messageDO);
    }

    public Message queryMessageById(Long id){
        if(null==id){
            return null;
        }
        MessageDO messageDO = messageDAO.queryMessageById(id);
        if (null==messageDO){
            return null;
        }

        return MessageMapper.convertToModel(messageDO);
    }

    public List<Message> queryMessageBySenderId(Long senderId){
        if(null==senderId){
            return null;
        }

        List<MessageDO> messageDOList = messageDAO.queryMessageBySenderId(senderId);
        return MessageMapper.convertToModelList(messageDOList);
    }

    public List<Message> queryMessageByReceiverId(Long receiverId){
        if(null==receiverId){
            return null;
        }

        List<MessageDO> messageDOList =  messageDAO.queryMessageByReceiverId(receiverId);
        return MessageMapper.convertToModelList(messageDOList);
    }

    public List<Message> queryMessageByReceiverIdType(Long receiverId,MessageType msgType){
        if(null==receiverId || null==msgType){
            return null;
        }

        List<MessageDO> messageDOList =  messageDAO.queryMessageByReceiverIdType(receiverId,msgType.name());
        return MessageMapper.convertToModelList(messageDOList);
    }


}
