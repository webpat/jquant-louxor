/**
 * 
 */
package org.jquant.data.louxor.dao;


import org.jquant.data.louxor.model.LouxorProvider;
import org.jquant.data.louxor.model.StockTicker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author patrick.merheb
 * Classe de test unitaire de la classe {@link StockTickerDAO}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class StockTickerDAOTest {

	// Object under test 
	@Autowired
	private StockTickerDAO dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testGetByPrimaryKey(){
		
		
		
		String primaryKey = "1384";
		StockTicker ticker = dao.get(primaryKey);
		Assert.assertNotNull(ticker);
		
	}
	
	@Test
	public void testGetByIsin(){
		String isin = "JP3160400002";
//		String mic = "XTKS";	
		
		StockTicker ticker = dao.findByISIN(isin, LouxorProvider.BLOOMBERG);
		Assert.assertNotNull(ticker);
		
		
	}
	
	
	
}
