package org.jquant.data.louxor;

import java.util.List;

import org.joda.time.DateTime;
import org.jquant.data.louxor.dao.StockCandleDAO;
import org.jquant.data.louxor.model.StockCandle;
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

	public List<StockCandle> readStockCandleHistory(String stockId, DateTime start, DateTime end) {
		
		return null;
	}

	
	public List<StockCandle> readStockCandleHistory(String stockId) {
		return stockDAO.listAll();
	}

	
	
}
