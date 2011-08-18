package org.jquant.data.louxor.model;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * RateCandle 
 * An Currency Rate Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_RATE")
public class RateCandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public RateCandle() {
	}

	
	
	
}
