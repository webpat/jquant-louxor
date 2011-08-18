package org.jquant.data.louxor.model;

// Generated 1 juil. 2011 17:52:26 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  StockTicker 
 *	Le ticker Louxor pour un EQUITY Stock  
 */
@Entity
@Table(name = "TICKER_STOCK")
public class StockTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	

	@Column(name="ISSUER_ID")
	private Integer issuerId;

	@Column(name="ISSUER_NAME")
	private String issuerName;

	@Column(name="ISSUE_AMOUNT")
	private Integer issueAmount;

	
	@Column(name="DIVIDEND_FREQUENCY")
	private String dividendFrequency;

	@Column(name="LOT_SIZE")
	private Integer lotSize;



	
	@Column(name="FUNDAMENTAL_CURRENCY")
	private String fundamentalCurrency;
	

	public StockTicker() {
	}

	
	public Integer getIssuerId() {
		return this.issuerId;
	}

	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
	}

	public String getIssuerName() {
		return this.issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public Integer getIssueAmount() {
		return this.issueAmount;
	}

	public void setIssueAmount(Integer issueAmount) {
		this.issueAmount = issueAmount;
	}

	public String getDividendFrequency() {
		return this.dividendFrequency;
	}

	public void setDividendFrequency(String dividendFrequency) {
		this.dividendFrequency = dividendFrequency;
	}

	public Integer getLotSize() {
		return this.lotSize;
	}

	public void setLotSize(Integer lotSize) {
		this.lotSize = lotSize;
	}

	

	public String getFundamentalCurrency() {
		return this.fundamentalCurrency;
	}

	public void setFundamentalCurrency(String fundamentalCurrency) {
		this.fundamentalCurrency = fundamentalCurrency;
	}

	

}
