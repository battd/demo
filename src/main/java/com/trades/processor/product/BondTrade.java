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
	@XmlElement(name = "RiskBook")
	private String riskBook;
	@XmlElement(name = "IDM")
	private String idm;
	@XmlElement(name = "EDM")
	private String edm;
	@XmlElement(name = "LEI")
	private String lei;
	@XmlElement(name = "Basis")
	private boolean isBasis;

	
	public boolean isBasis() {
		return isBasis;
	}
	@XmlTransient
	public void setBasis(boolean isBasis) {
		this.isBasis = isBasis;
	}
	public String getIdm() {
		return idm;
	}
	@XmlTransient
	public void setIdm(String idm) {
		this.idm = idm;
	}

	public String getEdm() {
		return edm;
	}
	@XmlTransient
	public void setEdm(String edm) {
		this.edm = edm;
	}

	public String getLei() {
		return lei;
	}
	@XmlTransient 
	public void setLei(String lei) {
		this.lei = lei;
	}

	public String getRiskBook() {
		return riskBook;
	}

	@XmlTransient
	public void setRiskBook(String riskBook) {
		this.riskBook = riskBook;
	}

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
