package org.jquant.data.louxor.dao;

import org.jquant.data.louxor.model.StockTicker;
import org.springframework.stereotype.Repository;

/**
 * DAO pour les tickers de Equity Stocks
 * @author patrick.merheb
 *
 */
@Repository
public class StockTickerDAO extends BaseDAO<StockTicker,String> {

	
	
	public StockTickerDAO() {
		super(StockTicker.class);
	}
	
	

}
