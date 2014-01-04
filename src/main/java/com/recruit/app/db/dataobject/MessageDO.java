package com.recruit.app.db.dataobject;

import android.content.ContentValues;

import com.recruit.app.domain.model.MessageType;
import com.recruit.app.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

import static com.recruit.app.db.tables.Message.ID;
import static com.recruit.app.db.tables.Message.CONTENT;
import static com.recruit.app.db.tables.Message.CREATED_DATE;
import static com.recruit.app.db.tables.Message.RECEIVER_ID;
import static com.recruit.app.db.tables.Message.RECEIVER_NAME;
import static com.recruit.app.db.tables.Message.SENDER_ID;
import static com.recruit.app.db.tables.Message.TYPE;
import static com.recruit.app.db.tables.Message.SENDER_NAME;
import static com.recruit.app.db.tables.Message.TITLE;

/**
 * Created by jialiang.zoujl on 14-1-2.
 */
public class MessageDO implements Serializable {

    private Long id;
    private String title;
    private String content;
    private Long senderId;
    private String senderName;
    private Long receiverId;
    private String receiverName;
    private String type;
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 将字段转换成CententValues
     * @return
     */
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(ID, id);
        cv.put(CONTENT, content);
        cv.put(RECEIVER_ID, receiverId);
        cv.put(RECEIVER_NAME, receiverName);
        cv.put(SENDER_ID, senderId);
        cv.put(SENDER_NAME, senderName);
        cv.put(TITLE, title);
        cv.put(CREATED_DATE, DateUtil.formatDateTime(createdDate));
        cv.put(TYPE,type);
        return cv;
    }
}
