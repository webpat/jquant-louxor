package org.jquant.data.louxor.tools;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.jquant.data.reader.ICandleReader;
import org.jquant.exception.MarketDataReaderException;
import org.jquant.model.Candle;
import org.jquant.serie.CandleSerie;
import org.springframework.stereotype.Service;
/**
 * Louxor specific TimeSerie reader
 * <p> 
 * Fetch methods transforms the List/Vector of TimeValues (Quote,Rate,Candle) 
 * in TIME INDEXED TimeSeries 
 * 
 * @author merhebp
 *
 */
@Service
public class LouxorCandleReader implements ICandleReader {

	private static Logger logger = Logger.getLogger(LouxorCandleReader.class);
	
	
	public LouxorCandleReader() {
		
	}


	public CandleSerie fetchAllCandle(String instrumentId) throws MarketDataReaderException {
		
		List<Candle> candleList = null;
		// TODO LOAD Daily CANDLES from database 
		
		CandleSerie serie = new CandleSerie(candleList);
		
		return serie;
	}


	public CandleSerie fetchAllCandle(String instrumentId, DateTime start, DateTime end) throws MarketDataReaderException {
		List<Candle> candleList = null;
		// TODO LOAD Daily CANDLES from database from to  
		
		CandleSerie serie = new CandleSerie(candleList);
		
		return serie;
	}


	public Candle fetchCandle(String instrumentId, DateTime date) throws MarketDataReaderException {
		
		// TODO LOAD Daily CANDLES from database @ 
		return null;
	}
	
	

	


	
}
