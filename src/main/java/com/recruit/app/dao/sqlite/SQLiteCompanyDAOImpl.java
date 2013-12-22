package com.recruit.app.dao.sqlite;

import static com.recruit.app.db.tables.Company.ADDRESS;
import static com.recruit.app.db.tables.Company.ID;
import static com.recruit.app.db.tables.Company.INDUSTRY;
import static com.recruit.app.db.tables.Company.NAME;
import static com.recruit.app.db.tables.Company.SCALE;
import static com.recruit.app.db.tables.Company.STRUCTURE;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recruit.app.dao.CompanyDAO;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.db.dataobject.CompanyDO;

public class SQLiteCompanyDAOImpl implements CompanyDAO {
	private static final String COMPANY_TABLE_NAME = "company";
	private static final String[] COMPANY_SELECT_COLUMNS = new String[] { ID,
			ADDRESS, INDUSTRY, NAME, SCALE, STRUCTURE };

	public long addCompany(CompanyDO company) {
		if (company == null) {
			return -1;
		}
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper
				.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		return db.insert(COMPANY_TABLE_NAME, null, company.toContentValues());
	}

	public CompanyDO queryById(long companyId) {
		SQLiteOpenHelper sqLiteOpenHelper = RecruitSQLiteOpenHelper.getInstance();
		SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
		Cursor cursor = db.query(COMPANY_TABLE_NAME, COMPANY_SELECT_COLUMNS, "id=?", new String[]{String.valueOf(companyId)}, null, null, null);
		try {
			if(cursor.moveToNext()) {
				CompanyDO company = new CompanyDO();
				company.setId(companyId);
				company.setAddress(cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)));
				company.setIndustry(cursor.getString(cursor.getColumnIndexOrThrow(INDUSTRY)));
				company.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
				company.setScale(cursor.getString(cursor.getColumnIndexOrThrow(SCALE)));
				company.setStructure(cursor.getString(cursor.getColumnIndexOrThrow(STRUCTURE)));
				return company;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
