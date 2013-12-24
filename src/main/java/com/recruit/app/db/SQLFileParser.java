package com.recruit.app.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

import android.util.Log;
import android.util.Xml;

import com.recruit.app.util.CaseInsensitiveHashMap;
import com.recruit.app.util.StringUtils;

/**
 * 从sqls.xml中解析出id和SQL，存放到Map中
 * @author Administrator
 *
 */
public class SQLFileParser {
	private static final String TAG = "SQL_FILE_PARSER";
	private static final Map<String, String> sqlMap = new CaseInsensitiveHashMap<String, String>();
	private SQLFileParser(){}
	static {
		parse();
	}
	
	/**
	 * Key为SQL的id，value为SQL
	 * @return
	 */
	public static Map<String, String> getSQLMap() {
		return sqlMap;
	}
	
	private static void parse() {
		InputStream inputStream = SQLFileParser.class.getClassLoader().getResourceAsStream("raw/sqls.xml");
		if(inputStream == null) {
			throw new IllegalStateException("cannot find sqls.xml");
		}
		Reader in = new InputStreamReader(inputStream);
		XmlPullParser xmlParser = Xml.newPullParser();
		try {
			xmlParser.setInput(in);
			xmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			xmlParser.nextTag();
			readSQL(xmlParser);
		} catch (Exception e) {
			Log.v(TAG, "parse sql file failure", e);
			//不外抛
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				Log.v(TAG, "close resource failure", e);
			}
		}
	}
	
	private static void readSQL(XmlPullParser xmlParser) throws Exception {
		xmlParser.require(XmlPullParser.START_TAG, null, "sqls");
		while(xmlParser.next() != XmlPullParser.END_TAG) {
			if(xmlParser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			
			String nodeName = xmlParser.getName();
			
			if(!"sql".equals(nodeName)) {
				continue;
			}
			String id = xmlParser.getAttributeValue(null, "id");
			String sql = xmlParser.nextText();
			if(!StringUtils.isBlank(id) && !StringUtils.isBlank(sql)) {
				sqlMap.put(id, sql);
			}
		}
	}
}