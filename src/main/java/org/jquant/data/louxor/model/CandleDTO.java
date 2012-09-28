package org.jquant.data.louxor.model;

import java.io.Serializable;
import java.util.Date;

public class CandleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7564788412838997397L;

	private String tickerId;

	private String name;
	
	private String internalCode;

	private String ticker;

	private String micCode;

	private String paymentCurrency;

	private Date timestamp;

	private Long open;

	private Long high;

	private Long low;

	private Long close;

	private Integer volume;

	private Long vwap;

	public String getTickerId() {
		return tickerId;
	}

	public void setTickerId(String tickerId) {
		this.tickerId = tickerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getMicCode() {
		return micCode;
	}

	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getOpen() {
		return open;
	}

	public void setOpen(Long open) {
		this.open = open;
	}

	public Long getHigh() {
		return high;
	}

	public void setHigh(Long high) {
		this.high = high;
	}

	public Long getLow() {
		return low;
	}

	public void setLow(Long low) {
		this.low = low;
	}

	public Long getClose() {
		return close;
	}

	public void setClose(Long close) {
		this.close = close;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Long getVwap() {
		return vwap;
	}

	public void setVwap(Long vwap) {
		this.vwap = vwap;
	}
	
	
	
}
