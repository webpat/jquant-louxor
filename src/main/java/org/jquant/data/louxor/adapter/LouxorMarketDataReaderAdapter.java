package org.jquant.data.louxor.adapter;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jquant.data.MarketDataReaderAdapter;
import org.jquant.data.louxor.MarketDataReader;
import org.jquant.data.louxor.model.StockCandle;
import org.jquant.model.Candle;
import org.jquant.model.Symbol;
import org.jquant.serie.CandleSerie;
import org.jquant.serie.QuoteSerie;
import org.jquant.time.calendar.Periods;
import org.springframework.stereotype.Component;

/**
 * Will be instanciated by Spring and used at runtime depending on the Provider reader used 
 * @author patrick.merheb
 */
@Component
public class LouxorMarketDataReaderAdapter implements MarketDataReaderAdapter {

	
	public boolean supports(Object reader) {
		return reader instanceof MarketDataReader ;
	}

	public CandleSerie readCandleSerie(Symbol symbol, DateTime start, DateTime end, Object reader) {
		switch (symbol.getType()){
		case BOND:
			throw new UnsupportedOperationException();
		case EQUITY:
			List<StockCandle> histo = ((MarketDataReader)reader).readStockCandleHistory(symbol.getCode(), start, end);
			return assembleCandles(histo);
		case FOREX:
			throw new UnsupportedOperationException();
		case FUND:
			throw new UnsupportedOperationException();
		case FUTURE:
			throw new UnsupportedOperationException();
		case INDEX:
			throw new UnsupportedOperationException();
		case OPTION:
			throw new UnsupportedOperationException();
		case SWAP:
			throw new UnsupportedOperationException();
		case TIME_DEPOSIT:
			throw new UnsupportedOperationException();
		case TRACKER:
			throw new UnsupportedOperationException();
		case UNKNOWN:
			throw new UnsupportedOperationException();
		case WARRANT:
			throw new UnsupportedOperationException();
		
		}
		return null;
	}


	public CandleSerie readCandleSerie(Symbol symbol, Object reader) {
		switch (symbol.getType()){
		case BOND:
			throw new UnsupportedOperationException();
		case EQUITY:
			List<StockCandle> histo = ((MarketDataReader)reader).readStockCandleHistory(symbol.getCode());
			return assembleCandles(histo);
		case FOREX:
			throw new UnsupportedOperationException();
		case FUND:
			throw new UnsupportedOperationException();
		case FUTURE:
			throw new UnsupportedOperationException();
		case INDEX:
			throw new UnsupportedOperationException();
		case OPTION:
			throw new UnsupportedOperationException();
		case SWAP:
			throw new UnsupportedOperationException();
		case TIME_DEPOSIT:
			throw new UnsupportedOperationException();
		case TRACKER:
			throw new UnsupportedOperationException();
		case UNKNOWN:
			throw new UnsupportedOperationException();
		case WARRANT:
			throw new UnsupportedOperationException();
		
		}
		return null;
	}

	public QuoteSerie readQuoteSerie(Symbol symbol, Object reader) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public QuoteSerie readQuoteSerie(Symbol symbol, DateTime start, DateTime end, Object reader) {
		// TODO Auto-generated method stub
		return null;
	}

	private CandleSerie assembleCandles(List<StockCandle> histo) {
		
		CandleSerie cs = new CandleSerie();
	
		if (histo != null){
			for(StockCandle candle : histo){
				DateTime dt = new DateTime(candle.getTimestamp(), DateTimeZone.getDefault());
				cs.addValue(dt, 
						new Candle( dt, 
								Periods.ONE_DAY,
								candle.getOpen(),
								candle.getHigh(),
								candle.getLow(),
								candle.getClose(),
								candle.getVolume())
				);
			}
		}
		return cs;
	}
	
}
