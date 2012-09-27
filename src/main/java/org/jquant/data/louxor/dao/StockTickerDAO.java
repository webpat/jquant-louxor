package org.jquant.data.louxor.dao;



import org.hibernate.Query;
import org.jquant.data.louxor.model.LouxorProvider;
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
	
	/**
	 * Le code interne de Louxor pour les stocks est l'ISIN 
	 * @param isin L'identifiant ISIN du Stock
	 * @param micCode Le code MIC du marché sur lequel est côté l'instrument
	 * @param provider {@link LouxorProvider}
	 * @return un {@link StockTicker}
	 */
	public StockTicker findByISIN(String isin,String  micCode){
		String hqlQueryString = "from StockTicker st where st.internalCode = :isin and micCode = :mic";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("mic", micCode)
								.setParameter("isin", isin);
		
		return (StockTicker) query.uniqueResult();
	}
	
	

}
