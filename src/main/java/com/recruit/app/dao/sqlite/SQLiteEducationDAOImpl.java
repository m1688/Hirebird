package com.recruit.app.dao.sqlite;

import static com.recruit.app.db.tables.Education.BEGIN_DATE;
import static com.recruit.app.db.tables.Education.DETAIL;
import static com.recruit.app.db.tables.Education.END_DATE;
import static com.recruit.app.db.tables.Education.ID;
import static com.recruit.app.db.tables.Education.MAJOR;
import static com.recruit.app.db.tables.Education.SCHOOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.EducationDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.EducationDO;
import com.recruit.app.util.DateUtil;
import com.recruit.app.util.StringUtils;

public class SQLiteEducationDAOImpl implements EducationDAO {
	private static final String EDUCATION_TABLE_NAME = "education";
	private static final String[] EDUCATION_SELECT_COLUMNS = new String[] { ID,
			BEGIN_DATE, END_DATE,  SCHOOL, MAJOR, DETAIL };

	public long addEducation(EducationDO educationDO) {
		if (educationDO == null) {
			return -1;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper
				.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		return db.insert(EDUCATION_TABLE_NAME, null, educationDO.toContentValues());
	}

	public EducationDO queryById(long educationId) {
		List<EducationDO> eduList = queryByIds(Arrays.asList(Long.valueOf(educationId)));
		if(eduList.size() > 0) {
			return eduList.get(0);
		}
		return null;
	}

	public List<EducationDO> queryByIds(List<Long> educationIdList) {
		List<String> idList = StringUtils.longList2StringList(educationIdList);
		if(idList == null || idList.size() == 0) {
			return Collections.emptyList();
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		
		Cursor cursor = db.query(EDUCATION_TABLE_NAME, EDUCATION_SELECT_COLUMNS, ID + " in" + StringUtils.generatePlaceHolder(idList.size()), idList.toArray(new String[]{}), null, null, null);
		try {
			List<EducationDO> eduList = new ArrayList<EducationDO>();
			
			while(cursor.moveToNext()) {
				EducationDO edu = new EducationDO();
				edu.setBeginDate(DateUtil.parseDate(cursor.getString(cursor.getColumnIndexOrThrow(BEGIN_DATE))));
				edu.setDetail(cursor.getString(cursor.getColumnIndexOrThrow(DETAIL)));
				edu.setEndDate(DateUtil.parseDate(cursor.getString(cursor.getColumnIndexOrThrow(END_DATE))));
				edu.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID)));
				edu.setMajor(cursor.getString(cursor.getColumnIndexOrThrow(MAJOR)));
				edu.setSchool(cursor.getString(cursor.getColumnIndexOrThrow(SCHOOL)));
				eduList.add(edu);
			}
			return eduList;
		} finally {
			cursor.close();
		}
	}

}
