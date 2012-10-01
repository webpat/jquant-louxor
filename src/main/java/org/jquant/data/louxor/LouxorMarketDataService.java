package org.jquant.data.louxor;

import java.util.List;

import org.joda.time.DateTime;
import org.jquant.data.louxor.dao.FutureDAO;
import org.jquant.data.louxor.dao.StockDAO;
import org.jquant.data.louxor.model.CandleDTO;
import org.jquant.data.louxor.model.FutureTicker;
import org.jquant.data.louxor.model.StockTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Louxor specific MarketData Reader
 * <p>
 * NB: Dans notre cas le Louxor LouxorMarketDataService a été conçu en même temps que JQUANT, ce qui explique l'analogie au niveau du nommage des Structures de données.
 *  
 * @author patrick.merheb
 *
 */
@Service
public class LouxorMarketDataService {
	
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
	 * @return a Collection of {@link StockCandle} or <code>null</code>
	 */
	public List<CandleDTO> readStockCandleHistory(String providerCode,String micCode, DateTime start, DateTime end) {
		
		StockTicker ticker = stockDAO.findByISIN(providerCode,micCode);
		
		if (ticker != null){
			return stockDAO.findAllCandleByTickerId(ticker.getTickerId());
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
		StockTicker ticker = stockDAO.findByISIN(providerCode,micCode);
		
		if (ticker != null){
			return stockDAO.findAllCandleByTickerId(ticker.getTickerId());
		}else {
			return null;
		}
	}

	
	/**
	 * @param name Future Name
	 * @param micCode The Mic Code (XPAR, XFRA ...)
	 * @param year 
	 * @param month calendar Month 1: January, 2:Febr ....
	 * @return a Collection of {@link FutureCandle} or <code>null</code>
	 */
	public List<CandleDTO> readFutureCandleHistory(String name,String micCode, int year, int month) {
		
		FutureTicker ticker = futureDAO.find(name, micCode, year, month);
		
		if (ticker != null){
			return futureDAO.findAllCandleByTickerId(ticker.getTickerId());
		}else {
			return null;
		}
	}


	
	
}
