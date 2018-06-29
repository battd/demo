package com.trades.processor.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DispatcherImpl implements Dispatcher {
	
	final Logger LOGGER = LogManager.getLogger(DispatcherImpl.class.getName());
	
	@Override
	public void dispatch(String string)
	{
		System.out.println("dispatcher got this: " + string);
	}

}
