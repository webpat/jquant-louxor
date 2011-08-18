package org.jquant.data.louxor.model;


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

	

	

	public ForexTicker() {
	}

	
	

}
