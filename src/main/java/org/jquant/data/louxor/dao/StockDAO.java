package org.jquant.data.louxor.dao;



import java.util.List;

import org.hibernate.Query;
import org.jquant.data.louxor.model.CandleDTO;
import org.jquant.data.louxor.model.StockTicker;
import org.springframework.stereotype.Repository;

/**
 * DAO pour les tickers de Equity Stocks
 * @author patrick.merheb
 *
 */
@Repository
public class StockDAO extends BaseDAO<StockTicker,String> {

	
	
	public StockDAO() {
		super(StockTicker.class);
	}
	
	/**
	 * Le code interne de Louxor pour les stocks est l'ISIN 
	 * @param isin L'identifiant ISIN du Stock
	 * @param micCode Le code MIC du marché sur lequel est côté l'instrument
	 * @return un {@link StockTicker}
	 */
	public StockTicker findByISIN(String isin,String  micCode){
		String hqlQueryString = "from StockTicker st where st.internalCode = :isin and micCode = :mic ";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("mic", micCode)
								.setParameter("isin", isin);
		
		return (StockTicker) query.uniqueResult();
	}
	
	/**
	 * Retourne l'historique d'un stock 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link List} de {@link CandleDTO} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		String sqlQueryString = "select * from candle_stock cs where cs.ticker_id = :tickerId";
		Query query = getSession()
					.createSQLQuery(sqlQueryString)
					.addEntity(CandleDTO.class)
					.setParameter("tickerId", tickerId);
		
		return query.list();
	}
	
	

}
