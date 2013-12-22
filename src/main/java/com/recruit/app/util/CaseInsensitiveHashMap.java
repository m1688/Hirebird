package com.recruit.app.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CaseInsensitiveHashMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 7994959088261838582L;

	@Override
	public V get(Object key) {
		if(key instanceof String) {
			return super.get(((String) key).toLowerCase(Locale.getDefault()));
		}
		return super.get(key);
	}

	@Override
	public V put(K key, V value) {
		if(key instanceof String) {
			return super.put((K)((String) key).toLowerCase(Locale.getDefault()), value);
		}
		return super.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		if(map == null || map.size() == 0) {
			return;
		}
		for(Entry<? extends K, ? extends V> entry : map.entrySet()) {
			K key = entry.getKey();
			if(key instanceof String) {
				put((K)((String) key).toLowerCase(Locale.getDefault()), entry.getValue());
			}
		}
	}
	
	public static void main(String[] args) {
		Map<String, String> m = new CaseInsensitiveHashMap<String, String>();
		m.put("a", "b");
		System.out.println(m);
		System.out.println(m.get("A"));
		System.out.println(m.get("a"));
	}
	
}
