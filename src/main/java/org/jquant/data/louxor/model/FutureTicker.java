package org.jquant.data.louxor.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  TrackerTicker 
 *	Le ticker Louxor pour un ETF   
 */
@Entity
@Table(name = "TICKER_FUTURE")
public class FutureTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	
	@Column(name="FIRST_TRADE_DATE")
	private Date firstTradeDate;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="LAST_TRADE_DATE")
	private Date lastTradeDate;
	
	@Column(name="FIRST_NOTICE_DATE")
	private Date firstNoticeDate;
	
	@Column(name="FIRST_DELIVERY_DATE")
	private Date firstDeliveryDate;
	
	@Column(name="LAST_DELIVERY_DATE")
	private Date lastDeliveryDate;
	
	@Column(name="BASIS_POINT_VALUE")
	private Integer basisPointValue;

	@Column(name="NOTIONAL_BOND")
	private String notionalBond;
	
	@Column(name="QUOTE_UNITS")
	private String quoteUnits;
	
	@Column(name="SHORT_NAME")
	private String shortName;
	
	@Column(name="TICK_SIZE")
	private Integer tickSize;

	@Column(name="UNDERLYING_INSTRUMENT_ID")
	private String underlyingInstrumentId;

	@Column(name="UNDERLYING_INSTRUMENT_NAME")
	private String underlyingInstrumentName;

	@Column(name="UNDERLYING_INSTRUMENT_TYPE")
	private String underlyingInstrumentType;
	
	@Column(name="UNDERLYING_INSTRUMENT_CODE")
	private String underlyingInstrumentCode;
	
	@Column(name="UNDERLYING_TICKER_ID")
	private String underlyingTickerId;
	
	@Column(name="UNDERLYING_TICKER")
	private String underlyingTicker;
	
	@Column(name="UNDERLYING_MIC_CODE")
	private String underlyingMicCode;
	
	@Column(name="MIC_CODE")
	private String micCode;
	
	@Column(name="UPDATE_FREQUENCY")
	private String updateFrequency;

	@Column(name="QUOTATION_FACTOR")
	private Long quotationFactor;
	
	public FutureTicker() {
	}

	
	
	public Integer getTickSize() {
		return this.tickSize;
	}

	public void setTickSize(Integer lotSize) {
		this.tickSize = lotSize;
	}

	

	



	public String getUnderlyingInstrumentId() {
		return underlyingInstrumentId;
	}


	public void setUnderlyingInstrumentId(String underlyingInstrumentId) {
		this.underlyingInstrumentId = underlyingInstrumentId;
	}


	public String getUnderlyingInstrumentName() {
		return underlyingInstrumentName;
	}


	public void setUnderlyingInstrumentName(String underlyingInstrumentName) {
		this.underlyingInstrumentName = underlyingInstrumentName;
	}


	public String getUnderlyingInstrumentType() {
		return underlyingInstrumentType;
	}


	public void setUnderlyingInstrumentType(String underlyingInstrumentType) {
		this.underlyingInstrumentType = underlyingInstrumentType;
	}


	public String getUnderlyingInstrumentCode() {
		return underlyingInstrumentCode;
	}


	public void setUnderlyingInstrumentCode(String underlyingInstrumentCode) {
		this.underlyingInstrumentCode = underlyingInstrumentCode;
	}


	public String getUnderlyingTickerId() {
		return underlyingTickerId;
	}


	public void setUnderlyingTickerId(String underlyingTickerId) {
		this.underlyingTickerId = underlyingTickerId;
	}


	public String getUnderlyingTicker() {
		return underlyingTicker;
	}


	public void setUnderlyingTicker(String underlyingTicker) {
		this.underlyingTicker = underlyingTicker;
	}



	public String getUnderlyingMicCode() {
		return underlyingMicCode;
	}


	public void setUnderlyingMicCode(String underlyingMicCode) {
		this.underlyingMicCode = underlyingMicCode;
	}



	public Date getFirstTradeDate() {
		return firstTradeDate;
	}



	public void setFirstTradeDate(Date firstTradeDate) {
		this.firstTradeDate = firstTradeDate;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getLastTradeDate() {
		return lastTradeDate;
	}



	public void setLastTradeDate(Date lastTradeDate) {
		this.lastTradeDate = lastTradeDate;
	}



	public Date getFirstNoticeDate() {
		return firstNoticeDate;
	}



	public void setFirstNoticeDate(Date firstNoticeDate) {
		this.firstNoticeDate = firstNoticeDate;
	}



	public Date getFirstDeliveryDate() {
		return firstDeliveryDate;
	}



	public void setFirstDeliveryDate(Date firstDeliveryDate) {
		this.firstDeliveryDate = firstDeliveryDate;
	}



	public Date getLastDeliveryDate() {
		return lastDeliveryDate;
	}



	public void setLastDeliveryDate(Date lastDeliveryDate) {
		this.lastDeliveryDate = lastDeliveryDate;
	}



	public Integer getBasisPointValue() {
		return basisPointValue;
	}



	public void setBasisPointValue(Integer basisPointValue) {
		this.basisPointValue = basisPointValue;
	}



	public String getNotionalBond() {
		return notionalBond;
	}



	public void setNotionalBond(String notionalBond) {
		this.notionalBond = notionalBond;
	}



	public String getQuoteUnits() {
		return quoteUnits;
	}



	public void setQuoteUnits(String quoteUnits) {
		this.quoteUnits = quoteUnits;
	}



	public String getShortName() {
		return shortName;
	}



	public void setShortName(String shortName) {
		this.shortName = shortName;
	}



	public String getMicCode() {
		return micCode;
	}



	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}



	public String getUpdateFrequency() {
		return updateFrequency;
	}



	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}



	public Long getQuotationFactor() {
		return quotationFactor;
	}



	public void setQuotationFactor(Long quotationFactor) {
		this.quotationFactor = quotationFactor;
	}

	
	

	
	

}
