package org.jquant.data.louxor.model;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * StockCandle 
 * A Forward Rate Agreement Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_FRA")
public class FRACandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public FRACandle() {
	}

	
	
	
}
