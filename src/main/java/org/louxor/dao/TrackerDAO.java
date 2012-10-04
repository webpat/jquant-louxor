package org.louxor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.StringType;
import org.louxor.model.CandleDTO;
import org.louxor.model.TrackerTicker;
import org.springframework.stereotype.Repository;

@Repository
public class TrackerDAO extends BaseDAO<TrackerTicker, String> {

	public TrackerDAO() {
		super(TrackerTicker.class);
	}
	
	/**
	 * Le code interne 'INTERNAL_CODE' de Louxor pour les trackers est l'ISIN 
	 * @param isin L'identifiant ISIN du Tracker
	 * @return un {@link TrackerTicker}
	 */
	public TrackerTicker findByISIN(String isin){
		String hqlQueryString = "from TrackerTicker st where st.internalCode = :isin ";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("isin", isin);
		
		return (TrackerTicker) query.uniqueResult();
	}
	
	/**
	 * Le code interne 'INTERNAL_CODE' de Louxor pour les tracker est l'ISIN 
	 * @param isin L'identifiant ISIN du Stock
	 * @return {@link String} le tickerId du tracker recheché 
	 */
	public String findTickerIdByISIN(String isin){
		String sqlQueryString = "select ts.ticker_id from ticker_tracker ts where ts.internal_code = :isin";
		Query query = getSession().createSQLQuery(sqlQueryString)
								.addScalar("ticker_id", StringType.INSTANCE)
								.setParameter("isin", isin);
		
		return (String) query.uniqueResult();
	}
	
	/**
	 * Retourne l'historique d'un stock 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link List} de {@link CandleDTO} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		String sqlQueryString = "select * from candle_tracker cs where cs.ticker_id = :tickerId";
		Query query = getSession()
					.createSQLQuery(sqlQueryString)
					.addEntity(CandleDTO.class)
					.setParameter("tickerId", tickerId);
		
		return query.list();
	}

}
