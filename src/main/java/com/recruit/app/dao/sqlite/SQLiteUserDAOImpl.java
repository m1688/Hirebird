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

	public UserDO queryById(long userId) {
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(USER_TABLE_NAME, USER_SELECT_COLUMNS, "id=?", new String[]{String.valueOf(userId)}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				UserDO user = new UserDO();
				user.setId(userId);
				user.setName(cursor.getString(cursor.getColumnIndex(NAME)));
				//TODO more fields
				return user;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
