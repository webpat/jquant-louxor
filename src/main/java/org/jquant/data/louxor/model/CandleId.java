package org.jquant.data.louxor.model;

import java.io.Serializable;
import java.util.Date;

public class CandleId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5493942907987462064L;
	
	
	private Integer tickerId;
	private Date timestamp;
	public Integer getTickerId() {
		return tickerId;
	}
	public void setTickerId(Integer tickerId) {
		this.tickerId = tickerId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
