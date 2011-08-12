package org.jquant.data.louxor.model;

// Generated 1 juil. 2011 17:52:26 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *  StockTicker 
 *	Le ticker Louxor pour un EQUITY Stock  
 */
@Entity
@Table(name = "TICKER_STOCK")
public class StockTicker implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	@Id
	@Column(name="TICKER_ID")
	private String tickerId;

	
	@Column(name="INTERNAL_CODE")
	private String internalCode;

	@Column(name="INSTRUMENT_ID")
	private Integer instrumentId;

	private String name;

	@Column(name="QUOTE_PERCENT")
	private Long quotePercent;

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

	@Column(name="PROVIDER_ID")
	private Integer providerId;

	@Column(name="PROVIDER_NAME")
	private String providerName;

	private String ticker;

	@Column(name="PROVIDER_MARKET_NAME")
	private String providerMarketName;

	@Column(name="MIC_ID")
	private Integer micId;

	@Column(name="MIC_CODE")
	private String micCode;

	private String acronym;

	private String description;

	private String city;

	@Column(name="PAYMENT_CURRENCY")
	private String paymentCurrency;

	@Column(name="FUNDAMENTAL_CURRENCY")
	private String fundamentalCurrency;
	
	@Column(name="UPDATE_FREQUENCY")
	private String updateFrequency;

	@Column(name="QUOTATION_FACTOR")
	private Long quotationFactor;

	@Column(name="FIRST_QUOTE")
	private Date firstQuote;

	@Column(name="LAST_QUOTE")
	private Date lastQuote;
	
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="DAILY_UPDATE")
	private Integer dailyUpdate;
	@Column(name="LAST_UPDATE")
	private String lastUpdate;

	

	public StockTicker() {
	}

	public StockTicker(String tickerId) {
		this.tickerId = tickerId;
	}

	public StockTicker(String tickerId, String internalCode, Integer instrumentId, String name, Long quotePercent, Integer issuerId, String issuerName, Integer issueAmount, String dividendFrequency,
			Integer lotSize, Integer providerId, String providerName, String ticker, String providerMarketName, Integer micId, String micCode, String acronym, String description, String city,
			String paymentCurrency, String fundamentalCurrency, String updateFrequency, Long quotationFactor, Date firstQuote, Date lastQuote, Date startDate, Integer dailyUpdate, String lastUpdate) {
		this.tickerId = tickerId;
		this.internalCode = internalCode;
		this.instrumentId = instrumentId;
		this.name = name;
		this.quotePercent = quotePercent;
		this.issuerId = issuerId;
		this.issuerName = issuerName;
		this.issueAmount = issueAmount;
		this.dividendFrequency = dividendFrequency;
		this.lotSize = lotSize;
		this.providerId = providerId;
		this.providerName = providerName;
		this.ticker = ticker;
		this.providerMarketName = providerMarketName;
		this.micId = micId;
		this.micCode = micCode;
		this.acronym = acronym;
		this.description = description;
		this.city = city;
		this.paymentCurrency = paymentCurrency;
		this.fundamentalCurrency = fundamentalCurrency;
		this.updateFrequency = updateFrequency;
		this.quotationFactor = quotationFactor;
		this.firstQuote = firstQuote;
		this.lastQuote = lastQuote;
		this.startDate = startDate;
		this.dailyUpdate = dailyUpdate;
		this.lastUpdate = lastUpdate;
		
	}

	public String getTickerId() {
		return this.tickerId;
	}

	public void setTickerId(String tickerId) {
		this.tickerId = tickerId;
	}

	public String getInternalCode() {
		return this.internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public Integer getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuotePercent() {
		return this.quotePercent;
	}

	public void setQuotePercent(Long quotePercent) {
		this.quotePercent = quotePercent;
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

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getProviderMarketName() {
		return this.providerMarketName;
	}

	public void setProviderMarketName(String providerMarketName) {
		this.providerMarketName = providerMarketName;
	}

	public Integer getMicId() {
		return this.micId;
	}

	public void setMicId(Integer micId) {
		this.micId = micId;
	}

	public String getMicCode() {
		return this.micCode;
	}

	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPaymentCurrency() {
		return this.paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getFundamentalCurrency() {
		return this.fundamentalCurrency;
	}

	public void setFundamentalCurrency(String fundamentalCurrency) {
		this.fundamentalCurrency = fundamentalCurrency;
	}

	public String getUpdateFrequency() {
		return this.updateFrequency;
	}

	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public Long getQuotationFactor() {
		return this.quotationFactor;
	}

	public void setQuotationFactor(Long quotationFactor) {
		this.quotationFactor = quotationFactor;
	}

	public Date getFirstQuote() {
		return this.firstQuote;
	}

	public void setFirstQuote(Date firstQuote) {
		this.firstQuote = firstQuote;
	}

	public Date getLastQuote() {
		return this.lastQuote;
	}

	public void setLastQuote(Date lastQuote) {
		this.lastQuote = lastQuote;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getDailyUpdate() {
		return this.dailyUpdate;
	}

	public void setDailyUpdate(Integer dailyUpdate) {
		this.dailyUpdate = dailyUpdate;
	}

	public String getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


}
