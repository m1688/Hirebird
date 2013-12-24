package com.recruit.app.db;

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.recruit.app.util.StringUtils;

/**
 * 示例类
 * @author Administrator
 *
 */
public class RecruitSQLiteOpenHelper extends SQLiteOpenHelper {
	private static final String TAG = "SQLITE_OPEN_HELPER";
	private static final String DB_NAME = "recruit";
	private static final int VERSION = 1;
	
	private static volatile RecruitSQLiteOpenHelper instance;

	
	private RecruitSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	/**
	 * 应用启动的时候调用.多次调用也没有关系.
	 * @param context
	 */
	public static synchronized void init(Context context) {
		if(instance == null) {
			instance = new RecruitSQLiteOpenHelper(context, DB_NAME, null, VERSION);
		}
	}
	
	public static SQLiteOpenHelper getInstance() {
		if(instance == null) {
			throw new IllegalStateException("sqliteOpenHelper is not initialized,call method init() first.");
		}
		return instance;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建所有id以“create_”开头的表
		Map<String, String> sqlMap = SQLFileParser.getSQLMap();
		for(Entry<String, String> entry : sqlMap.entrySet()) {
			String id = entry.getKey();
			if(!StringUtils.isBlank(id) && id.toLowerCase(Locale.getDefault()).startsWith("create_")) {
				String sql = sqlMap.get(id);
				if(!StringUtils.isBlank(sql)) {
					try {
						db.execSQL(sql);
					} catch (Exception e) {
						Log.v(TAG, "create table error", e);
					}
				}
			}
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
