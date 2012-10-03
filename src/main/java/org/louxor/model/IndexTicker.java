package org.louxor.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  IndexTicker 
 *	Le ticker Louxor pour un Index (Indice de Marché) 
 */
@Entity
@Table(name = "TICKER_INDEX")
public class IndexTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	@Column(name="MIC_CODE")
	private String micCode;

	@Column(name="UPDATE_FREQUENCY")
	private String updateFrequency;

	@Column(name="QUOTATION_FACTOR")
	private Long quotationFactor;
	
	@Column(name="QUOTE_PERCENT")
	private Boolean quotePercent;
	
	

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



	public Boolean getQuotePercent() {
		return quotePercent;
	}



	public void setQuotePercent(Boolean quotePercent) {
		this.quotePercent = quotePercent;
	}



	public IndexTicker() {
	}



	public String getMicCode() {
		return micCode;
	}



	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}

	
	

}
