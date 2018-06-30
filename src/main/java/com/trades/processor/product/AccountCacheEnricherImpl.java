package com.trades.processor.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trades.processor.caches.BookCache;

@Service	
public class AccountCacheEnricherImpl implements AccountEnricher{
	
	final Logger LOGGER = LogManager.getLogger(AccountCacheEnricherImpl.class.getName());
	
	public BookCache bookCache;

	@Autowired
	public void setBookCache(BookCache bookCache) {
		this.bookCache = bookCache;
	}
	
	public String enrichAccounts(String trader) {
	       
		try {

			String theBook = bookCache.getBookCache().get(trader).getBookId();
			LOGGER.info("The book name is: " + theBook);
			return theBook;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

}
