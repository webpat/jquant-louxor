package org.jquant.data.louxor.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jquant.data.louxor.model.CandleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CandleDAO extends HibernateDaoSupport {

	/**
	 * Initialise la {@link SessionFactory}.
	 * 
	 * @param sessionFactory
	 *            La session factory d'Hibernate (donnée par Spring).
	 */
	@Autowired
	public void initSessionFactory(
			@Qualifier("sessionFactory") final SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public List<CandleDTO> findAllCandleByTickerId(String tickerId){
		
		
		return null;
		
	}
	
	
}
