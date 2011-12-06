package org.jquant.data.louxor.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  ETFTicker 
 *	Le ticker Louxor pour un ETF   
 */
@Entity
@Table(name = "TICKER_ETF")
public class ETFTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	

	@Column(name="ISSUER_ID")
	private Integer issuerId;

	@Column(name="ISSUER_NAME")
	private String issuerName;

	

	
	@Column(name="DIVIDEND_FREQUENCY")
	private String dividendFrequency;

	@Column(name="LOT_SIZE")
	private Integer lotSize;

	@Column(name="INCEPTION_DATE")
	private Date inceptionDate;
	
	@Column(name="REDEMPTION_DATE")
	private Date redemptionDate;

	
	@Column(name="FUNDAMENTAL_CURRENCY")
	private String fundamentalCurrency;
	
	@Column(name="MANAGEMENT_COMPANY")
	private String managementCompany;
	
	@Column(name="PARENT_COMPANY_NAME")
	private String parentCompanyName;
	
	@Column(name="REF_INDEX_TICKER")
	private String refIndexTicker;

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
	
	
	
	public ETFTicker() {
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


	public Date getInceptionDate() {
		return inceptionDate;
	}


	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}


	public Date getRedemptionDate() {
		return redemptionDate;
	}


	public void setRedemptionDate(Date redemptionDate) {
		this.redemptionDate = redemptionDate;
	}


	public String getManagementCompany() {
		return managementCompany;
	}


	public void setManagementCompany(String managementCompany) {
		this.managementCompany = managementCompany;
	}


	public String getParentCompanyName() {
		return parentCompanyName;
	}


	public void setParentCompanyName(String parentCompanyName) {
		this.parentCompanyName = parentCompanyName;
	}


	public String getRefIndexTicker() {
		return refIndexTicker;
	}


	public void setRefIndexTicker(String refIndexTicker) {
		this.refIndexTicker = refIndexTicker;
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

	
	

	
	

}
