package org.jquant.data.louxor.dao;


import java.util.List;

import org.jquant.data.louxor.model.StockCandle;
import org.jquant.data.louxor.model.StockTicker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class StockDAOTest {

	@Autowired
	private StockDAO dao;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindAllCandleByTickerId(){
		String tickerId = "97461";
		List<StockCandle> result = dao.findAllCandleByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
	}
	
	@Test
	public void testGetByPrimaryKey(){
		
		
		
		String primaryKey = "2276";
		StockTicker ticker = dao.get(primaryKey);
		Assert.assertNotNull(ticker);
		
	}
	
	@Test
	public void testGetByIsin(){
		String isin = "JP3160400002";
		String mic = "XTKS";	
		
		StockTicker ticker = dao.findByISIN(isin,mic);
		Assert.assertNotNull(ticker);
		
		
	}

}
