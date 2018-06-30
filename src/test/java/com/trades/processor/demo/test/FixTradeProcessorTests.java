package com.trades.processor.demo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;

import com.trades.processor.demo.FixTradeProcessorImpl;
import com.trades.processor.product.AccountCacheEnricherImpl;
import com.trades.processor.product.BondTrade;

public class FixTradeProcessorTests {

    @Mock
    AccountCacheEnricherImpl accountEnricher;  
   
	
	@Test
	public void testMapCreateXmlObject() {
		FixTradeProcessorImpl ftp = new FixTradeProcessorImpl(accountEnricher);
		String fixMessage = "35=8;75=2018-05-10;9114=2018-05-11;60=2018-05-10T14:59:53.708098;48=9128284M9;55=davidb;15=2;31=99.40625;38=8000000;";
		BondTrade bondTrade = ftp.mapCreateXmlObject(fixMessage);
		assertTrue(bondTrade.getTraderId().equals("davidb"));		
	}

}
