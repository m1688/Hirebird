package com.recruit.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtils {
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static String generatePlaceHolder(int size) {
		if(size < 1) {
			return "";
		}
		StringBuilder builder = new StringBuilder("(");
		for(int i = 0; i < size; i++) {
			builder.append("?");
			if(i < size -1) {
				builder.append(",");
			}
		}
		builder.append(")");
		return builder.toString();
	}
	
	public static List<String> longList2StringList(List<Long> ll) {
		if(ll == null || ll.size() == 0) {
			return Collections.emptyList();
		}
		List<String> ret = new ArrayList<String>(ll.size());
		for(Long v : ll) {
			if(v != null) {
				ret.add(v.toString());
			}
		}
		return ret;
	}
}
