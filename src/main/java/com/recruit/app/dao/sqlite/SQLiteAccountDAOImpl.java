package com.recruit.app.dao.sqlite;

import static com.recruit.app.db.tables.Account.EMAIL;
import static com.recruit.app.db.tables.Account.ID;
import static com.recruit.app.db.tables.Account.MOBILE_PHONE;
import static com.recruit.app.db.tables.Account.PASSWORD;
import static com.recruit.app.db.tables.Account.USERNAME;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.AccountDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.AccountDO;
import com.recruit.app.util.StringUtils;

public class SQLiteAccountDAOImpl implements AccountDAO {
	private static final String ACCOUNT_TABLE_NAME = "account";
	private static final String[] ACCOUNT_SELECT_COLUMNS = new String[] { ID,
			USERNAME, EMAIL, MOBILE_PHONE, PASSWORD };

	public AccountDO queryByUsername(String username) {
		if(StringUtils.isBlank(username)) {
			return null;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(ACCOUNT_TABLE_NAME, ACCOUNT_SELECT_COLUMNS, USERNAME + "=?", new String[]{username}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				AccountDO account = new AccountDO();
				account.setUserName(cursor.getString(cursor.getColumnIndexOrThrow(USERNAME)));
				account.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)));
				account.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
				account.setMobilePhone(cursor.getString(cursor.getColumnIndexOrThrow(MOBILE_PHONE)));
				account.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD)));
				return account;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

	public long addAccount(AccountDO account) {
		if (account == null) {
			return -1;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper
				.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		return db.insert(ACCOUNT_TABLE_NAME, null, account.toContentValues());
	}

	public AccountDO queryById(long id) {
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(ACCOUNT_TABLE_NAME, ACCOUNT_SELECT_COLUMNS, ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				AccountDO account = new AccountDO();
				account.setUserName(cursor.getString(cursor.getColumnIndexOrThrow(USERNAME)));
				account.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)));
				account.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
				account.setMobilePhone(cursor.getString(cursor.getColumnIndexOrThrow(MOBILE_PHONE)));
				account.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD)));
				return account;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
