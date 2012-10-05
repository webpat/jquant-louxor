package org.louxor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.StringType;
import org.louxor.model.CandleDTO;
import org.louxor.model.IndexTicker;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDAO extends BaseDAO<IndexTicker, String> {

	public IndexDAO() {
		super(IndexTicker.class);
	}
	
	/**
	 * Find a IndexTicker by its name
	 * @param name  Name of the index : ex CAC40, EUROSTOXX50...
	 * @return a {@link IndexTicker}
	 */
	public IndexTicker findByName(String name){
		String hqlQueryString = "from IndexTicker it where it.name = :name";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("name", name);
		
		return (IndexTicker) query.uniqueResult();
	}
	
	/**
	 * Find a Index TickerId by its name
	 * @param name Name of the index :  ex CAC40, EUROSTOXX50 ...
	 * @return {@link String} le tickerId du stock recheché 
	 */
	public String findTickerIdByName(String name){
		String sqlQueryString = "select ti.ticker_id from ticker_index ti where ti.name = :name";
		Query query = getSession().createSQLQuery(sqlQueryString)
								.addScalar("ticker_id", StringType.INSTANCE)
								.setParameter("name", name);
		
		return (String) query.uniqueResult();
	}
	
	/**
	 * Retourne l'historique d'un indice de marché 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link List} de {@link CandleDTO} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		String sqlQueryString = "select *,0 as OPEN_INTEREST, 0 as VOLUME, 0 as VWAP from candle_index ci where ci.ticker_id = :tickerId";
		Query query = getSession()
					.createSQLQuery(sqlQueryString)
					.addEntity(CandleDTO.class)
					.setParameter("tickerId", tickerId);
		
		return query.list();
	}

}
