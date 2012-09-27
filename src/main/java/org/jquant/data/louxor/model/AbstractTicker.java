package org.jquant.data.louxor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Immutable;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Immutable
public class AbstractTicker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8234360114008164585L;
	
	@Id
	@Column(name="TICKER_ID")
	private String tickerId;

	
	@Column(name="INTERNAL_CODE")
	private String internalCode;

	@Column(name="INSTRUMENT_ID")
	private Integer instrumentId;

	private String name;

	
	@Column(name="PROVIDER_NAME")
	private String providerName;

	private String ticker;

	
	@Column(name="PAYMENT_CURRENCY")
	private String paymentCurrency;


	@Column(name="FIRST_QUOTE")
	private Date firstQuote;

	@Column(name="LAST_QUOTE")
	private Date lastQuote;
	
	
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

	
	public String getPaymentCurrency() {
		return this.paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
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

	
	
	@Override
	public String toString() {
		return "Ticker [internalCode=" + internalCode + ", name=" + name + ", providerName=" + providerName +  
			   ", paymentCurrency=" + paymentCurrency + ", firstQuote=" + firstQuote+ ", lastQuote=" + lastQuote +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tickerId == null) ? 0 : tickerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTicker other = (AbstractTicker) obj;
		if (tickerId == null) {
			if (other.tickerId != null)
				return false;
		} else if (!tickerId.equals(other.tickerId))
			return false;
		return true;
	}
	
}
