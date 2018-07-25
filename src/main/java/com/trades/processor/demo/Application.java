package com.trades.processor.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import com.trades.processor.config.BondTradeConfiguration;

@SpringBootApplication
@EnableAsync
@Import(BondTradeConfiguration.class)
public class Application implements CommandLineRunner {	

    @Autowired
    public TaskExecutor taskExecutor;
    
    @Autowired
    public ManualBookUpdateSimulator manualBookUpdateSimulator;
    
    @Autowired
    public TradeSimulator tradeSimulatorImpl; 
    
    
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
	  Runnable simulate = () -> tradeSimulatorImpl.Simulate();
      taskExecutor.execute(simulate); 
      taskExecutor.execute(manualBookUpdateSimulator);
      
		
	}

}

