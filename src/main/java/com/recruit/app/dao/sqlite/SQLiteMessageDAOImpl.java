package com.recruit.app.dao.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.MessageDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.AccountDO;
import com.recruit.app.db.dataobject.MessageDO;
import com.recruit.app.domain.model.Message;
import com.recruit.app.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

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
public class SQLiteMessageDAOImpl implements MessageDAO {
    private static final String MESSAGE_TABLE_NAME = "message";
    private static final String[] MESSAGE_SELECT_COLUMNS = new String[] { ID,CONTENT, CREATED_DATE, RECEIVER_ID, RECEIVER_NAME,SENDER_ID,TYPE, SENDER_NAME,TITLE};

    public long addMessage(MessageDO message){
        if (message == null) {
            return -1;
        }
        SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        return db.insert(MESSAGE_TABLE_NAME, null, message.toContentValues());
    }

    public MessageDO queryMessageById(Long id){
        if(id == null) {
            return null;
        }
        SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE_NAME, MESSAGE_SELECT_COLUMNS, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        try {
            if(cursor.moveToNext()) {
                MessageDO message = new MessageDO();
                message.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
                message.setContent(cursor.getString(cursor.getColumnIndexOrThrow(CONTENT)));
                String createdDate = cursor.getString((cursor.getColumnIndexOrThrow(CREATED_DATE)));
                message.setCreatedDate(DateUtil.parseDateTime(createdDate));
                message.setReceiverId(cursor.getLong(cursor.getColumnIndexOrThrow(RECEIVER_ID)));
                message.setReceiverName(cursor.getString(cursor.getColumnIndexOrThrow(RECEIVER_NAME)));
                message.setSenderId(cursor.getLong(cursor.getColumnIndexOrThrow(SENDER_ID)));
                message.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                message.setType(cursor.getString(cursor.getColumnIndexOrThrow(TYPE)));
                message.setSenderName(cursor.getString(cursor.getColumnIndexOrThrow(SENDER_NAME)));
                return message;
            }
        } finally {
            cursor.close();
        }
        return null;
    }
    public List<MessageDO> queryMessageBySenderId(Long senderId){

        if(senderId == null) {
            return null;
        }
        SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE_NAME, MESSAGE_SELECT_COLUMNS, "SENDER_ID=?", new String[]{String.valueOf(senderId)}, null, null, null);
        List<MessageDO> messageDOList  = new ArrayList<MessageDO>();
        try {
            if(cursor.moveToNext()) {
                MessageDO message = new MessageDO();
                message.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
                message.setContent(cursor.getString(cursor.getColumnIndexOrThrow(CONTENT)));
                String createdDate = cursor.getString((cursor.getColumnIndexOrThrow(CREATED_DATE)));
                message.setCreatedDate(DateUtil.parseDateTime(createdDate));
                message.setReceiverId(cursor.getLong(cursor.getColumnIndexOrThrow(RECEIVER_ID)));
                message.setReceiverName(cursor.getString(cursor.getColumnIndexOrThrow(RECEIVER_NAME)));
                message.setSenderId(cursor.getLong(cursor.getColumnIndexOrThrow(SENDER_ID)));
                message.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                message.setType(cursor.getString(cursor.getColumnIndexOrThrow(TYPE)));
                message.setSenderName(cursor.getString(cursor.getColumnIndexOrThrow(SENDER_NAME)));
                messageDOList.add(message);
            }
        } finally {
            cursor.close();
        }
        return messageDOList;

    }

    public List<MessageDO> queryMessageByReceiverId(Long receiverId){
        if(receiverId == null) {
            return null;
        }
        SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE_NAME, MESSAGE_SELECT_COLUMNS, "RECEIVER_ID=?", new String[]{String.valueOf(receiverId)}, null, null, null);
        List<MessageDO> messageDOList  = new ArrayList<MessageDO>();
        try {
            if(cursor.moveToNext()) {
                MessageDO message = new MessageDO();
                message.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
                message.setContent(cursor.getString(cursor.getColumnIndexOrThrow(CONTENT)));
                String createdDate = cursor.getString((cursor.getColumnIndexOrThrow(CREATED_DATE)));
                message.setCreatedDate(DateUtil.parseDateTime(createdDate));
                message.setReceiverId(cursor.getLong(cursor.getColumnIndexOrThrow(RECEIVER_ID)));
                message.setReceiverName(cursor.getString(cursor.getColumnIndexOrThrow(RECEIVER_NAME)));
                message.setSenderId(cursor.getLong(cursor.getColumnIndexOrThrow(SENDER_ID)));
                message.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                message.setType(cursor.getString(cursor.getColumnIndexOrThrow(TYPE)));
                message.setSenderName(cursor.getString(cursor.getColumnIndexOrThrow(SENDER_NAME)));
                messageDOList.add(message);
            }
        } finally {
            cursor.close();
        }
        return messageDOList;
    }

    public List<MessageDO> queryMessageByReceiverIdType(Long receiverId,String type){
        if(receiverId == null) {
            return null;
        }
        SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MESSAGE_TABLE_NAME, MESSAGE_SELECT_COLUMNS, "RECEIVER_ID=? AND TYPE=?", new String[]{String.valueOf(receiverId),type}, null, null, null);
        List<MessageDO> messageDOList  = new ArrayList<MessageDO>();
        try {
            if(cursor.moveToNext()) {
                MessageDO message = new MessageDO();
                message.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
                message.setContent(cursor.getString(cursor.getColumnIndexOrThrow(CONTENT)));
                String createdDate = cursor.getString((cursor.getColumnIndexOrThrow(CREATED_DATE)));
                message.setCreatedDate(DateUtil.parseDateTime(createdDate));
                message.setReceiverId(cursor.getLong(cursor.getColumnIndexOrThrow(RECEIVER_ID)));
                message.setReceiverName(cursor.getString(cursor.getColumnIndexOrThrow(RECEIVER_NAME)));
                message.setSenderId(cursor.getLong(cursor.getColumnIndexOrThrow(SENDER_ID)));
                message.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                message.setType(cursor.getString(cursor.getColumnIndexOrThrow(TYPE)));
                message.setSenderName(cursor.getString(cursor.getColumnIndexOrThrow(SENDER_NAME)));
                messageDOList.add(message);
            }
        } finally {
            cursor.close();
        }
        return messageDOList;
    }

}
