package org.jquant.data.louxor.adapter;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jquant.data.IMarketDataProviderAdapter;
import org.jquant.data.JQuantDataProvider;
import org.jquant.data.louxor.LouxorFacade;
import org.jquant.instrument.Future;
import org.jquant.instrument.GenericFuture;
import org.jquant.model.InstrumentId;
import org.jquant.model.InstrumentType;
import org.jquant.model.StitchingMethod;
import org.jquant.serie.Candle;
import org.jquant.serie.CandleSerie;
import org.jquant.serie.QuoteSerie;
import org.jquant.time.calendar.Periods;
import org.louxor.model.CandleDTO;
import org.louxor.model.FutureTicker;
import org.springframework.stereotype.Component;

/**
 * Will be instanciated by Spring and used at runtime depending on the Provider reader used 
 * @author patrick.merheb
 */
@Component
public class LouxorAdapter implements IMarketDataProviderAdapter {

	
	public boolean supports(Object reader) {
		return reader instanceof LouxorFacade ;
	}

	public CandleSerie readCandleSerie(InstrumentId symbol, DateTime start, DateTime end, Object reader) {
		List<CandleDTO> histo;
		switch (symbol.getType()){
		case BOND:
			throw new UnsupportedOperationException();
		case EQUITY:
			
			histo = ((LouxorFacade)reader).readStockCandleHistory(symbol.getCode(),symbol.getExchange().getCode(), start, end);
			return assembleCandles(histo);
		case FOREX:
			throw new UnsupportedOperationException();
		case FUND:
			throw new UnsupportedOperationException();
		case FUTURE:
			histo = ((LouxorFacade)reader).readFutureCandleHistoryByName(symbol.getCode());
			return assembleCandles(histo);
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
			List<CandleDTO> histo = ((LouxorFacade)reader).readStockCandleHistory(symbol.getCode(),symbol.getExchange().getCode());
			return assembleCandles(histo);
		case FOREX:
			throw new UnsupportedOperationException();
		case FUND:
			throw new UnsupportedOperationException();
		case FUTURE:
			histo = ((LouxorFacade)reader).readFutureCandleHistoryByName(symbol.getCode());
			return assembleCandles(histo);
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

	

	@Override
	public GenericFuture readGenericFuture(InstrumentId future, DateTime start, DateTime end, Object reader) {
	
		GenericFuture gf = new GenericFuture(future);
		List<FutureTicker> futures = ((LouxorFacade)reader).findAllFutureByShortName(future.getCode(), future.getExchange().getCode(), start, end);
		
		for (FutureTicker ticker : futures){
			List<CandleDTO> candles = ((LouxorFacade)reader).readFutureCandleHistoryByTickerId(ticker.getTickerId());
			Future fut = new Future(new InstrumentId(JQuantDataProvider.LOUXOR, ticker.getShortName(), InstrumentType.FUTURE, future.getExchange(), future.getCurrency()));
			fut.setLastDeliveryDate(ticker.getLastDeliveryDate());
			fut.setFirstDeliveryDate(ticker.getFirstDeliveryDate());
			CandleSerie serie = assembleCandles(candles);
			gf.add(fut, serie);
		}
		
		gf.stitch(StitchingMethod.RETURN_ADJUSTED);
		
		return gf;
	}
	
	private CandleSerie assembleCandles(List<CandleDTO> histo) {
		
		CandleSerie cs = new CandleSerie();
	
		if (histo != null){
			for(CandleDTO candle : histo){
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
}
