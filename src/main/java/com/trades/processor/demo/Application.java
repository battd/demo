package com.trades.processor.demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Application {

	public static void main(String[] args) {			
		
		final Logger LOGGER = LogManager.getLogger(Application.class.getName());
		
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
		
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        TradeSimulator tradeSimulator = applicationContext.getBean( "tradeSimulatorImpl", TradeSimulator.class );
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) applicationContext.getBean("taskExecutor");                
        taskExecutor.execute(applicationContext.getBean(ManualBookUpdateSimulator.class));
            	
       for (int t=0;t<2;t++) {
        		tradeSimulator.Simulate();
        		try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
        	}
        }            

        applicationContext.close();

	}

}

