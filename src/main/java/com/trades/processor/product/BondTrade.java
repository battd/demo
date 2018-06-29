package com.trades.processor.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "NewTrade")
public class BondTrade implements Trade {
	
	@XmlElement(name = "TradeDate")
	private String tradeDate;
	@XmlElement(name = "SettleDate")
	private String settleDate;
	@XmlElement(name = "TransactionTime")
	private String transactionTime;
	@XmlElement(name = "Cusip")
	private String cusip;
	@XmlElement(name = "TraderId")
	private String traderId;
	@XmlElement(name = "Side")
	private String side;
	@XmlElement(name = "Price")
	private String price;
	@XmlElement(name = "Quantity")
	private String quantity;

	
	public String getTradeDate() {
		return tradeDate;
	}

	@XmlTransient
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	
	public String getSettleDate() {
		return settleDate;
	}

	@XmlTransient
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	
	public String getTransactionTime() {
		return transactionTime;
	}

	@XmlTransient
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	
	public String getCusip() {
		return cusip;
	}

	@XmlTransient
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	
	public String getTraderId() {
		return traderId;
	}

	@XmlTransient
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	
	public String getSide() {
		return side;
	}

	@XmlTransient
	public void setSide(String side) {
		this.side = side;
	}

	
	public String getPrice() {
		return price;
	}

	@XmlTransient
	public void setPrice(String price) {
		this.price = price;
	}

	
	public String getQuantity() {
		return quantity;
	}
    
	@XmlTransient
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public void dpdyCalc() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accruedInterestCalc() {
		// TODO Auto-generated method stub

	}

}
