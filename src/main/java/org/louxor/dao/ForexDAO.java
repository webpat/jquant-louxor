package org.louxor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.StringType;
import org.louxor.model.CandleDTO;
import org.louxor.model.ForexTicker;
import org.springframework.stereotype.Repository;

@Repository
public class ForexDAO extends BaseDAO<ForexTicker, String> {

	public ForexDAO() {
		super(ForexTicker.class);
	}

	/**
	 * Find a ForexTicker by its name
	 * @param name Name of the forex pair ex: EURUSF, CADUSD ...
	 * @return a {@link ForexTicker}
	 */
	public ForexTicker findByName(String name){
		String hqlQueryString = "from ForexTicker ft where ft.internalCode = :name";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("name", name);
		
		return (ForexTicker) query.uniqueResult();
	}
	
	/**
	 * Find a Forex Ticker id  by its name
	 * @param name Name of the forex pair ex: EURUSF, CADUSD ...
	 * @return {@link String} le tickerId du stock recheché 
	 */
	public String findTickerIdByName(String name){
		String sqlQueryString = "select tf.ticker_id from ticker_forex tf where tf.name = :name";
		Query query = getSession().createSQLQuery(sqlQueryString)
								.addScalar("ticker_id", StringType.INSTANCE)
								.setParameter("name", name);
		
		return (String) query.uniqueResult();
	}
	
	/**
	 * Retourne l'historique d'une paire FOREX 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link List} de {@link CandleDTO} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		String sqlQueryString = "select * from candle_forex cf where cf.ticker_id = :tickerId";
		Query query = getSession()
					.createSQLQuery(sqlQueryString)
					.addEntity(CandleDTO.class)
					.setParameter("tickerId", tickerId);
		
		return query.list();
	}
	
}
