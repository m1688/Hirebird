package com.recruit.app.dao.sqlite;

import static com.recruit.app.db.tables.Position.COMPANY;
import static com.recruit.app.db.tables.Position.DETAIL;
import static com.recruit.app.db.tables.Position.FUNCTION;
import static com.recruit.app.db.tables.Position.ID;
import static com.recruit.app.db.tables.Position.LOCATION;
import static com.recruit.app.db.tables.Position.LOWEST_DEGREE;
import static com.recruit.app.db.tables.Position.POST_DATE;
import static com.recruit.app.db.tables.Position.PUBLISHER;
import static com.recruit.app.db.tables.Position.QUANTITY;
import static com.recruit.app.db.tables.Position.SALARY;
import static com.recruit.app.db.tables.Position.SKILL;
import static com.recruit.app.db.tables.Position.WORK_YEAR;

import java.util.Date;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.PositionDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.PositionDO;

public class SQLitePositionDAOImpl implements PositionDAO {
	private static final String POSITION_TABLE_NAME = "position";
	private static final String[] POSITION_SELECT_COLUMNS = new String[] {
			ID, PUBLISHER, COMPANY, POST_DATE, LOCATION, WORK_YEAR,
			QUANTITY, LOWEST_DEGREE, FUNCTION, DETAIL, SKILL,
			SALARY };

	public PositionDO queryById(long positionId) {
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(POSITION_TABLE_NAME, POSITION_SELECT_COLUMNS, "ID=?", new String[]{String.valueOf(positionId)}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				PositionDO positionModel = new PositionDO();
				positionModel.setCompany(cursor.getLong((cursor.getColumnIndexOrThrow(COMPANY))));
				positionModel.setPublisher(cursor.getLong((cursor.getColumnIndexOrThrow(PUBLISHER))));
				positionModel.setFunction(cursor.getString(cursor.getColumnIndexOrThrow(FUNCTION)));
				positionModel.setDetail(cursor.getString(cursor.getColumnIndexOrThrow(DETAIL)));
				positionModel.setId(positionId);
				positionModel.setLocation(cursor.getString(cursor.getColumnIndexOrThrow(LOCATION)));
				positionModel.setLowestDegree(cursor.getString(cursor.getColumnIndexOrThrow(LOWEST_DEGREE)));
				long postDate = cursor.getLong((cursor.getColumnIndexOrThrow(POST_DATE)));
				positionModel.setPostDate(postDate <= 0 ? null : new Date(postDate));
				positionModel.setQuantity(cursor.getInt((cursor.getColumnIndexOrThrow(QUANTITY))));
				positionModel.setSalary(cursor.getString(cursor.getColumnIndexOrThrow(SALARY)));
				positionModel.setSkill(cursor.getString(cursor.getColumnIndexOrThrow(SKILL)));
				positionModel.setWorkYear(cursor.getInt((cursor.getColumnIndexOrThrow(WORK_YEAR))));
				return positionModel;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

	public long addPosition(PositionDO model) {
		if (model == null) {
			return -1;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper
				.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		return db.insert(POSITION_TABLE_NAME, null, model.toContentValues());
	}

}
