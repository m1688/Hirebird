package com.recruit.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.util.Log;

public class DateUtil {
	private static final String TAG = "DATE_UTIL";
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
	/**
	 * 将日期转换成yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if(date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());
		return sdf.format(date);
	}
	
	/**
	 * 将日期转换成yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		if(date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN, Locale.getDefault());
		return sdf.format(date);
	}
	
	/**
	 * 将yyyy-MM-dd格式的字符串转换成Date
	 * @param str
	 * @return
	 */
	public static Date parseDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			Log.e(TAG, "parse date error", e);
		}
		return null;
	}
	
	/**
	 * 将yyyy-MM-dd hh:mm:ss格式的字符串转换成Date
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
        if(Strings.isEmpty(str)){
            return null;
        }
		try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN, Locale.getDefault());
			return sdf.parse(str);
		} catch (Exception e) {
			Log.e(TAG, "parse date time error", e);
		}
		return null;
	}
}
