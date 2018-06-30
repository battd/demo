package com.trades.processor.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.trades.processor.caches.BookCache;
import com.trades.processor.caches.BookCacheImpl;
import com.trades.processor.product.AccountEnricher;
import com.trades.processor.product.AccountFileEnricherImpl;

@Configuration
@ComponentScan("com.trades.procesor.*")	
@EnableIntegration
public class BondTradeConfiguration {
    
    @Bean
    @Description("Input fix trades")
    public MessageChannel fixTradeChannel() {
        return new DirectChannel();
    }
    
    @Bean
    @Description("Output to Dispatcher")
    public MessageChannel dispatcherChannel() {
        return new DirectChannel();
    }
    
    @Bean
    @Description("Account Enrichment")
    public AccountEnricher accountEnrichment() {
    	return new AccountFileEnricherImpl();
    }   
    
    @Bean
    @Description("Book Cache")
    public BookCache bookCache() {
    	return new BookCacheImpl();
    } 
    
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }
  
}
