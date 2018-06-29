package com.trades.processor.demo;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.trades.processor.caches.Book;
import com.trades.processor.caches.BookCache;

@Component
@Scope("prototype")
public class ManualBookUpdateSimulator implements Runnable {
	
	final Logger LOGGER = LogManager.getLogger(ManualBookUpdateSimulator.class.getName());
	
	private BookCache bookCache;

	@Autowired
	public void setBookCache(BookCache bookCache) {
		this.bookCache = bookCache;
	}

	@Override
	public void run() {
		String[] traders = {"davidb","sudars","abdoa"};
		Random r = new Random();
		for(int i=0;i<1000000;i++) {
			try {
			Integer index = r.nextInt(2);
			LOGGER.error("HERE !!!!!");
			Book b = bookCache.getBookCache().get(traders[index]);
			b.setBookId("GEN" + i);
			bookCache.getBookCache().put(b.getTraderId(), b);
			LOGGER.info("Updated Book " + b.getBookId());
			
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e)
			{
				LOGGER.error(e.getMessage());
			}
			
		}
		
	}
	
	

}
