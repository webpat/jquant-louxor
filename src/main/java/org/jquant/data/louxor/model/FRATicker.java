package org.jquant.data.louxor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Forward Rate Agreement Ticker 
 * @author patrick.merheb
 *
 */
@Entity
@Table(name = "TICKER_FRA")
public class FRATicker extends AbstractRateTicker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7056247528212419820L;

	
	@Column(name="FOREIGN_CURRENCY")
	private String foreignCurrency;


	public String getForeignCurrency() {
		return foreignCurrency;
	}


	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	
	
}
