package com.recruit.app.dao.sqlite;

import static com.recruit.app.db.tables.User.ACCOUNT;
import static com.recruit.app.db.tables.User.BIRTHDAY;
import static com.recruit.app.db.tables.User.CREATE_DATE;
import static com.recruit.app.db.tables.User.DEGREE;
import static com.recruit.app.db.tables.User.ENGLISH_LEVEL;
import static com.recruit.app.db.tables.User.ID;
import static com.recruit.app.db.tables.User.ID_NUM;
import static com.recruit.app.db.tables.User.ID_TYPE;
import static com.recruit.app.db.tables.User.MAJOR;
import static com.recruit.app.db.tables.User.MODIFY_DATE;
import static com.recruit.app.db.tables.User.NAME;
import static com.recruit.app.db.tables.User.SEX;
import static com.recruit.app.db.tables.User.WORK_YEAR;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.UserDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.UserDO;
import com.recruit.app.util.DateUtil;

public class SQLiteUserDAOImpl implements UserDAO {
	private static final String USER_TABLE_NAME = "user";
	private static final String[] USER_SELECT_COLUMNS = new String[] { ID,
			NAME, SEX, BIRTHDAY, ID_TYPE, ID_NUM, DEGREE, MAJOR,
			ENGLISH_LEVEL, WORK_YEAR,CREATE_DATE, MODIFY_DATE, ACCOUNT };

	public long addUser(UserDO user) {
		if (user == null) {
			return -1;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper
				.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		return db.insert(USER_TABLE_NAME, null, user.toContentValues());
	}

	public UserDO queryById(long id) {
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(USER_TABLE_NAME, USER_SELECT_COLUMNS, "id=?", new String[]{String.valueOf(id)}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				UserDO user = new UserDO();
				user.setId(id);
				user.setAccount(cursor.getLong(cursor.getColumnIndex(ACCOUNT)));
				String birthday = cursor.getString(cursor.getColumnIndex(BIRTHDAY));
				user.setBirthday(DateUtil.parseDate(birthday));
				String createTime = cursor.getString(cursor.getColumnIndex(CREATE_DATE));
				user.setCreateDate(DateUtil.parseDateTime(createTime));
				user.setDegree(cursor.getString(cursor.getColumnIndex(DEGREE)));
				user.setEnglishLevel(cursor.getString(cursor.getColumnIndex(ENGLISH_LEVEL)));
				user.setIdNum(cursor.getString(cursor.getColumnIndex(ID_NUM)));
				user.setIdType(cursor.getString(cursor.getColumnIndex(ID_TYPE)));
				user.setMajor(cursor.getString(cursor.getColumnIndex(MAJOR)));
				String modifyTime = cursor.getString(cursor.getColumnIndex(MODIFY_DATE));
				user.setModifyDate(DateUtil.parseDateTime(modifyTime));
				user.setName(cursor.getString(cursor.getColumnIndex(NAME)));
				user.setSex(cursor.getInt(cursor.getColumnIndex(SEX)));
				user.setWorkingYear(cursor.getInt(cursor.getColumnIndex(WORK_YEAR)));
				return user;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
