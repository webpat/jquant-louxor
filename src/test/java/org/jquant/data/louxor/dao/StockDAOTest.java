package org.jquant.data.louxor.dao;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.louxor.dao.StockDAO;
import org.louxor.model.CandleDTO;
import org.louxor.model.StockTicker;
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
		List<CandleDTO> result = dao.findAllCandleByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
		for (CandleDTO candle: result){
			Assert.assertTrue(candle.getHigh()>=candle.getLow());
		}
	}
	
	@Test
	public void testGetByPrimaryKey(){
		
		
		
		String primaryKey = "2276";
		StockTicker ticker = dao.get(primaryKey);
		Assert.assertNotNull(ticker);
		
	}
	
	@Test
	public void testFindTickerIdByIsin(){
	
		String isin = "JP3160400002";
		String mic = "XTKS";	
		String tickerId = dao.findTickerIdByISIN(isin, mic);
		Assert.assertTrue(StringUtils.isNotBlank(tickerId));
	}
	
	@Test
	public void testGetByIsin(){
		String isin = "JP3160400002";
		String mic = "XTKS";	
		
		StockTicker ticker = dao.findByISIN(isin,mic);
		Assert.assertNotNull(ticker);
		
		
	}

}
