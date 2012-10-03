package org.louxor.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  OPTION Ticker 
 *	Le ticker Louxor pour une Option quotée    
 */
@Entity
@Table(name = "TICKER_OPTION")
public class OptionTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	
	@Column(name="DELIVERY")
	private Date delivery;

	@Column(name="FIRST_TRADE_DATE")
	private Date firstTradeDate;
	
	@Column(name="EXPIRATION_DATE")
	private Date expirationDate;

	@Column(name="CONTRACT_UNIT")
	private Integer contractUnit;
	
	@Column(name="EXERCICE_TYPE")
	private String exerciceType;
	
	@Column(name="STRIKE")
	private Integer strike;
	
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
	
	@Column(name="UNDERLYING_MIC_ID")
	private String underlyingMicId;
	
	@Column(name="UNDERLYING_MIC_CODE")
	private String underlyingMicCode;
	
	
	
	public OptionTicker() {
	}

	

	public Date getFirstTradeDate() {
		return firstTradeDate;
	}



	public void setFirstTradeDate(Date firstTradeDate) {
		this.firstTradeDate = firstTradeDate;
	}



	public Date getExpirationDate() {
		return expirationDate;
	}



	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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


	public String getUnderlyingMicId() {
		return underlyingMicId;
	}


	public void setUnderlyingMicId(String underlyingMicId) {
		this.underlyingMicId = underlyingMicId;
	}


	public String getUnderlyingMicCode() {
		return underlyingMicCode;
	}


	public void setUnderlyingMicCode(String underlyingMicCode) {
		this.underlyingMicCode = underlyingMicCode;
	}



	public Date getDelivery() {
		return delivery;
	}



	public void setDelivery(Date delivery) {
		this.delivery = delivery;
	}



	public Integer getContractUnit() {
		return contractUnit;
	}



	public void setContractUnit(Integer contractUnit) {
		this.contractUnit = contractUnit;
	}



	public String getExerciceType() {
		return exerciceType;
	}



	public void setExerciceType(String exerciceType) {
		this.exerciceType = exerciceType;
	}



	public Integer getStrike() {
		return strike;
	}



	public void setStrike(Integer strike) {
		this.strike = strike;
	}

	

}
