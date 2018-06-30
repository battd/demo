package com.trades.processor.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountFileEnricherImpl implements AccountEnricher {
	HashMap<String,String> accountMap = new HashMap<>();
	
	public AccountFileEnricherImpl() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		
		File file = new File(classLoader.getResource("Accounts.txt").getFile());
	    try {
			String text = FileUtils.readFileToString(file, "UTF-8");
			String[] accounts = text.split(",");
			for(String account : accounts)
			{
				String traderAccount[] = account.split("=");
				accountMap.put(traderAccount[0], traderAccount[1]);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public String enrichAccounts(String traderId) {		
		return accountMap.get(traderId);
	}

}
