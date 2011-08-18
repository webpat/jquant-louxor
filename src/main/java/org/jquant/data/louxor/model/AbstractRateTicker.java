package org.jquant.data.louxor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class AbstractRateTicker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6401424889025004090L;
	
	@Id
	@Column(name="TICKER_ID")
	private String tickerId;
	
	@Column(name="INTERNAL_CODE")
	private String internalCode;
	
	@Column(name="PAYMENT_CURRENCY")
	private String paymentCurrency;
	
	@Column(name="MATURITY")
	private Integer maturity;	
	
	@Column(name="TIME_UNIT")
	private String timeUnit;

	public String getTickerId() {
		return tickerId;
	}

	public void setTickerId(String tickerId) {
		this.tickerId = tickerId;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Integer getMaturity() {
		return maturity;
	}

	public void setMaturity(Integer maturity) {
		this.maturity = maturity;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	

}
