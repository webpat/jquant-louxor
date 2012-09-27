package org.jquant.data.louxor.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.joda.time.DateTime;
import org.jquant.data.louxor.model.FutureCandle;
import org.jquant.data.louxor.model.FutureTicker;
import org.springframework.stereotype.Repository;

@Repository
public class FutureDAO extends BaseDAO<FutureTicker, String> {

	public FutureDAO() {
		super(FutureTicker.class);
	}
	
	
	/**
	 * Retourne tous les futures dont l'underlying est identifié par code
	 * en ordre chronologique 
	 * <p> 
	 * @param name Future Short Name (Without Delivery Month/Year ) (ex: CRUDE OIL) 
	 * @param micCode MIC (XNYM, XCBT ...)
	 * @param start 
	 * @param end 
	 * @return une Collection de {@link FutureTicker}
	 */
	@SuppressWarnings("unchecked")
	public List<FutureTicker> findAllByExactName(String name,String  micCode,DateTime start, DateTime end){
		String hqlQueryString = "from FutureTicker ft where ft.shortName = :name  and ft.micCode = :mic " +
								"and firstDeliveryDate != null and ft.firstQuote >= :start and ft.lastQuote <= :end order by firstDeliveryDate asc";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("mic", micCode)
								.setParameter("name", name + " ("+micCode+")")
								.setParameter("start", start.toDate())
								.setParameter("end", end.toDate());
		
		return query.list();
	}
	
	/**
	 * Retourne l'historique d'un future 
	 * @param tickerId L'identifiant du Ticker
	 * @return une {@link List} de {@link CandleDTO} appartenant tous au Ticker identifié par tickerId
	 */
	@SuppressWarnings("unchecked")
	public List<FutureCandle> findAllCandleByTickerId(String tickerId){
		
		String hqlQueryString = "from FutureCandle fc where fc.tickerId = :tickerId";
		Query query = getSession().createQuery(hqlQueryString)
								.setParameter("tickerId", tickerId);
		
		return query.list();
	}

	/**
	 * 
	 * @param name {@link String} Future Short Name 
	 * @param micCode {@link String} MIC (ex XNYM)
	 * @param year {@link Integer} year of Delivery 
	 * @param month {@link Integer} {@link Calendar#MONTH} of delivery 
	 * @return {@link FutureTicker}
	 */
	public FutureTicker find(String name, String micCode, Integer year, Integer month) {
		// TODO Bananananana
		return null;
	}

}
