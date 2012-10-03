package org.louxor.dao;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.type.StringType;
import org.joda.time.DateTime;
import org.louxor.model.CandleDTO;
import org.louxor.model.FutureTicker;
import org.springframework.stereotype.Repository;

@Repository
public class FutureDAO extends BaseDAO<FutureTicker, String> {

	DateFormatSymbols dfs = DateFormatSymbols.getInstance(Locale.US);
	String[] monthNames = dfs.getShortMonths();
	
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
	public List<FutureTicker> findAllFuture(String name,String  micCode,DateTime start, DateTime end){
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
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		String sqlQueryString = "select * from candle_future cf where cf.ticker_id = :tickerId";
		Query query = getSession()
					.createSQLQuery(sqlQueryString)
					.addEntity(CandleDTO.class)
					.setParameter("tickerId", tickerId);
		
		return query.list();
	}
	
	/**
	 * @param shortName {@link String} Future Short Name 
	 * @param micCode {@link String} MIC (ex XNYM)
	 * @param year @link Integer} year of Delivery 
	 * @param month {@link Integer} {@link Calendar#MONTH}+1 of delivery 
	 * @return {@link String} le tickerId du future recheché 
	 */
	public String findTickerId(String shortName, String micCode, Integer year, Integer month){
		String sqlQueryString = "select tf.ticker_id from ticker_future tf where tf.name = :name and tf.mic_code = :mic";
		Query query = getSession().createSQLQuery(sqlQueryString)
								.addScalar("ticker_id", StringType.INSTANCE)
								.setParameter("mic", micCode)
								.setParameter("name", shortName + " ("+micCode+") " + monthNames[month-1]+ StringUtils.substring(String.valueOf(year),2) );
		
		return (String) query.uniqueResult();
	}
	

	/**
	 * 
	 * @param shortName {@link String} Future Short Name 
	 * @param micCode {@link String} MIC (ex XNYM)
	 * @param year {@link Integer} year of Delivery 
	 * @param month {@link Integer} {@link Calendar#MONTH} of delivery 
	 * @return {@link FutureTicker}
	 */
	public FutureTicker find(String shortName, String micCode, Integer year, Integer month) {
		String hqlQueryString = "from FutureTicker ft where ft.name = :name  and ft.micCode = :mic " +
				"and firstDeliveryDate != null";
		
		
		Query query = getSession().createQuery(hqlQueryString)
				.setParameter("mic", micCode)
				.setParameter("name", shortName + " ("+micCode+") " + monthNames[month-1]+ StringUtils.substring(String.valueOf(year),2) );

		return (FutureTicker) query.uniqueResult();
	}
	
	
	/**
	 * Retreives a future with its exact name 
	 * @param name {@link String} Future Name US 30Y BOND (XCBT) Mar78  
	 * @return {@link String} the tickerId of the Future 
	 */
	public String findTickerId(String name){
		String sqlQueryString = "select tf.ticker_id from ticker_future tf where tf.name = :name";
		Query query = getSession().createSQLQuery(sqlQueryString)
								.addScalar("ticker_id", StringType.INSTANCE)
								.setParameter("name", name);
		
		return (String) query.uniqueResult();
	}
	

	/**
	 * Retreives a future with its exact name 
	 * @param name {@link String} Future Name ex: US 30Y BOND (XCBT) Mar78  
	 * @return {@link FutureTicker} the FutureTicker Entity
	 */
	public FutureTicker find(String name) {
		String hqlQueryString = "from FutureTicker ft where ft.name = :name  and ft.micCode = :mic " +
				"and firstDeliveryDate != null";
		
		
		Query query = getSession().createQuery(hqlQueryString)
				.setParameter("name",name);

		return (FutureTicker) query.uniqueResult();
	}

}
