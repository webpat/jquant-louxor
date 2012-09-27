package org.jquant.data.louxor.adapter;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jquant.data.IMarketDataProviderAdapter;
import org.jquant.data.louxor.MarketDataReader;
import org.jquant.data.louxor.model.StockCandle;
import org.jquant.instrument.GenericFuture;
import org.jquant.model.InstrumentId;
import org.jquant.serie.Candle;
import org.jquant.serie.CandleSerie;
import org.jquant.serie.QuoteSerie;
import org.jquant.time.calendar.Periods;
import org.springframework.stereotype.Component;

/**
 * Will be instanciated by Spring and used at runtime depending on the Provider reader used 
 * @author patrick.merheb
 */
@Component
public class LouxorMarketDataProviderAdapter implements IMarketDataProviderAdapter {

	
	public boolean supports(Object reader) {
		return reader instanceof MarketDataReader ;
	}

	public CandleSerie readCandleSerie(InstrumentId symbol, DateTime start, DateTime end, Object reader) {
		switch (symbol.getType()){
		case BOND:
			throw new UnsupportedOperationException();
		case EQUITY:
			List<StockCandle> histo = ((MarketDataReader)reader).readStockCandleHistory(symbol.getCode(),symbol.getExchange().getCode(), start, end);
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


	public CandleSerie readCandleSerie(InstrumentId symbol, Object reader) {
		switch (symbol.getType()){
		case BOND:
			throw new UnsupportedOperationException();
		case EQUITY:
			List<StockCandle> histo = ((MarketDataReader)reader).readStockCandleHistory(symbol.getCode(),symbol.getExchange().getCode());
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

	public QuoteSerie readQuoteSerie(InstrumentId symbol, Object reader) {
		return null;
	}
	
	public QuoteSerie readQuoteSerie(InstrumentId symbol, DateTime start, DateTime end, Object reader) {
		return null;
	}

	private CandleSerie assembleCandles(List<StockCandle> histo) {
		
		CandleSerie cs = new CandleSerie();
	
		if (histo != null){
			for(StockCandle candle : histo){
				DateTime dt = new DateTime(candle.getTimestamp(), DateTimeZone.getDefault());
				cs.addValue( 
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

	@Override
	public GenericFuture readGenericFuture(InstrumentId future, DateTime start, DateTime end, Object reader) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
