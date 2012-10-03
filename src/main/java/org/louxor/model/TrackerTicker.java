package org.louxor.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  TrackerTicker 
 *	Le ticker Louxor pour un ETF   
 */
@Entity
@Table(name = "TICKER_TRACKER")
public class TrackerTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	

	@Column(name="ISSUER_ID")
	private Integer issuerId;

	@Column(name="ISSUER_NAME")
	private String issuerName;

	@Column(name="MIC_CODE")
	private String micCode;

	
	@Column(name="DIVIDEND_FREQUENCY")
	private String dividendFrequency;

	@Column(name="LOT_SIZE")
	private Integer lotSize;

	@Column(name="INCEPTION_DATE")
	private Date inceptionDate;
	
	@Column(name="REDEMPTION_DATE")
	private Date redemptionDate;

	
	@Column(name="MANAGEMENT_COMPANY")
	private String managementCompany;
	
	@Column(name="PARENT_COMPANY_NAME")
	private String parentCompanyName;
	
	@Column(name="REF_INDEX_TICKER")
	private String refIndexTicker;

	
	
	
	public TrackerTicker() {
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


	public String getMicCode() {
		return micCode;
	}


	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}



}
