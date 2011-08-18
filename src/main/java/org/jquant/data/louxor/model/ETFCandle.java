package org.jquant.data.louxor.model;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * ETFCandle 
 * An tracker Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_ETF")
public class ETFCandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public ETFCandle() {
	}

	
	
	
}
