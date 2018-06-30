package com.trades.processor.caches;

import java.util.concurrent.ConcurrentHashMap;

public interface BookCache {

	ConcurrentHashMap<String, Book> getBookCache();

}