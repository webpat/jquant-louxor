package org.jquant.data.louxor.model;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * StockCandle 
 * An Equity Stock Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_FOREX")
public class ForexCandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public ForexCandle() {
	}

	
	
	
}
