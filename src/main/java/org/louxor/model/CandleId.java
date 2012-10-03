package org.louxor.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Identifiant pour un {@link StockCandle}
 * @author patrick.merheb
 *
 */
public class CandleId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5493942907987462064L;
	
	
	private String tickerId;
	private Date timestamp;
	
	
	
	public String getTickerId() {
		return tickerId;
	}
	public void setTickerId(String tickerId) {
		this.tickerId = tickerId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
