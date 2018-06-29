package com.trades.processor.utils;

import java.util.HashMap;

public class MessageUtils {
	
	HashMap<String,String> fixMap = new HashMap<String,String>();
	
	public MessageUtils(String fixMessage) {
		String[] fixarray = fixMessage.split(";");		
		String fixKey;
		String fixValue;
		
		for(String item : fixarray) {
   			fixKey = item.split("=")[0];
			fixValue = item.split("=")[1];
			System.out.println(fixKey + " " + fixValue);
			fixMap.put(fixKey, fixValue);  
			
		}
	}
	
	public String getStringField(String field) {
		return fixMap.get(field);		
	}

}
