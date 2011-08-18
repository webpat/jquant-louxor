package org.jquant.data.louxor.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.jquant.data.louxor.model.StockCandle;
import org.springframework.stereotype.Repository;

@Repository
public class StockCandleDAO extends BaseDAO<StockCandle,String> {

	public StockCandleDAO() {
		super(StockCandle.class);
	}
	
	
	/**
	 * 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link Collection} de {@link StockCandle} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<StockCandle> findAllByTickerId(String tickerId){
		
		String hqlQueryString = "from StockCandle sc where sc.tickerId = :tickerId";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("tickerId", tickerId);
		
		return query.list();
	}

}
