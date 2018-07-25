package com.trades.processor.caches;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.trades.processor.utils.ProcessorDAO;

@Component
public class BookCacheImpl implements BookCache  {	
	
	private Map<String, Book> bookMap = new ConcurrentHashMap<String, Book>();
	@Override
	public Book getBook(String traderId) {
		return bookMap.get(traderId);
	}
	
	@Override
	public void putBook(Book book) {
		bookMap.put(book.getTraderId(), book);
	}

	public BookCacheImpl(ProcessorDAO processorDAO) {
		processorDAO.getBooks();
		
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
