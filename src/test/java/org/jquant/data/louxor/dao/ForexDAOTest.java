package org.jquant.data.louxor.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.louxor.dao.ForexDAO;
import org.louxor.model.CandleDTO;
import org.louxor.model.ForexTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class ForexDAOTest {

	@Autowired
	private ForexDAO dao;
	
	@Test
	public void testFindByName() {
		ForexTicker ticker = dao.findByName("GBPUSD");
		Assert.assertNotNull(ticker);
	}

	@Test
	public void testFindTickerIdByName() {
		String tickerId = dao.findTickerIdByName("GBPUSD");
		Assert.assertEquals("155", tickerId);
	}

	@Test
	public void testFindAllCandleByTickerId() {
		String tickerId = "155"; //GBPUSD aka the cable
		List<CandleDTO> result = dao.findAllCandleByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
		for (CandleDTO candle: result){
			Assert.assertTrue(candle.getHigh()>=candle.getLow());
		}
	}

}
