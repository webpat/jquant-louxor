package org.jquant.data.louxor;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.jquant.core.Candle;
import org.jquant.data.reader.ICandleReader;
import org.jquant.exception.MarketDataReaderException;
import org.jquant.serie.CandleSerie;
import org.springframework.stereotype.Service;
/**
 * This class is at the hedge of the DATA/SERVICE layers.<br>
 * It's a provider specific TimeSerie reader <br>
 * Fetch methods transforms the List/Vector of TimeValues (Quote,Rate,Candle) 
 * in TIME INDEXED TimeSeries 
 * 
 * It enables an abstraction level with the data provider (Louxor/Yahoo/IB/TENFORE etc...)
 * A specific LOOKUP mechanism has to be implemented for each DataProviders
 * <ul>
 * <li>Load Data from Data Layer</li>
 * <li>eventually apply transformations on the Transfer Objects List </li>
 * <li>Build the TimeSerie </li>
 * 
 * </ul>
 * @author merhebp
 *
 */
@Service
public class LouxorCandleReader implements ICandleReader {

	private static Logger logger = Logger.getLogger(LouxorCandleReader.class);
	
	
	public LouxorCandleReader() {
		
	}


	public CandleSerie fetchAllCandle(String instrumentId) throws MarketDataReaderException {
		// TODO Auto-generated method stub
		return null;
	}


	public CandleSerie fetchAllCandle(String instrumentId, DateTime start, DateTime end) throws MarketDataReaderException {
		// TODO Auto-generated method stub
		return null;
	}


	public Candle fetchCandle(String instrumentId, DateTime date) throws MarketDataReaderException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	


	
}
