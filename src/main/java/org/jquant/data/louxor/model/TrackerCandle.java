package org.jquant.data.louxor.model;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * TrackerCandle 
 * An tracker Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_TRACKER")
public class TrackerCandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public TrackerCandle() {
	}

	
	
	
}
