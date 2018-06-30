package com.trades.processor.caches;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class BookCacheImpl implements BookCache  {	
	
	private ConcurrentHashMap<String, Book> bookMap = new ConcurrentHashMap<>();
	
	/* (non-Javadoc)
	 * @see com.trades.processor.caches.BookCache#getBookCache()
	 */
	@Override
	public ConcurrentHashMap<String, Book> getBookCache() {
		return bookMap;
	}

	public BookCacheImpl() {
		Book primeBook = new Book();
		primeBook.setTraderId("davidb");
		primeBook.setBookId("MAIN");
		primeBook.setBookDescription("Main Book");
		
		Book primeBook2 = new Book();
		primeBook2.setTraderId("sudars");
		primeBook2.setBookId("BOOK2");
		primeBook2.setBookDescription("2nd Book");
		
		Book primeBook3 = new Book();
		primeBook3.setTraderId("abdoa");
		primeBook3.setBookId("BOOK23");
		primeBook3.setBookDescription("23rd Book");
		
		bookMap.put(primeBook.getTraderId(), primeBook);
		bookMap.put(primeBook2.getTraderId(), primeBook2);
		bookMap.put(primeBook3.getTraderId(), primeBook3);		
	}	


}
