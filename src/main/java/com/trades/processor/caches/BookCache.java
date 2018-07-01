package com.trades.processor.caches;

public interface BookCache {

	Book getBook(String traderId);
	
	void putBook(Book book);

}