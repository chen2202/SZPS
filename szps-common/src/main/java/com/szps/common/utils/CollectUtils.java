package com.szps.common.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CollectUtils {
	public static <K, V> Entry<K, V> getTail(Map<K, V> map) {
	    Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
	    Entry<K, V> tail = null;
	    while (iterator.hasNext()) {
	        tail = iterator.next();
	    }
	    return tail;
	}
}
