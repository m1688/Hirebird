package com.recruit.app.db.dataobject;

import android.content.ContentValues;
import static com.recruit.app.db.tables.Company.ADDRESS;
import static com.recruit.app.db.tables.Company.INDUSTRY;
import static com.recruit.app.db.tables.Company.NAME;
import static com.recruit.app.db.tables.Company.SCALE;
import static com.recruit.app.db.tables.Company.STRUCTURE;
public class CompanyDO {
	private long id;
	private String name;// 公司名称
	private String address;// 地址
	private String industry;// 从事相关行业
	private String structure;// 公司性质，私企，国企，民营
	private String scale;// 公司规模

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * 返回字段的ContentValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(NAME, name);
		cv.put(ADDRESS, address);
		cv.put(INDUSTRY, industry);
		cv.put(STRUCTURE, structure);
		cv.put(SCALE, scale);
		return cv;
	}
}
