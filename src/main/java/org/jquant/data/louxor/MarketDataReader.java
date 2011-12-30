package org.jquant.data.louxor;

import java.util.List;

import org.joda.time.DateTime;
import org.jquant.data.louxor.dao.StockCandleDAO;
import org.jquant.data.louxor.dao.StockTickerDAO;
import org.jquant.data.louxor.model.LouxorProvider;
import org.jquant.data.louxor.model.StockCandle;
import org.jquant.data.louxor.model.StockTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Louxor specific MarketData Reader
 * <p>
 * NB: Dans notre cas le Louxor MarketDataReader a été conçu en même temps que JQUANT, ce qui explique l'analogie au niveau du nommage des Structures de données.
 *  
 * @author patrick.merheb
 *
 */
@Repository
public class MarketDataReader {
	
	@Autowired
	private StockCandleDAO stockDAO;
	
	@Autowired
	private StockTickerDAO stockTickerDAO;
	

	/**
	 * FIXME : Tri des StockCandle, prendre en compte les dates 
	 * @param providerCode
	 * @param start
	 * @param end
	 * @return a Collection of {@link StockCandle}
	 */
	public List<StockCandle> readStockCandleHistory(String providerCode, DateTime start, DateTime end) {
		
		StockTicker ticker = stockTickerDAO.findByISIN(providerCode, LouxorProvider.BLOOMBERG);
		return stockDAO.findAllByTickerId(ticker.getTickerId());
	}

	
	/**
	 * 
	 * @param providerCode
	 * @return a Collection of {@link StockCandle}
	 */
	public List<StockCandle> readStockCandleHistory(String providerCode) {
		StockTicker ticker = stockTickerDAO.findByISIN(providerCode, LouxorProvider.BLOOMBERG);
		return stockDAO.findAllByTickerId(ticker.getTickerId());
	}

	
	
}
