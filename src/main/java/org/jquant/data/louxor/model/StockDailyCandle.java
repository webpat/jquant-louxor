package org.jquant.data.louxor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;




/**
 * StockDailyCandle 
 * An Equity Stock Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_STOCK")
@IdClass(CandleId.class)
public class StockDailyCandle implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	@Id
	private Integer tickerId;

	private String name;

	private String internalCode;

	private String ticker;

	private String micCode;

	private String paymentCurrency;

	@Id
	private Date timestamp;

	private Long open;

	private Long high;

	private Long low;

	private Long close;

	private Integer volume;

	private Long vwap;

	private Long openInterest;

	public StockDailyCandle() {
	}

	

	public Integer getTickerId() {
		return this.tickerId;
	}

	public void setTickerId(Integer tickerId) {
		this.tickerId = tickerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalCode() {
		return this.internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getMicCode() {
		return this.micCode;
	}

	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}

	public String getPaymentCurrency() {
		return this.paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getOpen() {
		return this.open;
	}

	public void setOpen(Long open) {
		this.open = open;
	}

	public Long getHigh() {
		return this.high;
	}

	public void setHigh(Long high) {
		this.high = high;
	}

	public Long getLow() {
		return this.low;
	}

	public void setLow(Long low) {
		this.low = low;
	}

	public Long getClose() {
		return this.close;
	}

	public void setClose(Long close) {
		this.close = close;
	}

	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Long getVwap() {
		return this.vwap;
	}

	public void setVwap(Long vwap) {
		this.vwap = vwap;
	}

	public Long getOpenInterest() {
		return this.openInterest;
	}

	public void setOpenInterest(Long openInterest) {
		this.openInterest = openInterest;
	}

}
