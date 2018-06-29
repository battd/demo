package com.trades.processor.demo;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.trades.processor.caches.BookCache;
import com.trades.processor.product.BondTrade;

@Service
public class FixTradeProcessorImpl implements FixTradeProcessor {
	
	final Logger LOGGER = LogManager.getLogger(FixTradeProcessorImpl.class.getName());

	public BookCache bookCache;

	@Autowired
	public void setBookCache(BookCache bookCache) {
		this.bookCache = bookCache;
	}
	
	@Autowired
    private MessageChannel dispatcherChannel;

	@Override
	public void processTrade(String string) {
		
		BondTrade trade = mapCreateXmlObject(string);
        enrichAccounts(trade);
        //enrichInstrument();
        //enrichRegulatory();
        //persistMessage();
        sendToDispatcher(trade); 
	}
	
	private void enrichAccounts(BondTrade trade) {
       
		try {

			String theBook = bookCache.getBookCache().get(trade.getTraderId()).getBookId();
			LOGGER.info("The book name is: " + theBook);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	}

	private void sendToDispatcher(BondTrade trade) {
		 try {
	       JAXBContext jaxbContext = JAXBContext.newInstance(BondTrade.class);
	       Marshaller marshaller = jaxbContext.createMarshaller();
	       StringWriter sw = new StringWriter();
		   marshaller.marshal(trade, sw);
		   String xml = sw.toString();
		   dispatcherChannel.send(MessageBuilder.withPayload(xml).build());
		 }
		   catch (Exception e) {
	           e.printStackTrace();
	       }
		 
	}
	
	protected BondTrade mapCreateXmlObject(String fixMessage) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
		StringBuilder xml = new StringBuilder();
		xml.append("<NewTrade>");
		
		String[] fixarray = fixMessage.split(";");
		
		HashMap<String, String> fixMap = new HashMap<String,String>();
		String fixKey;
		String fixValue;
		
		for(String item : fixarray) {
   			fixKey = item.split("=")[0];
			fixValue = item.split("=")[1];
			System.out.println(fixKey + " " + fixValue);
			fixMap.put(fixKey, fixValue);  
			
		}
		
	   try {
		   builder = builderFactory.newDocumentBuilder();
	       ClassLoader classLoader = getClass().getClassLoader();    		
	       File file = new File(classLoader.getResource("tradeweb_usgv.xml").getFile());
	       Document docConfig = builder.parse(file);
	       NodeList nl = docConfig.getElementsByTagName("*");
	       String nodeKey;
	       String nodeName;
		
	       for (int i = 1; i < nl.getLength(); i++) {			 
	    	   nodeKey = nl.item(i).getAttributes().getNamedItem("tag").getTextContent();
	    	   nodeName = nl.item(i).getNodeName().toString();
	    	   System.out.println(" nodeValue=" + nodeName + " nodeKey=" + nodeKey);
	    	   xml.append("<" + nodeName + ">");
	    	   xml.append(fixMap.get(nodeKey));
	    	   xml.append("</" + nodeName + ">");			 
	       }   	
		
	       xml.append("</NewTrade>");
	       System.out.println(xml.toString());
	       
	       JAXBContext jaxbContext = JAXBContext.newInstance(BondTrade.class);
	       Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	       StringReader reader = new StringReader(xml.toString());
	       BondTrade trade = (BondTrade) unmarshaller.unmarshal(reader);
	       return trade;
	       
	   }
	   catch (Exception e) {
           e.printStackTrace();
       }
	return null;
	   
	}

}
