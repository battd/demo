package com.trades.processor.demo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TradeSimulatorImpl implements TradeSimulator {

	ArrayList<String> cusips = new ArrayList<String>(Arrays.asList("9128284J6","9128284P2","9128284L1","9128284M9","9128284N7"));
	ArrayList<String> traders = new ArrayList<String>(Arrays.asList("sudars","davidb","abdoa"));
	
	HashMap<String,String> messageContent = new HashMap<>();
	
    @Autowired
    private MessageChannel fixTradeChannel;

	@Override
	public void Simulate() {
		//35=8;75=2018-05-10;9114=2018-05-11;60=2018-05-10T14:59:53.708098;48=9128284M9;55=davidb;15=2;31=99.40625;38=8000000;
		for (int i = 0; i < 20; i++) {
			StringBuilder sb = new StringBuilder();
			Random r = new Random();
			sb.append("35=8;75=" + LocalDate.now().toString() + ";9114=" + LocalDate.now().plusDays(1).toString()
					+ ";60=" + LocalDateTime.now().toString() + ";");
			sb.append("48=" + cusips.get(r.nextInt(cusips.size())) + ";");
			sb.append("55=" + traders.get(r.nextInt(traders.size())) + ";");
			sb.append("15=" + r.ints(1, 3).findFirst().getAsInt() + ";");
			int a = r.ints(1, 32).findFirst().getAsInt();
			double dec = ((double) a) / 32d + r.ints(98, 104).findFirst().getAsInt();
			sb.append("31=" + dec + ";");
			sb.append("38=" + (r.ints(1, 16).findFirst().getAsInt()) * 1000000 + ";");
			fixTradeChannel.send(MessageBuilder.withPayload(sb.toString()).build());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
