package org.jquant.data.louxor;

import java.util.List;

import org.joda.time.DateTime;
import org.louxor.dao.FutureDAO;
import org.louxor.dao.StockDAO;
import org.louxor.model.CandleDTO;
import org.louxor.model.FutureTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Louxor legacy MarketData Facade
 * <p>
 * NB: Dans notre cas le Louxor LouxorFacade a été conçu en même temps que JQUANT, ce qui explique l'analogie au niveau du nommage des Structures de données.
 *  
 * @author patrick.merheb
 *
 */
@Service
public class LouxorFacade {
	
	@Autowired
	private StockDAO stockDAO;
	
	
	@Autowired
	private FutureDAO futureDAO;

	/**
	 * FIXME : Tri des StockCandle, prendre en compte les dates 
	 * @param providerCode (MSFT, GOOGL ...)
	 * @param micCode The Mic Code (XPAR, XFRA ...)
	 * @param start
	 * @param end
	 * @return a Collection of {@link CandleDTO} or <code>null</code>
	 */
	public List<CandleDTO> readStockCandleHistory(String providerCode,String micCode, DateTime start, DateTime end) {
		
		String tickerId = stockDAO.findTickerIdByISIN(providerCode,micCode);
		
		if (tickerId != null){
			return stockDAO.findAllCandleByTickerId(tickerId); //FIXME : Prise en compte de start et end 
		}else {
			return null;
		}
	}

	
	/**
	 * For Stocks the identifier Code is the ISIN in Louxor 
	 * @param providerCode (MSFT, GOOGL ...)
	 * @param micCode The Mic Code (XPAR, XFRA ...)
	 * @return a Collection of {@link CandleDTO} or <code>null</code>
	 */
	public List<CandleDTO> readStockCandleHistory(String providerCode,String micCode) {
		String tickerId = stockDAO.findTickerIdByISIN(providerCode,micCode);
		
		if (tickerId != null){
			return stockDAO.findAllCandleByTickerId(tickerId);
		}else {
			return null;
		}
	}

	
	/**
	 * @param name Future Name ex: 'US 30Y BOND (XCBT) Mar78'
	 * @return a Collection of {@link CandleDTO} or <code>null</code>
	 */
	public List<CandleDTO> readFutureCandleHistoryByName(String name) {
		
		String tickerId = futureDAO.findTickerId(name);
		
		if (tickerId != null){
			return futureDAO.findAllCandleByTickerId(tickerId);
		}else {
			return null;
		}
	}
	
	/**
	 * @param tickerId Future tickerId 
	 * @return a Collection of {@link CandleDTO} or <code>null</code>
	 */
	public List<CandleDTO> readFutureCandleHistoryByTickerId(String tickerId) {
		
		
		if (tickerId != null){
			return futureDAO.findAllCandleByTickerId(tickerId);
		}else {
			return null;
		}
	}

	/**
	 * Returns the list of future tickers with shortName between start and end
	 * @param shortName
	 * @param micCode
	 * @param start
	 * @param end
	 * @return A collection of {@link FutureTicker}
	 */
	public List<FutureTicker> findAllFutureByShortName(String shortName, String micCode, DateTime start, DateTime end){
		return futureDAO.findAllFuture(shortName, micCode, start, end);
	}

	
	
}
