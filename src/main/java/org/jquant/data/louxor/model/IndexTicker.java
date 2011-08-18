package org.jquant.data.louxor.model;


import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *  IndexTicker 
 *	Le ticker Louxor pour un Index (Indice de Marché) 
 */
@Entity
@Table(name = "TICKER_INDEX")
public class IndexTicker extends AbstractTicker {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7850403728859999711L;

	

	

	public IndexTicker() {
	}

	
	

}
