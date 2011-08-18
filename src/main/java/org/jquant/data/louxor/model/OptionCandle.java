package org.jquant.data.louxor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * StockCandle 
 * An Equity Stock Candle from close to close
 *
 */
@Entity
@Table(name = "CANDLE_OPTION")
public class OptionCandle extends AbstractCandle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7314193465834943229L;

	

	public OptionCandle() {
	}


	@Column(name="MIC_ID")
	private String micId;



	public String getMicId() {
		return micId;
	}


	public void setMicId(String micId) {
		this.micId = micId;
	}
	
	
	
}
