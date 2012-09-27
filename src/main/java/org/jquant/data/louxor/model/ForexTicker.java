package org.jquant.data.louxor.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  ForexTicker 
 *	Le ticker Louxor pour une paire FOREX 
 */
@Entity
@Table(name = "TICKER_FOREX")
public class ForexTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	@Column(name="FOREIGN_CURRENCY")
	private String foreignCurrency;

	@Column(name="QUOTATION_FACTOR")
	private Double quotationFactor;
	

	public ForexTicker() {
	}


	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	public Double getQuotationFactor() {
		return quotationFactor;
	}


	public void setQuotationFactor(Double quotationFactor) {
		this.quotationFactor = quotationFactor;
	}

}
